package com.nirima.libvirt.model;

import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainControlInfo implements Serializable {

    public int state;
    public int details;
    public long stateTime;
}