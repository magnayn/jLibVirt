package com.nirima.libvirt.model;

import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainBlockStats implements Serializable {

    public long rd_req;
    public long rd_bytes;
    public long wr_req;
    public long wr_bytes;
    public long errs;
}