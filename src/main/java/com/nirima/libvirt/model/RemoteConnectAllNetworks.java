package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteConnectAllNetworks implements Serializable {

    @Nonnull
    public RemoteNetwork[] nets;
    public int ret;
}