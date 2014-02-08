package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author Nigel Magnay
 */
public class RemoteSecret implements Serializable {

    public UUID uuid;
    public int usageType;
    @Nonnull
    public String usageID;
}