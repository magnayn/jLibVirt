package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteStorageVol implements Serializable {

    @Nonnull
    public String pool;
    @Nonnull
    public String name;
    @Nonnull
    public String key;
}