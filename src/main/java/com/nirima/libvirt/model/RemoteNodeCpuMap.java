package com.nirima.libvirt.model;

import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteNodeCpuMap implements Serializable {

    public int[] cpumap;
    public int online;
    public int ret;
}