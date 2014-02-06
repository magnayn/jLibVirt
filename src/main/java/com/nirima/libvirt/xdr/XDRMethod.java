package com.nirima.libvirt.xdr;

import java.lang.annotation.*;


/**
 * @author Nigel Magnay
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface XDRMethod {
    int proc();
}
