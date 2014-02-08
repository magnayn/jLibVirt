package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainAllSnapshots implements Serializable {

    @Nonnull
    public RemoteDomainSnapshot[] snapshots;
    public int ret;
}