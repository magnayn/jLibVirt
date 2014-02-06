package com.nirima.libvirt.xdr;

import com.google.common.base.Objects;


/**
 * @author Nigel Magnay
 */
public class XDRExceptionData {
    public int code;
    public int domain;

    public String message;

    public int level;
    public String dom;


    public String str1;
    public String str2;
    public String str3;

    public int int1;
    public int int2;

    public String net;

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("code", code)
                .add("domain", domain)
                .add("message", message)
                .add("level", level)
                .add("dom", dom)
                .add("str1", str1)
                .add("str2", str2)
                .add("str3", str3)
                .add("int1", int1)
                .add("int2", int2)
                .add("net", net)
                .toString();
    }
}
