package com.demo.spring.springframework.core;


/**
 * 
 * @author PanHuizhi [Phz50@163.com]
 * 
 */
public interface ApplicationContext {
	/**
	 * 根据Bean Id 生成 Bean
	 * 
	 * @param beanId
	 * @return
	 */
	public Object getBean(String beanId);
}
