package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainTrayChange implements Serializable {

    @Nonnull
    public RemoteDomain dom;
    @Nonnull
    public String devAlias;
    public int reason;
}