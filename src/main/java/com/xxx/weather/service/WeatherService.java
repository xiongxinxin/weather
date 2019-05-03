package com.xxx.weather.service;

import com.xxx.weather.vo.WeatherResponse;

/**
 * 天气接口类
 *
 * @author xiong.xinxin
 * @date 2019年5月3日
 */
public interface WeatherService {
	/**
	 * 通过城市编码获取该城市天气信息
	 * 
	 * @param cityId 城市ID
	 * @return 天气状况
	 * @author xiong.xinxin
	 * @date 2019-5-3
	 */
	WeatherResponse getWeatherByCityId(String cityId);

	/**
	 * 通过城市名称获取该城市的天气信息
	 * 
	 * @param cityName 城市名称
	 * @return 天气状况
	 * @author xiong.xinxin
	 * @date 2019-5-3
	 */
	WeatherResponse getWeatherByCityName(String cityName);

}
