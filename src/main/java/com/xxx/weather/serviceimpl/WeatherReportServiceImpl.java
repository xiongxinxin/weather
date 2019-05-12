package com.xxx.weather.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.weather.service.WeatherReportService;
import com.xxx.weather.service.WeatherService;
import com.xxx.weather.vo.WeatherResponse;
import com.xxx.weather.vo.WeatherVO;

/**
 * ��ȡ������ҵ����
 * 
 * @author xiong.xinxin
 * @date 2019-5-7
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

	@Autowired
	private WeatherService weatherService;

	/**
	 * ��ȡ����������Ϣ
	 * @param cityId ����ID
	 * @return ������Ϣ
	 * @author xiong.xinxin
	 * @date 2019-5-7
	 */
	@Override
	public WeatherVO getDataByCityId(String cityId) {
		WeatherResponse resp = this.weatherService.getWeatherByCityId(cityId);
		return resp.getData();
	}

}
