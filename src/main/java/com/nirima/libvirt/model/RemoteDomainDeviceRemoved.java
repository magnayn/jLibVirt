package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainDeviceRemoved implements Serializable {

    @Nonnull
    public RemoteDomain dom;
    @Nonnull
    public String devAlias;
}