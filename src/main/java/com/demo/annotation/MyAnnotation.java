package com.demo.annotation;

/**
 * Created by chenxi.chen on 2014/06/09/下午3:21.
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface MyAnnotation
{
    String[] value1() default "abc";
}

