package com.nirima.libvirt.xdr;

import com.nirima.libvirt.Connection;
import com.nirima.libvirt.util.Utils;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.UUID;

/**
 * @author Nigel Magnay
 */
public class XDR {

    private static class AnnotationHelper {
        private final Annotation[] annotations;

        private AnnotationHelper(Annotation[] annotations) {
            if( annotations == null )
                this.annotations = new Annotation[0];
            else
                this.annotations = annotations;
        }

        public int getLength() {
            for( Annotation annotation : annotations ) {
                if( annotation.annotationType().equals(XDRField.class))
                    return ((XDRField)annotation).length();
            }

            throw new IllegalStateException("No @XDRField annotation where one expected.");
        }

        public boolean isNonNull() {
            for( Annotation anno : annotations ) {
                if( anno.annotationType().equals(Nonnull.class))
                    return true;
            }

            return false;
        }
    }


    public static <T> T readStruct(Class<T> k, XDRInputStream inputStream) throws IllegalAccessException, InstantiationException, IOException {

        T instance = k.newInstance();

        for (Field f : k.getDeclaredFields()) {

            Annotation[] annotations = f.getAnnotations();

            Class<?> type = f.getType();

            Object value = read(inputStream, type, annotations);

            f.set(instance, value);

        }

        return instance;
    }

    public static void writeStruct(Object instance, XDROutputStream xos) throws IllegalAccessException, IOException {
        Class<?> k = instance.getClass();

        for(Field f : k.getDeclaredFields() ) {
            Annotation[] annotations = f.getAnnotations();
            Class<?> type = f.getType();
            write(xos, f.get(instance), type, annotations);
        }
    }

    public static<T> T createInterface(Class<T> k, Connection connection) {
        return (T)Proxy.newProxyInstance(k.getClassLoader(), new Class[]{k}, new XDRInvocationHandler(k, connection));
    }

    public static Object read(XDRInputStream xis, Class<?> type) throws IOException, InstantiationException, IllegalAccessException {
        return read(xis, type, new Annotation[0]);
    }

    public static Object read(XDRInputStream xis, Class<?> type, Annotation[] annotations) throws IOException, InstantiationException, IllegalAccessException {
        AnnotationHelper ah = new AnnotationHelper(annotations);

        if (type.isArray()) {

            Class<?> arrayType = type.getComponentType();

            if (arrayType == int.class) {
                int items = xis.readInt();

                int[] array = new int[items];
                for( int i=0; i<items;i++)
                    array[i] = xis.readInt();
                return array;

            }
            else if (arrayType == String.class) {
                int items = xis.readInt();

                String[] array = new String[items];
                for( int i=0; i<items;i++)
                    array[i] = xis.readStringData();
                return array;

            }
            else if (arrayType == char.class) {
                    char[] array = new char[ah.getLength()];
                    xis.readCharArray(array);
                    return array;
            } else {
                throw new IllegalStateException("Don't know what to do with field " + type);
            }
        }
        else if( type == int.class || type == Integer.class ) {
            return xis.readInt();
        }
        else if( type == long.class || type == Long.class ) {
            return xis.readLong();
        }
        else if( type == short.class || type == Short.class ) {
            return xis.readShort();
        }
        else if( type == char.class || type == Character.class ) {
            return (char)xis.readInt();
        }
        else if( type == UUID.class ) {
            byte[] bytes  = new byte[16];
            xis.read(bytes);
            return Utils.UUIDfromByteArray(bytes);
        }
        else if( type == String.class ) {
            if( ah.isNonNull() )
                return xis.readStringData();
            else
                return xis.readString();
        } else {
            return readStruct(type, xis);
        }
    }

    public static void write(XDROutputStream xos, Object obj) throws IOException, IllegalAccessException {
        write(xos, obj, obj.getClass(), new Annotation[0]);
    }
    public static void write(XDROutputStream xos, Object obj, Class<?> k, Annotation[] annotations) throws IOException, IllegalAccessException {
        AnnotationHelper ah = new AnnotationHelper(annotations);

        if (k.isArray()) {

            Class<?> arrayType = k.getComponentType();

            if (arrayType == int.class) {
                int[] tobj = (int[])obj;
                xos.writeInt(tobj.length);

                for( int i=0; i<tobj.length;i++)
                    xos.writeInt(tobj[i]);

            }
            else if (arrayType == String.class) {
                String[] tobj = (String[])obj;

                xos.writeInt(tobj.length);

                for( int i=0; i<tobj.length;i++) {
                    xos.writeStringData(tobj[i]);
                }

            }
            else if (arrayType == char.class) {

                char[] tobj = (char[])obj;

                for( int i=0; i<ah.getLength();i++)
                    xos.writeInt(tobj[i]);

            } else {
                throw new IllegalStateException("Don't know what to do with field " + k);
            }
        }
        if( k == String.class )
        {
            if( ah.isNonNull() )
                xos.writeStringData((String) obj);
            else
                xos.writeString((String) obj);
        }
        else if( k == short.class || k == Short.class )
        {
            xos.writeShort((Short) obj);
        }
        else if( k == int.class || k == Integer.class )
        {
            xos.writeInt((Integer) obj);
        }
        else if( k == long.class || k == Long.class )
        {
            xos.writeLong((Long) obj);
        }
        else if( k == char.class || k == Character.class )
        {
            xos.writeInt((Character) obj);
        }
        else if( k == UUID.class ) {
            byte[] data = Utils.UUIDtoByteArray((UUID) obj);
            xos.write(data);
        }
        else
        {
            writeStruct(obj, xos);
        }

    }


}
