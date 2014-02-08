package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainIoErrorReason implements Serializable {

    @Nonnull
    public RemoteDomain dom;
    @Nonnull
    public String srcPath;
    @Nonnull
    public String devAlias;
    public int action;
    @Nonnull
    public String reason;
}