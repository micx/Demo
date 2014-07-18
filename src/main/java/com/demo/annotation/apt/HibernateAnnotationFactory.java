package com.demo.annotation.apt;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

/**
 * Created by chenxi.chen on 2014/07/10/上午9:54.
 */
public class HibernateAnnotationFactory implements AnnotationProcessorFactory {
    //所有支持的注释类型
    public Collection<String> supportedAnnotationTypes()
    {
        return Arrays.asList("Property" , "IdProperty" , "Persistent");
    }
    //返回所有支持的选项
    public Collection<String> supportedOptions()
    {
        return Arrays.asList(new String[0]);
    }
    //返回Annotation处理器
    public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> atds,AnnotationProcessorEnvironment env)
    {
        return new HibernateAnnotationProcessor(env);
    }
}
