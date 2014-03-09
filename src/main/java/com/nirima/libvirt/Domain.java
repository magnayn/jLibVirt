package com.nirima.libvirt;

import com.nirima.libvirt.model.RemoteDomain;
import com.nirima.libvirt.model.RemoteDomainInfo;
import com.nirima.libvirt.model.RemoteDomainSnapshot;
import com.nirima.libvirt.remote.ILibVirt;


/**
 * @author Nigel Magnay
 */
public class Domain {
    private final Connect connect;
    private final RemoteDomain id;

    public static enum DomainState {
        NOSTATE, RUNNING, BLOCKED, PAUSED, SHUTDOWN, SHUTOFF, CRASHED
    }


    public Domain(Connect connect, RemoteDomain i) {
        this.connect = connect;
        this.id = i;
    }

    public String getName() {
         return id.name;
    }

    public ILibVirt getLibVirt() {
        return connect.getLibVirt();
    }

    public void shutdown() {
        getLibVirt().domainShutdown(id);
    }

    public void suspend() {
        getLibVirt().domainSuspend(id);
    }

    public void destroy() {
        getLibVirt().domainDestroy(id);
    }

    public String[] snapshotListNames() {
        return snapshotListNames(0);
    }

    public String[] snapshotListNames(int flags) {
        String[] returnValue = null;
        int num = snapshotNum();
        if (num >= 0) {
            returnValue = new String[num];
            if (num > 0) {
                return getLibVirt().domainSnapshotListNames(id, num, flags);
            }
        }
        return returnValue;
    }

    public int snapshotNum() {
        return getLibVirt().domainSnapshotNum(id, 0);
    }

    public DomainSnapshot snapshotLookupByName(String name) {
        RemoteDomainSnapshot rds = getLibVirt().domainSnapshotLookupByName(id, name, 0);

        DomainSnapshot returnValue = null;
        if (rds != null) {
            returnValue = new DomainSnapshot(connect, rds);
        }
        return returnValue;
    }

    public void revertToSnapshot(DomainSnapshot snapshot) {
        getLibVirt().domainRevertToSnapshot(snapshot.getId(), 0);
    }

    public void create() {
        getLibVirt().domainCreate(id);
    }

    public RemoteDomainInfo getInfo() {
        return getLibVirt().domainGetInfo(id);
    }

    public DomainState getState() {
        return DomainState.values()[getInfo().state];
    }
}
