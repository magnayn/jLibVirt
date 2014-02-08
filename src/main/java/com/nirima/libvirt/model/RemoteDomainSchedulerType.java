package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainSchedulerType implements Serializable {

    @Nonnull
    public String type;
    public int nparams;
}