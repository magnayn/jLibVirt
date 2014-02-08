package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainBlockJob implements Serializable {

    @Nonnull
    public RemoteDomain dom;
    @Nonnull
    public String path;
    public int type;
    public int status;
}