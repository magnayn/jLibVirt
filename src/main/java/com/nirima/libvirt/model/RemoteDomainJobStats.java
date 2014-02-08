package com.nirima.libvirt.model;

import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteDomainJobStats implements Serializable {

    public int type;
    public RemoteTypedParam[] params;
}