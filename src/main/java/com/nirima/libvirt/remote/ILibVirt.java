package com.nirima.libvirt.remote;

import com.nirima.libvirt.model.NodeInfo;
import com.nirima.libvirt.model.RemoteDomain;
import com.nirima.libvirt.model.RemoteDomainInfo;
import com.nirima.libvirt.model.RemoteDomainSnapshot;
import com.nirima.libvirt.xdr.XDRInterface;
import com.nirima.libvirt.xdr.XDRMethod;

import javax.annotation.Nonnull;

/**
 * @author Nigel Magnay
 */
@XDRInterface(program = 0x20008086)
public interface ILibVirt {

    @XDRMethod(proc=1)
    void connectOpen(String uri, int flags);

    @XDRMethod(proc=2)
    void close();

    @XDRMethod(proc=4)
    long getVersion();

    @XDRMethod(proc=6)
    NodeInfo nodeGetInfo();

    @XDRMethod(proc=9)
    int domainCreate(RemoteDomain id);

    @XDRMethod(proc=21)
    String[] listDefinedDomains(int maxIds);

    @XDRMethod(proc=22)
    RemoteDomain domainLookupById(int id);

    @XDRMethod(proc=23)
    RemoteDomain domainLookupByName(@Nonnull String c);

    @XDRMethod(proc=37)
    int[] listDomains(int maxIds);

    @XDRMethod(proc=25)
    int numOfDefinedDomains();

    @XDRMethod(proc=33)
    void domainShutdown(RemoteDomain domain);

    @XDRMethod(proc=192)
    int domainRevertToSnapshot(RemoteDomainSnapshot id, int i);

    @XDRMethod(proc=189)
    RemoteDomainSnapshot domainSnapshotLookupByName(RemoteDomain id, String name, int flags);

    @XDRMethod(proc=187)
    int domainSnapshotNum(RemoteDomain id, int i);

    @XDRMethod(proc=188)
    String[] domainSnapshotListNames(RemoteDomain id, int maxnames, int flags);

    @XDRMethod(proc=16)
    RemoteDomainInfo domainGetInfo(RemoteDomain id);
}
