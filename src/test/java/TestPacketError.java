import com.nirima.libvirt.Packet;
import com.nirima.libvirt.xdr.XDRException;
import com.nirima.libvirt.xdr.XDRInputStream;
import junit.framework.TestCase;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by magnayn on 04/02/2014.
 */
public class TestPacketError extends TestCase {
    public void testPacketError() throws IOException, IllegalAccessException, InstantiationException {
        InputStream inputStream = getClass().getResource("/packet.error").openStream();
        XDRInputStream dis = new XDRInputStream(inputStream);
        try {
            Packet p = Packet.readPacket(dis);
            assertFalse(true);
        }
        catch(XDRException ex)
        {
            // expected
        }
    }
}
