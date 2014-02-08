package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainMigrateBegin3 implements Serializable {

    public int[] cookie_out;
    @Nonnull
    public String xml;
}