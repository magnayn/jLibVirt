package com.nirima.libvirt.model;

import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteStoragePoolInfo implements Serializable {

    public char state;
    public long capacity;
    public long allocation;
    public long available;
}