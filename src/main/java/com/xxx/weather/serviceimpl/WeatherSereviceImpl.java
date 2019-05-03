package com.xxx.weather.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
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
	private final static String URI = "http://wthrcdn.etouch.cn/weather_mini";

	@Autowired
	private RestTemplate restTemplate;

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
