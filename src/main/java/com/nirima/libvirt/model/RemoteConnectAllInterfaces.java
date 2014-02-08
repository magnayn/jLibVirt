package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteConnectAllInterfaces implements Serializable {

    @Nonnull
    public RemoteInterface[] ifaces;
    public int ret;
}