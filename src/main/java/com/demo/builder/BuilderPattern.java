/**
 * BuilderPattern.java  
 * Created on  8/3/15 下午2:04
 * modify on                user            modify content
 * 8/3/15 下午2:04        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.builder;

/**
 * Created by micx  on 2015/03/08 下午2:04.
 */
public class BuilderPattern {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder{
        //Required parameters
        private final int servingSize;
        private final int servings;

        // Optional parameters
        private int calories    = 0 ;
        private int fat         = 0 ;
        private int sodium      = 0 ;
        private int carbohydrate= 0 ;

        public Builder(int servingSize, int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val){
            calories = val;
            return this;
        }
        public Builder fat(int val){
            fat = val;
            return this;
        }public Builder carbohydrate(int val){
            carbohydrate = val;
            return this;
        }public Builder sodium(int val){
            sodium = val;
            return this;
        }
        public BuilderPattern build(){
            return new BuilderPattern(this);
        }
    }

    private BuilderPattern(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;

    }

    public static void main(String[] args) {
        BuilderPattern builderPattern = new BuilderPattern.Builder(1,2).calories(1).build();
    }
}
