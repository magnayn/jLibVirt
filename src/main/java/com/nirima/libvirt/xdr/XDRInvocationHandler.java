package com.nirima.libvirt.xdr;

import com.nirima.libvirt.Connection;
import com.nirima.libvirt.Packet;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


/**
 * @author Nigel Magnay
 */
public class XDRInvocationHandler implements InvocationHandler {

    private final Connection connection;
    private final Class<?> theInterface;

    public XDRInvocationHandler(Class<?> theInterface, Connection connection) {
        this.connection = connection;
        this.theInterface = theInterface;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

        XDRMethod methodInfo = method.getAnnotation(XDRMethod.class);
        XDRInterface interfaceInfo = theInterface.getAnnotation(XDRInterface.class);

        int proc = methodInfo.proc();

        byte[] data = null;

        if( objects != null && objects.length > 0 ) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            XDROutputStream xos = new XDROutputStream(byteArrayOutputStream);

            for( int i=0; i<method.getParameterTypes().length; i++) {
                Object obj = objects[i];
                Class<?> k =  method.getParameterTypes()[i];
                Annotation[] annotations = method.getParameterAnnotations()[i];
                XDR.write(xos, obj, k, annotations);


            }

            xos.flush();
            data = byteArrayOutputStream.toByteArray();
        }


        Packet outboundPacket = new Packet(proc, data);
        outboundPacket.program = interfaceInfo.program();
        outboundPacket.version = interfaceInfo.version();

        // Encode outbound data

        Packet inboundPacket = connection.sendPacket(outboundPacket);

        Class<?> returnType = method.getReturnType();
        if( returnType != null && returnType != void.class ) {
            XDRInputStream xdrInputStream = new XDRInputStream(new ByteArrayInputStream(inboundPacket.data));
            return XDR.read(xdrInputStream, returnType);
        }

        return null;
    }
}
