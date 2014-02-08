package com.nirima.libvirt.model;

import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteAuthSaslStep implements Serializable {

    public int complete;
    public int nil;
    public char[] data;
}