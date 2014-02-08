package com.nirima.libvirt.model;

import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainInterfaceStats implements Serializable {

    public long rx_bytes;
    public long rx_packets;
    public long rx_errs;
    public long rx_drop;
    public long tx_bytes;
    public long tx_packets;
    public long tx_errs;
    public long tx_drop;
}