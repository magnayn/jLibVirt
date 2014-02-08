package com.nirima.libvirt.model;

import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainBlkioParameters implements Serializable {

    public RemoteTypedParam[] params;
    public int nparams;
}