package com.nirima.libvirt.model;

import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteStorageVolInfo implements Serializable {

    public char type;
    public long capacity;
    public long allocation;
}