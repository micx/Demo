package com.demo.annotation.apt;

import com.demo.annotation.apt.IdProperty;
import com.demo.annotation.apt.Persistent;
import com.demo.annotation.apt.Property;
import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.declaration.FieldDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by chenxi.chen on 2014/07/10/上午9:47.
 */
public class HibernateAnnotationProcessor implements AnnotationProcessor {

    //Annotation处理器环境，是该处理器与APT交互的重要途径
    private AnnotationProcessorEnvironment env;

    //构造HibernateAnnotationProcessor对象时，获得处理器环境
    public HibernateAnnotationProcessor(AnnotationProcessorEnvironment env)
    {
        this.env = env;
    }

    @Override
    public void process() {
    //遍历每个class文件
        for (TypeDeclaration t : env.getSpecifiedTypeDeclarations())
        {
            //定义一个文件输出流，用于生成额外的文件
            FileOutputStream fos = null;
            //获取正在处理的类名
            String clazzName = t.getSimpleName();
            //获取类定义前的Persistent Annotation
            Persistent per = t.getAnnotation(Persistent.class);
            //当per Annotation不为空时才继续处理
            if(per != null)
            {
                try
                {
                    //创建文件输出流
                    fos = new FileOutputStream(clazzName + ".hbm.xml");
                    PrintStream ps = new PrintStream(fos);
                    //执行输出
                    ps.println("<?xml version=\"1.0\"?>");
                    ps.println("<!DOCTYPE hibernate-mapping");
                    ps.println(" PUBLIC -//Hibernate/Hibernate Mapping DTD 3.0//EN");
                            ps.println("http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd\\>");
                    ps.println("<hibernate-mapping>");
                    ps.print(" <class name=" + t);
                            //输出per的table()的值
                            ps.println("table=" + per.table() + ">");
                    for (FieldDeclaration f : t.getFields())
                    {
                        //获取指定FieldDeclaration前面的IdProperty Annotation
                        IdProperty id = f.getAnnotation(IdProperty.class);
                        //如果id Annotation不为空
                        if (id != null)
                        {
                            //执行输出
                            ps.println("  <id name="
                                            + f.getSimpleName()
                                            + "column=" + id.column()
                                            + "type=" + id.type()
                                            + ">");
                                    ps.println("<generator class="
                                                    + id.generator() + "/>");
                                            ps.println("  </id>");
                        }
                        //获取指定FieldDeclaration前面的Property Annotation
                        Property p = f.getAnnotation(Property.class);
                        //如果p Annotation不为空
                        if (p != null)
                        {
                            //执行输出
                            ps.println("  <property name="
                                    + f.getSimpleName()
                                    + " column=" + p.column()
                                    + " type=" + p.type()
                                    + "/>");
                        }
                    }
                    ps.println(" </class>");
                    ps.println("</hibernate-mapping>");
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    //关闭输出流
                    try
                    {
                        if (fos != null)
                        {
                            fos.close();
                        }
                    }
                    catch (IOException ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}
