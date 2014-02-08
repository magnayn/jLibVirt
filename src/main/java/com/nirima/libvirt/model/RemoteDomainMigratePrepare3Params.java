package com.nirima.libvirt.model;

import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainMigratePrepare3Params implements Serializable {

    public int[] cookie_out;
    public String uri_out;
}