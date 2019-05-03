package com.xxx.weather.service;

import com.xxx.weather.vo.WeatherResponse;

/**
 * �����ӿ���
 *
 * @author xiong.xinxin
 * @date 2019��5��3��
 */
public interface WeatherService {
	/**
	 * ͨ�����б����ȡ�ó���������Ϣ
	 * 
	 * @param cityId ����ID
	 * @return ����״��
	 * @author xiong.xinxin
	 * @date 2019-5-3
	 */
	WeatherResponse getWeatherByCityId(String cityId);

	/**
	 * ͨ���������ƻ�ȡ�ó��е�������Ϣ
	 * 
	 * @param cityName ��������
	 * @return ����״��
	 * @author xiong.xinxin
	 * @date 2019-5-3
	 */
	WeatherResponse getWeatherByCityName(String cityName);

}
