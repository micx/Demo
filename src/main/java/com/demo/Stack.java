/**
 * stack.java  
 * Created on  9/3/15 上午9:38
 * modify on                user            modify content
 * 9/3/15 上午9:38        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by micx  on 2015/03/09 上午9:38.
 */
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object obj) {
        elements[size++] = obj;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return elements[--size];
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
