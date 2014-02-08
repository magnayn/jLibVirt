package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainGraphicsIdentity implements Serializable {

    @Nonnull
    public String type;
    @Nonnull
    public String name;
}