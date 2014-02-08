package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainGraphicsAddress implements Serializable {

    public int family;
    @Nonnull
    public String node;
    @Nonnull
    public String service;
}