package com.nirima.libvirt.xdr;

import com.nirima.libvirt.model.NodeInfo;
import com.nirima.libvirt.model.RemoteDomain;
import com.nirima.libvirt.model.RemoteDomainInfo;
import com.nirima.libvirt.model.RemoteDomainSnapshot;
import com.nirima.libvirt.util.Utils;
import junit.framework.TestCase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by magnayn on 04/02/2014.
 */
public class XDRTest extends TestCase {

    private Object rt(Object nodeInfo) throws IllegalAccessException, IOException, InstantiationException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        XDROutputStream xos = new XDROutputStream(byteArrayOutputStream);

        XDR.write(xos, nodeInfo);

        xos.flush();
        byte[] data = byteArrayOutputStream.toByteArray();

        System.out.println(Utils.asHex(data));

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        XDRInputStream xis = new XDRInputStream(byteArrayInputStream);

        return XDR.read(xis, nodeInfo.getClass());

    }

    public void testRoundTrip1() throws IOException, IllegalAccessException, InstantiationException {
        NodeInfo nodeInfo = new NodeInfo();

        nodeInfo.model[0] = 'X';
        nodeInfo.model[1] = 'Z';

        nodeInfo.cores = 1;
        nodeInfo.threads = 4;

        NodeInfo nodeInfoRT = (NodeInfo) rt(nodeInfo);

        assertEquals(nodeInfo.toString(), nodeInfoRT.toString());
    }

    public void testRoundTrip2() throws IOException, IllegalAccessException, InstantiationException {

        RemoteDomain nodeInfo = makeRemoteDomain();
        nodeInfo.id = 123;
        nodeInfo.name = "FISH";
        nodeInfo.uuid = UUID.randomUUID();

        RemoteDomain nodeInfoRT = (RemoteDomain) rt(nodeInfo);

        assertEquals(nodeInfo.toString(), nodeInfoRT.toString());
    }

    private RemoteDomain makeRemoteDomain() {
        RemoteDomain nodeInfo = new RemoteDomain();

        nodeInfo.id = 123;
        nodeInfo.name = "FISH";
        nodeInfo.uuid = UUID.randomUUID();
        return nodeInfo;
    }

    public void testRoundTrip3() throws IOException, IllegalAccessException, InstantiationException {
        RemoteDomainInfo nodeInfo = new RemoteDomainInfo();

        nodeInfo.state = 1;
        nodeInfo.cpuTime = 123;
        nodeInfo.nrVirtCpu = 5;

        RemoteDomainInfo nodeInfoRT = (RemoteDomainInfo) rt(nodeInfo);

        assertEquals(nodeInfo.toString(), nodeInfoRT.toString());
    }

    public void testRoundTrip4() throws IOException, IllegalAccessException, InstantiationException {

        RemoteDomainSnapshot nodeInfo = new RemoteDomainSnapshot();

        nodeInfo.domain = makeRemoteDomain();
        nodeInfo.name = "BLAHS";

        RemoteDomainSnapshot nodeInfoRT = (RemoteDomainSnapshot) rt(nodeInfo);

        assertEquals(nodeInfo.toString(), nodeInfoRT.toString());
    }
}
