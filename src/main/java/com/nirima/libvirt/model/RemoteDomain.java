package com.nirima.libvirt.model;

import com.google.common.base.Objects;

import javax.annotation.Nonnull;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author Nigel Magnay
 */
public class RemoteDomain  implements Serializable {

    @Nonnull
    public String name;
    public UUID    uuid;
    public int id;

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("uuid", uuid)
                .add("id", id)
                .toString();
    }
}
