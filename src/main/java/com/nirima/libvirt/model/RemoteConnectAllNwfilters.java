package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteConnectAllNwfilters implements Serializable {

    @Nonnull
    public RemoteNwfilter[] filters;
    public int ret;
}