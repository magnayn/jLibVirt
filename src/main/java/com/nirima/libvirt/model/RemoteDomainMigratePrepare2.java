package com.nirima.libvirt.model;

import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainMigratePrepare2 implements Serializable {

    public int[] cookie;
    public String uri_out;
}