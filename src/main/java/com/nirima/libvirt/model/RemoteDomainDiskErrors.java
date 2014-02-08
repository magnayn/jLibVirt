package com.nirima.libvirt.model;

import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainDiskErrors implements Serializable {

    public RemoteDomainDiskError[] errors;
    public int nerrors;
}