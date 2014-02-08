package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainRtcChange implements Serializable {

    @Nonnull
    public RemoteDomain dom;
    public long offset;
}