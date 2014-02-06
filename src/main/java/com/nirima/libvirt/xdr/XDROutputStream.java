package com.nirima.libvirt.xdr;

import com.google.common.base.Preconditions;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;


/**
 * @author Nigel Magnay
 */
public class XDROutputStream extends DataOutputStream {
    public XDROutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public void writeString(String uri) throws IOException {
        int length = uri.length();

        if( uri == null ) {
            writeInt(0);
            return;
        }

        writeInt(1); // 1 entry
        writeInt(length);
        write(uri.getBytes("UTF-8"));
        while(length%4 != 0) {
            writeByte(0);
            length++;
        }
    }

    public void writeStringData(String uri) throws IOException {
        Preconditions.checkNotNull(uri, "String must not be null");

        int length = uri.length();
        writeInt(length);
        write(uri.getBytes("UTF-8"));
        while(length%4 != 0) {
            writeByte(0);
            length++;
        }
    }
}
