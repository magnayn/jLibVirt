package com.nirima.libvirt.model;

import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainSecurityLabelList implements Serializable {

    public RemoteDomainSecurityLabel[] labels;
    public int ret;
}