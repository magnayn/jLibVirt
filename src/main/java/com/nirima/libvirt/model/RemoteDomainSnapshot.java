package com.nirima.libvirt.model;

import com.google.common.base.Objects;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainSnapshot implements Serializable
{
    @Nonnull
    public String name;

    @Nonnull
    public RemoteDomain dom;

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("domain", dom)
                .toString();
    }
}
