package com.nirima.libvirt.model;

import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainCpuStats implements Serializable {

    public RemoteTypedParam[] params;
    public int nparams;
}