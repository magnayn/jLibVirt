package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainGraphics implements Serializable {

    @Nonnull
    public RemoteDomain dom;
    public int phase;
    public RemoteDomainGraphicsAddress local;
    public RemoteDomainGraphicsAddress remote;
    @Nonnull
    public String authScheme;
    public RemoteDomainGraphicsIdentity[] subject;
}