package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainDiskError implements Serializable {

    @Nonnull
    public String disk;
    public int error;
}