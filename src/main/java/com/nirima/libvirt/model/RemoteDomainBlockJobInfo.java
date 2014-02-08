package com.nirima.libvirt.model;

import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainBlockJobInfo implements Serializable {

    public int found;
    public int type;
    public long bandwidth;
    public long cur;
    public long end;
}