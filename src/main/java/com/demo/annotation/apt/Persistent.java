package com.demo.annotation.apt;

import java.lang.annotation.*;

/**
 * Created by chenxi.chen on 2014/07/10/上午9:36.
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Persistent {
    String table();
}
