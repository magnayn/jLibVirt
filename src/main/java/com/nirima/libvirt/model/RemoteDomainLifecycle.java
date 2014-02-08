package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainLifecycle implements Serializable {

    @Nonnull
    public RemoteDomain dom;
    public int event;
    public int detail;
}