package com.nirima.libvirt.model;

import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainBlockInfo implements Serializable {

    public long allocation;
    public long capacity;
    public long physical;
}