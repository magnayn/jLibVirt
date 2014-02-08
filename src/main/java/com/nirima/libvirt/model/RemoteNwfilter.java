package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author Nigel Magnay
 */
public class RemoteNwfilter implements Serializable {

    @Nonnull
    public String name;
    public UUID uuid;
}