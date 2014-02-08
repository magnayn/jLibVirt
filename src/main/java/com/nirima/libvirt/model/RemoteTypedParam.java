package com.nirima.libvirt.model;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteTypedParam implements Serializable {

    @Nonnull
    public String field;
    public Object value;
}