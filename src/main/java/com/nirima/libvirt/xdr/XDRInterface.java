package com.nirima.libvirt.xdr;

import java.lang.annotation.*;


/**
 * @author Nigel Magnay
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface XDRInterface {
    int program();
    int version() default 1;
}
