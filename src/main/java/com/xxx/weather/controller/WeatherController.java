/**
 * 
 */
package com.xxx.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xxx.weather.service.WeatherService;
import com.xxx.weather.vo.WeatherResponse;

/**
 * 2019年5月3日 熊新新
 * 
 * @author xiong.xinxin
 *
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {
	@Autowired
	private WeatherService weatherService;

	/**
	 * 通过城市ID获取天气状况
	 * 
	 * @param cityId 城市ID
	 * @return 天气情况
	 * @author xiong.xinxin
	 * @date 2019-5-3
	 */
	@GetMapping(value = "/cityId/{cityId}")
	public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId) {

		return this.weatherService.getWeatherByCityId(cityId);
	}

	/**
	 * 通过城市名称获取天气状况
	 * 
	 * @param cityName 城市名称
	 * @return 天气情况
	 * @author xiong.xinxin
	 * @date 2019-5-3
	 */
	@GetMapping(value = "/cityName/{cityName}")
	public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName) {

		return this.weatherService.getWeatherByCityName(cityName);
	}
}
