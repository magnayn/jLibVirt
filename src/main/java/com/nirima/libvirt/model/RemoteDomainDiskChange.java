package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainDiskChange implements Serializable {

    @Nonnull
    public RemoteDomain dom;
    public String oldSrcPath;
    public String newSrcPath;
    @Nonnull
    public String devAlias;
    public int reason;
}