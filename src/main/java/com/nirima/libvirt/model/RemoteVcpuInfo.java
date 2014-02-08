package com.nirima.libvirt.model;

import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteVcpuInfo implements Serializable {

    public int number;
    public int state;
    public long cpu_time;
    public int cpu;
}