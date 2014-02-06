package com.nirima.libvirt;

import com.nirima.libvirt.util.Utils;
import com.nirima.libvirt.xdr.XDR;
import com.nirima.libvirt.xdr.XDRException;
import com.nirima.libvirt.xdr.XDRExceptionData;
import com.nirima.libvirt.xdr.XDRInputStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author Nigel Magnay
 */
public class Packet {

    private static AtomicInteger sequence = new AtomicInteger();

    public int len = 28;

    public int program = 0x20008086;

    public int version = 1;
    public int proc = 66;
    public int type = 0;
    public int status = 0;
    public int serial = sequence.addAndGet(1);

    public byte[] data;

    public Packet() {}

    public Packet(int type) {
        this.proc = type;
        this.len = 28;
    }

    public Packet(int i, byte[] data) {
        this.proc = i;
        this.data = data;
        this.len = 28 + (data==null?0:data.length);
    }

    public void write(DataOutputStream dos) throws IOException {
        dos.writeInt(len);

        dos.writeInt(program);
        dos.writeInt(version);
        dos.writeInt(proc);

        dos.writeInt(type);
        dos.writeInt(serial);
        dos.writeInt(status);

        if( data != null )
            dos.write(data);

        dos.flush();
    }

    public static Packet readPacket(XDRInputStream dataInputStream) throws IOException, InstantiationException, IllegalAccessException {
        Packet p = new Packet();

        p.len       = dataInputStream.readInt();
        p.program   = dataInputStream.readInt();
        p.version   = dataInputStream.readInt();
        p.proc      = dataInputStream.readInt();
        p.type      = dataInputStream.readInt();
        p.serial    = dataInputStream.readInt();
        p.status    = dataInputStream.readInt();


        if( p.status == 1 ) {
            throw new XDRException(XDR.readStruct(XDRExceptionData.class, dataInputStream));
        }

        int remain = p.len - 28;
        if( remain > 0 ) {
            p.data = new byte[p.len-28];
            dataInputStream.read(p.data);
        }

        return p;
    }

    @Override
    public String toString() {

        String sdata = "";
        if( data != null ) {
            //sdata = new String(data.clone());
            try{
                sdata = Utils.asHex(data);
            }catch(Exception ex) {
                ex.printStackTrace();
            }
        }

        return com.google.common.base.Objects.toStringHelper(this)
                .add("len", len)
                .add("program", program)
                .add("version", version)
                .add("proc", proc)
                .add("type", type)
                .add("status", status)
                .add("serial", serial)
                .add("data(str)", "\n" + sdata)
                .toString();
    }
}
