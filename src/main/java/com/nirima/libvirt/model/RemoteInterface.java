package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteInterface implements Serializable {

    @Nonnull
    public String name;
    @Nonnull
    public String mac;
}