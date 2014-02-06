package com.nirima.libvirt;

import com.nirima.libvirt.model.RemoteDomainSnapshot;


/**
 * @author Nigel Magnay
 */
public class DomainSnapshot {
    private final Connect connect;
    private final RemoteDomainSnapshot id;
    
    public DomainSnapshot(Connect connect, RemoteDomainSnapshot rds) {
        this.connect = connect;
        this.id = rds;
    }

    public RemoteDomainSnapshot getId() {
        return id;
    }
}
