package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteStoragePoolAllVolumes implements Serializable {

    @Nonnull
    public RemoteStorageVol[] vols;
    public int ret;
}