package com.nirima.libvirt.xdr;

import java.lang.annotation.*;


/**
 * @author Nigel Magnay
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface XDRField {
    int length();
}
