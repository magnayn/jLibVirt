package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteConnectCpuModelNames implements Serializable {

    @Nonnull
    public String[] models;
    public int ret;
}