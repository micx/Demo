package com.demo.annotation.sample;

import java.lang.annotation.*;

/**
 * Created by chenxi.chen on 2014/06/12/下午3:40.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
//定义Testable Annotation将被javadoc工具提取
@Documented
public @interface Testable {
}

