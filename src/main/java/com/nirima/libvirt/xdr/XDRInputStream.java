package com.nirima.libvirt.xdr;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * @author Nigel Magnay
 */
public class XDRInputStream extends DataInputStream {
    public XDRInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public char[] readCharArray(int length) throws IOException {
        return readCharArray(new char[length]);
    }

    public char[] readCharArray(char[] data) throws IOException {

        for( int i=0; i<data.length; i++ ) {
            int ch = readInt();
            data[i] = (char)ch;
        }

        return data;
    }

    public String readString() throws IOException {

        // 4 byte length word per header */ = ?
        //const VIR_NET_MESSAGE_HEADER_XDR_LEN = 4; =?
        int header = readInt();

        if( header == 0 )
            return null;

        int len = readInt();
        byte[] data = new byte[len];
        read(data);

        while(len%4 != 0)
        {
            byte padding = readByte();
            len++;
        }

        return new String(data);
    }

    public String readStringData() throws IOException {

        int len = readInt();
        byte[] data = new byte[len];
        read(data);

        while(len%4 != 0)
        {
            byte padding = readByte();
            len++;
        }

        return new String(data);
    }

}
