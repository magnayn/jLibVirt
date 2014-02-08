package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteConnectAllStoragePools implements Serializable {

    @Nonnull
    public RemoteStoragePool[] pools;
    public int ret;
}