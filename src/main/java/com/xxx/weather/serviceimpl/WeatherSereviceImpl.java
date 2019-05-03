package com.xxx.weather.serviceimpl;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
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

	private final static Logger log = LoggerFactory.getLogger(WeatherSereviceImpl.class);
	private final static String URI = "http://wthrcdn.etouch.cn/weather_mini";

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

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

		String body = "";
		ValueOperations<String, String> opsForValue = this.stringRedisTemplate.opsForValue();

		// �����������ݾʹӻ�����ȡ����
		if (stringRedisTemplate.hasKey(url)) {
			body = opsForValue.get(url);
			log.info("��redis�л�ȡ���ݣ�keyΪ{},ֵΪ\n{}", url, body);
		} else {
			ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
			int statusCode = responseEntity.getStatusCodeValue();

			if (statusCode == 200) {
				body = responseEntity.getBody();
			}

			opsForValue.set(url, body, 30 * 60L, TimeUnit.SECONDS);
			log.info("��redis�в������ݣ�keyΪ{},ֵΪ\n{}", url, body);
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
