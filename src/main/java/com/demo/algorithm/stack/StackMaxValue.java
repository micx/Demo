package com.demo.algorithm.stack;

import java.util.Random;
import java.util.Stack;

/**
 * Created by chenxi.chen on 2014/07/11/上午9:23.
 */
public class StackMaxValue {

    public Stack<Integer> getStack() {
        return stack;
    }

    public void setStack(Stack<Integer> stack) {
        this.stack = stack;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    private Stack<Integer> stack = new Stack<Integer>();
    private Integer maxValue;

    public void push(Integer value){
        if(stack.size() == 0){
            maxValue = value;
        }else {
            if (value > maxValue) {
                maxValue = value;
            } else {
                value = (value - maxValue);
            }
        }
        stack.push(value);
    }

    /**
     * ...
     * @return
     * @throws java.lang.Exception if ...
     */
    public Integer pop(){
        Integer tmp = stack.pop();
        if(tmp > 0){
            maxValue = stack.peek();
            return tmp;
        }else{
            return maxValue+tmp;
        }
    }

    public Integer getMaxValue() throws Exception {
        if(stack.size() == 0){
            throw new Exception();
        }
        return maxValue;
    }
    public static void  main(String[] args) throws Exception {
        StackMaxValue stackMaxValue = new StackMaxValue();
        for (int i=0 ;i<20;++i){
            Random random = new Random();
            Integer val = random.nextInt()%10;
            System.out.println(val);
            stackMaxValue.push(val);
            System.out.println("maxValue = "+stackMaxValue.getMaxValue());
        }
        for (int i = 0; i < 20; i++) {
            System.out.println(stackMaxValue.pop());
        }
    }
}
