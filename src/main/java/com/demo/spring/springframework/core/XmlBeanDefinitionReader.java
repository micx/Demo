package com.demo.spring.springframework.core;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import sun.tools.java.ClassPath;

import java.io.File;
import java.net.MalformedURLException;
import java.util.*;
import java.util.logging.Logger;

/**
 * 
 * @author PanHuizhi [Phz50@163.com]
 * 
 */
public class XmlBeanDefinitionReader {
	protected static Logger log = Logger
			.getLogger(XmlBeanDefinitionReader.class.getName());

	/**
	 * 读取配置文件中的信息，并把信息放入map中
	 */
	public static Map<String, Bean> readXmlFile(String fileName) {

		// 获得带上classpath路径的文件路径
//		fileName = ClassLoader.getSystemResource(fileName).getPath();
		log.info("Loading XML bean definitions from file [" + fileName + "]");

		// 读取后的内容放到这个map中
		Map<String, Bean> beansMap = new HashMap<String, Bean>();

		// 读文件

        File file = new File("/Users/micx/Github_Project/Demo/src/main/java/com/demo/spring/applicationContext.xml");
//        File file = new File(fileName);

        System.out.println(fileName+" "+file.canRead()+"  "+file.length()+" "+file.exists());
        Document doc = null;
        try {
            doc = new SAXReader().read(file);

		} catch (DocumentException e) {
			throw new RuntimeException(e);
		} catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // 定位所有的bean
		Iterator<?> beanIterator = doc.getRootElement().elementIterator("bean");
		while (beanIterator.hasNext()) {
			Element beanElm = (Element) beanIterator.next();

			// 每个bean的信息放到一个Bean中
			Bean bean = new Bean();
			String beanId = beanElm.attribute("id").getStringValue();
			String beanType = beanElm.attribute("class").getStringValue();
			bean.setId(beanId);
			bean.setType(beanType);

			Iterator<?> beanProperties = beanElm.elementIterator();
			while (beanProperties.hasNext()) {
				Element beanProperty = (Element) beanProperties.next();
				String name = beanProperty.attributeValue("name");

				// 如果是普通赋值 value形式
				if (beanProperty.attribute("value") != null) {
					String value = beanProperty.attributeValue("value");
					bean.getProperties().put(name, value);
				}

				// 如果是引用另外一个bean赋值 ref形式
				if (beanProperty.attribute("ref") != null) {
					String[] refString = new String[] { beanProperty
							.attributeValue("ref") };
					bean.getProperties().put(name, refString);
				}

				// 如果是 List 形式的属性 只支持String 和 javabean 形式的 List
				if (beanProperty.element("list") != null) {
					List<Object> valuesList = new ArrayList<Object>();
					Element listElement = (Element) beanProperty.elements()
							.get(0);
					Iterator<?> valuesIterator = listElement.elements()
							.iterator();
					while (valuesIterator.hasNext()) {
						Element value = (Element) valuesIterator.next();
						if (value.getName().equals("value")) {
							valuesList.add(value.getText());
						}
						if (value.getName().equals("ref")) {
							valuesList.add(new String[] { value
									.attributeValue("bean") });
						}
					}
					bean.getProperties().put(name, valuesList);
				}

				// 如果是 map形式的
				if (beanProperty.element("map") != null) {
					Map<String, Object> propertiesMap = new HashMap<String, Object>();
					Element propertiesListMap = (Element) beanProperty
							.elements().get(0);
					Iterator<?> propertiesIterator = propertiesListMap
							.elements().iterator();
					while (propertiesIterator.hasNext()) {
						Element vet = (Element) propertiesIterator.next();
						if (vet.getName().equals("entry")) {
							String key = vet.attributeValue("key");
							Iterator<?> valuesIterator = vet.elements()
									.iterator();
							while (valuesIterator.hasNext()) {
								Element value = (Element) valuesIterator.next();
								if (value.getName().equals("value")) {
									propertiesMap.put(key, value.getText());
								}
								if (value.getName().equals("ref")) {
									propertiesMap.put(key, new String[] { value
											.attributeValue("bean") });
								}
							}
						}
					}
					bean.getProperties().put(name, propertiesMap);
				}
			}
			beansMap.put(beanId, bean);
		}
		return beansMap;
	}
}
