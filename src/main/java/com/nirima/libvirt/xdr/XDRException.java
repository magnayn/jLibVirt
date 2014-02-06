package com.nirima.libvirt.xdr;

/**
 * @author Nigel Magnay
 */
public class XDRException extends RuntimeException {
    public XDRExceptionData data;

    public XDRException(XDRExceptionData data) {
        super(data.message);
        this.data = data;
    }
}
