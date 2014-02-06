package com.nirima.libvirt.util;

import com.google.common.base.Joiner;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Nigel Magnay
 */
public class Utils {
    public static String asHex(byte[] data)
    {
        List<String> rows = new ArrayList<String>();

        for(int i=0; i<data.length; i+=16) {

            String h = "";
            String x = "";

            h = String.format("%04x | ", i);

            for( int j=0; j< 16; j++ ) {



                int idx = i+j;
                if( idx < data.length) {
                    byte b = data[idx];
                    h += String.format("%02x ", b);


                    if( b > 32)
                        x += String.format("%c", (char)b);
                    else
                        x += ".";

                }
                else
                {
                    h += "   ";
                    x += " ";
                }

                if( (j+1)%4 == 0 ) {
                    h += "  ";
                    x += " ";
                }



            }
            rows.add(h + " | " + x);
        }


        return Joiner.on("\n").join(rows);
    }

    public static byte[] UUIDtoByteArray(UUID uuid)
    {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[16]);
        byteBuffer.putLong(uuid.getMostSignificantBits());
        byteBuffer.putLong(uuid.getLeastSignificantBits());
        return byteBuffer.array();
    }

    public static UUID UUIDfromByteArray(byte[] array) {
        String s = "";
        for( int i=0; i<array.length;i++) {
            s += String.format("%02x",array[i]);
            if( i==3 || i==5 || i == 7 || i==9 )
                s += "-";
        }

        return UUID.fromString(s);

    }
}
