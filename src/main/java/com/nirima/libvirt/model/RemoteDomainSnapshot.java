package com.nirima.libvirt.model;

import com.google.common.base.Objects;

import javax.annotation.Nonnull;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainSnapshot {
    @Nonnull
    public String name;

    @Nonnull
    public RemoteDomain domain;

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("domain", domain)
                .toString();
    }
}
