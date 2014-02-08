package com.nirima.libvirt.model;

import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainVcpus implements Serializable {

    public RemoteVcpuInfo[] info;
    public int[] cpumaps;
}