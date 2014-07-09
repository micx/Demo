package com.demo.annotation;

/**
 * Created by chenxi.chen on 2014/06/09/下午3:21.
 */
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@MyAnnotation
public class MyAnnotationTest implements Anno
{
    @MyAnnotation
    @Override
    @SuppressWarnings("unchecked")
    @Deprecated
    public void say(){
        System.out.println("Deprecated");
    }
    public static void main(String []args) throws NoSuchMethodException {
        if(MyAnnotationTest.class.isAnnotationPresent( MyAnnotation.class))
        {
            MyAnnotation an=(MyAnnotation)MyAnnotationTest.class.getAnnotation(MyAnnotation.class) ;
            System.out.println(an.toString()+" "+an.value1()[0]);
        }
        MyAnnotationTest myAnnotationTest = new MyAnnotationTest();
        myAnnotationTest.say();

        Class clazz = MyAnnotationTest.class;
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method:methods) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }
        }
    }
}
