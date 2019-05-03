package com.xxx.weather.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.xxx.weather.service.WeatherService;
import com.xxx.weather.vo.WeatherResponse;

/**
 * ��ȡ������ҵ����
 *
 * @author xiong.xinxin
 * @date 2019��5��3��
 */
@Service
public class WeatherSereviceImpl implements WeatherService {
	private final static String URI = "http://wthrcdn.etouch.cn/weather_mini";

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * ͨ������ID��ȡ�ó���������Ϣ
	 * 
	 * @param cityId ����ID
	 * @return ������Ϣ
	 * @author xiong.xinxin
	 * @date 2019-5-3
	 */
	@Override
	public WeatherResponse getWeatherByCityId(String cityId) {
		String url = URI + "?citykey=" + cityId;

		return this.getWeather(url);
	}

	/**
	 * ͨ���������ƻ�ȡ�ó���������Ϣ
	 * 
	 * @param cityName ��������
	 * @return ������Ϣ
	 * @author xiong.xinxin
	 * @date 2019-5-3
	 */
	@Override
	public WeatherResponse getWeatherByCityName(String cityName) {
		String url = URI + "?city=" + cityName;
		
		return this.getWeather(url);
	}

	/**
	 * ��ȡ����״��
	 * 
	 * @param url ���ʵ�ַ
	 * @return �������
	 * @author xiong.xinxin
	 * @date 2019-5-3
	 */
	private WeatherResponse getWeather(String url) {
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

		int statusCode = responseEntity.getStatusCodeValue();
		String body = "";
		if (statusCode == 200) {
			body = responseEntity.getBody();
		}
		WeatherResponse parseObject = null;
		try {
			parseObject = JSON.parseObject(body, WeatherResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return parseObject;
	}

}
