package com.nirima.libvirt.model;

import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainVcpuPinInfo implements Serializable {

    public int[] cpumaps;
    public int num;
}