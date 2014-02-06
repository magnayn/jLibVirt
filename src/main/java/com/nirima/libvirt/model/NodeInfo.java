package com.nirima.libvirt.model;

import com.google.common.base.Objects;
import com.nirima.libvirt.xdr.XDRField;

import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class NodeInfo implements Serializable {

    @XDRField(length=32)
    public char[] model = new char[32];

    public long memory;
    public int cpus;
    public int mhz;
    public int nodes;
    public int sockets;
    public int cores;
    public int threads;

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("model", new String(model))
                .add("memory", memory)
                .add("cpus", cpus)
                .add("mhz", mhz)
                .add("nodes", nodes)
                .add("sockets", sockets)
                .add("cores", cores)
                .add("threads", threads)
                .toString();
    }
}
