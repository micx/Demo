/**
 * 
 */
package com.demo.spring.springframework.test;


import com.demo.spring.springframework.core.ApplicationContext;
import com.demo.spring.springframework.core.FileSystemXmlApplicationContext;

/**
 * 
 * @author PanHuizhi [Phz50@163.com]
 *
 */
public class AnimalSayApp {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("applicationContext.xml");
		AnimalSay animalSay = (AnimalSay) context.getBean("animalSay");
		animalSay.say();// 输出：I am kitty!
	}
}
