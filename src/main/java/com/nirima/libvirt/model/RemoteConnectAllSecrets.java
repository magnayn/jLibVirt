package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteConnectAllSecrets implements Serializable {

    @Nonnull
    public RemoteSecret[] secrets;
    public int ret;
}