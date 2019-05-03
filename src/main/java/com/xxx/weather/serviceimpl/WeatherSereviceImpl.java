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
 * 获取天气的业务类
 *
 * @author xiong.xinxin
 * @date 2019年5月3日
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
	 * 通过城市ID获取该城市天气信息
	 * 
	 * @param cityId 城市ID
	 * @return 天气信息
	 * @author xiong.xinxin
	 * @date 2019-5-3
	 */
	@Override
	public WeatherResponse getWeatherByCityId(String cityId) {
		String url = URI + "?citykey=" + cityId;

		return this.getWeather(url);
	}

	/**
	 * 通过城市名称获取该城市天气信息
	 * 
	 * @param cityName 城市名称
	 * @return 天气信息
	 * @author xiong.xinxin
	 * @date 2019-5-3
	 */
	@Override
	public WeatherResponse getWeatherByCityName(String cityName) {
		String url = URI + "?city=" + cityName;

		return this.getWeather(url);
	}

	/**
	 * 获取天气状况
	 * 
	 * @param url 访问地址
	 * @return 天气情况
	 * @author xiong.xinxin
	 * @date 2019-5-3
	 */
	private WeatherResponse getWeather(String url) {

		String body = "";
		ValueOperations<String, String> opsForValue = this.stringRedisTemplate.opsForValue();

		// 缓存中有数据就从缓存中取数据
		if (stringRedisTemplate.hasKey(url)) {
			body = opsForValue.get(url);
			log.info("从redis中获取数据，key为{},值为\n{}", url, body);
		} else {
			ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
			int statusCode = responseEntity.getStatusCodeValue();

			if (statusCode == 200) {
				body = responseEntity.getBody();
			}

			opsForValue.set(url, body, 30 * 60L, TimeUnit.SECONDS);
			log.info("向redis中插入数据，key为{},值为\n{}", url, body);
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
