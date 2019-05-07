package com.xxx.weather.service;

import com.xxx.weather.vo.WeatherVO;

/**
 * 获取天气情况的接口
 * @author xiong.xinxin
 * @date 2019-5-7
 */
public interface WeatherReportService {
	
	/**
	 * 根据城市ID查询天气信息
	 * @param cityId 城市ID
	 * @return 该城市一周的天气状况
	 * @author xiong.xinxin
	 * @date 2019-5-7
	 */
	WeatherVO getDataByCityId(String cityId);
}
