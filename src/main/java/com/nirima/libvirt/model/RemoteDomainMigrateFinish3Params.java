package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainMigrateFinish3Params implements Serializable {

    @Nonnull
    public RemoteDomain dom;
    public int[] cookie_out;
}