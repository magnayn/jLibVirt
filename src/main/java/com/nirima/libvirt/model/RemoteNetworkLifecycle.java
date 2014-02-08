package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteNetworkLifecycle implements Serializable {

    public int callbackID;
    @Nonnull
    public RemoteNetwork net;
    public int event;
    public int detail;
}