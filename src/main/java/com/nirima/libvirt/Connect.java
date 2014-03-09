package com.nirima.libvirt;


import com.nirima.libvirt.model.RemoteNodeInfo;
import com.nirima.libvirt.remote.ILibVirt;
import com.nirima.libvirt.xdr.XDR;


import java.io.*;


/**
 * @author Nigel Magnay
 */
public class Connect {

    Connection c;

    ILibVirt libVirt;

    public Connect(String host, int port, String username, String password, String uri, boolean readOnly) throws IOException {

        c = new Connection(host, port, username, password);
        c.connect();
        libVirt = XDR.createInterface(ILibVirt.class, c);

        libVirt.connectOpen(uri, 0);
    }

    public ILibVirt getLibVirt() {
        return libVirt;
    }

    public RemoteNodeInfo nodeInfo() throws IOException, InstantiationException, IllegalAccessException {

        RemoteNodeInfo nodeInfo = libVirt.nodeGetInfo();

        return nodeInfo;
    }

    public boolean isConnected() {
        return c.isConnected();
    }

    public Domain getDomain(String name) {
        return new Domain(this, libVirt.domainLookupByName(name));
    }

    public void close() throws IOException {
        c.close();
    }

    public int numOfDefinedDomains() {
        return libVirt.connectNumOfDefinedDomains();
    }

    public int numOfDomains() {
        return libVirt.connectNumOfDomains();
    }

    public int[] listDomains() {
        int maxids = numOfDomains();

        if (maxids > 0) {
            return libVirt.connectListDomains(maxids);
        } else {
            return new int[0];
        }
    }

    public String[] listDefinedDomains() {
        int maxids = numOfDefinedDomains();

        if( maxids > 0 )
            return libVirt.connectListDefinedDomains(maxids);
        else
            return new String[0];
    }

    public Domain domainLookupByName(String name) {
        return new Domain(this, libVirt.domainLookupByName(name));
    }

    public Domain domainLookupById(int id) {
        return new Domain(this, libVirt.domainLookupById(id));
    }
}
