package com.demo.annotation.apt;

import java.lang.annotation.*;

/**
 * Created by chenxi.chen on 2014/07/10/上午9:37.
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
public @interface Property {
    String column();
    String type();
}
