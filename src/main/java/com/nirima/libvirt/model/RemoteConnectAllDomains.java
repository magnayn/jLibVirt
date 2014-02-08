package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteConnectAllDomains implements Serializable {

    @Nonnull
    public RemoteDomain[] domains;
    public int ret;
}