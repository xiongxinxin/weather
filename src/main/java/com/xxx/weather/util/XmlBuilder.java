package com.xxx.weather.util;

import java.io.Reader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 * Xml������ʵ�����
 *
 * @author xiong.xinxin
 * @date 2019-5-4
 */
public class XmlBuilder {

	/**
	 * ��xml�ļ�ת����һ��POJO����
	 * 
	 * @param xmlStr xml����
	 * @param clazz  ʵ���������
	 * @return ʵ�����
	 * @throws Exception �쳣����
	 * @author xiong.xinxin
	 * @date 2019-5-4
	 */
	public static Object xmlStrToObject(String xmlStr, Class<?> clazz) throws Exception {
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
