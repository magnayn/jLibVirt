package com.nirima.libvirt.model;

import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainJobInfo implements Serializable {

    public int type;
    public long timeElapsed;
    public long timeRemaining;
    public long dataTotal;
    public long dataProcessed;
    public long dataRemaining;
    public long memTotal;
    public long memProcessed;
    public long memRemaining;
    public long fileTotal;
    public long fileProcessed;
    public long fileRemaining;
}