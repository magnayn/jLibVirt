package com.nirima.libvirt.model;

import com.google.common.base.Objects;

import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainInfo  implements Serializable {
    public char  state;
    public long  maxMem;
    public long  memory;
    public short nrVirtCpu;
    public long  cpuTime;

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("state", state)
                .add("maxMem", maxMem)
                .add("memory", memory)
                .add("nrVirtCpu", nrVirtCpu)
                .add("cpuTime", cpuTime)
                .toString();
    }
}
