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
 * 2019��5��3�� ������
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
	 * ͨ������ID��ȡ����״��
	 * 
	 * @param cityId ����ID
	 * @return �������
	 * @author xiong.xinxin
	 * @date 2019-5-3
	 */
	@GetMapping(value = "/cityId/{cityId}")
	public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId) {

		return this.weatherService.getWeatherByCityId(cityId);
	}

	/**
	 * ͨ���������ƻ�ȡ����״��
	 * 
	 * @param cityName ��������
	 * @return �������
	 * @author xiong.xinxin
	 * @date 2019-5-3
	 */
	@GetMapping(value = "/cityName/{cityName}")
	public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName) {

		return this.weatherService.getWeatherByCityName(cityName);
	}
}
