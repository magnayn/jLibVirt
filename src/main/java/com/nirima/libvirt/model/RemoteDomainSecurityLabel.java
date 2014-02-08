package com.nirima.libvirt.model;

import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainSecurityLabel implements Serializable {

    public char[] label;
    public int enforcing;
}