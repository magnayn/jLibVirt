package com.nirima.libvirt.model;

import java.io.Serializable;

/**
 * @author Nigel Magnay
 */
public class RemoteError implements Serializable {

    public int code;
    public int domain;
    public String message;
    public int level;
    public RemoteDomain dom;
    public String str1;
    public String str2;
    public String str3;
    public int int1;
    public int int2;
    public RemoteNetwork net;
}