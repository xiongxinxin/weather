package com.xxx.weather.service;

import com.xxx.weather.vo.WeatherVO;

/**
 * ��ȡ��������Ľӿ�
 * @author xiong.xinxin
 * @date 2019-5-7
 */
public interface WeatherReportService {
	
	/**
	 * ���ݳ���ID��ѯ������Ϣ
	 * @param cityId ����ID
	 * @return �ó���һ�ܵ�����״��
	 * @author xiong.xinxin
	 * @date 2019-5-7
	 */
	WeatherVO getDataByCityId(String cityId);
}
