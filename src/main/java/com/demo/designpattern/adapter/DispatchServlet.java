/**
 * DispatchServlet.java
 * Created on  28/12/2015 6:32 PM
 * modify on                user            modify content
 * 28/12/2015 6:32 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.designpattern.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by micx  on 2015/12/28 6:32 PM.
 */
public class DispatchServlet {

    public static List<HandlerAdapter> handlerAdapters = new ArrayList<HandlerAdapter>();

    public DispatchServlet(){
        handlerAdapters.add(new AnnotationHandlerAdapter());
        handlerAdapters.add(new HttpHandlerAdapter());
        handlerAdapters.add(new SimpleHandlerAdapter());
    }


    public void doDispatch(){

        //此处模拟SpringMVC从request取handler的对象，仅仅new出，可以出，
        //不论实现何种Controller，适配器总能经过适配以后得到想要的结果
//      HttpController controller = new HttpController();
//      AnnotationController controller = new AnnotationController();
        SimpleController controller = new SimpleController();
        //得到对应适配器
        HandlerAdapter adapter = getHandler(controller);
        //通过适配器执行对应的controller对应方法
        adapter.handle(controller);

    }

    public HandlerAdapter getHandler(Controller controller){
        for(HandlerAdapter adapter: this.handlerAdapters){
            if(adapter.supports(controller)){
                return adapter;
            }
        }
        return null;
    }

    public static void main(String[] args){
        new DispatchServlet().doDispatch();
    }

}
