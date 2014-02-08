package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteConnectAllNodeDevices implements Serializable {

    @Nonnull
    public String[] devices;
    public int ret;
}