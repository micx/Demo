package com.demo.spring.springframework.core;

/**
 * 
 * @author PanHuizhi [Phz50@163.com]
 * 
 */
public class FileSystemXmlApplicationContext implements ApplicationContext {

	private BeanFactory beanFactory;

	/**
	 * 读取配置文件
	 */
	public FileSystemXmlApplicationContext(String fileName) {
		beanFactory = new XmlBeanFactory(fileName);
	}

	public Object getBean(String name) {
		return beanFactory.getBean(name);
	}

}
