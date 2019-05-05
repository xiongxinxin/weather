package com.xxx.weather.util;

import java.io.Reader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Xml解析成实体对象
 *
 * @author xiong.xinxin
 * @date 2019-5-4
 */
public class XmlBuilder {
	private static final Logger log = LoggerFactory.getLogger(XmlBuilder.class);

	/**
	 * 将xml文件转换成一个POJO对象
	 * 
	 * @param xmlStr xml对象
	 * @param clazz  实体对象类型
	 * @return 实体对象
	 * @throws Exception 异常类型
	 * @author xiong.xinxin
	 * @date 2019-5-4
	 */
	public static Object xmlStrToObject(String xmlStr, Class<?> clazz) throws Exception {
		log.info("\nxmlStr:{},\nclazz:{}", xmlStr, clazz);
		Object xmlObject = null;
		Reader reader = new StringReader(xmlStr);

		JAXBContext context = JAXBContext.newInstance(clazz);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		xmlObject = unmarshaller.unmarshal(reader);

		if (reader != null) {
			reader.close();
		}

		return xmlObject;
	}
}
