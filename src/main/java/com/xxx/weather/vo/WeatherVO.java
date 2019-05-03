/**
 * 
 */
package com.xxx.weather.vo;

import java.util.List;

/**
 * 天气情况实体类
 *
 * @author xiong.xinxin
 * @date 2019年5月3日
 */
public class WeatherVO {
	private YesterdayVO yesterday;
	private String city;
	private List<ForecastVO> forecast;
	private String ganmao;
	private String wendu;

	public YesterdayVO getYesterday() {
		return yesterday;
	}

	public void setYesterday(YesterdayVO yesterday) {
		this.yesterday = yesterday;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<ForecastVO> getForecast() {
		return forecast;
	}

	public void setForecast(List<ForecastVO> forecast) {
		this.forecast = forecast;
	}

	public String getGanmao() {
		return ganmao;
	}

	public void setGanmao(String ganmao) {
		this.ganmao = ganmao;
	}

	public String getWendu() {
		return wendu;
	}

	public void setWendu(String wendu) {
		this.wendu = wendu;
	}

	@Override
	public String toString() {
		return "WeatherVO [yesterday=" + yesterday + ", city=" + city + ", forecast=" + forecast + ", ganmao=" + ganmao
				+ ", wendu=" + wendu + "]";
	}

}
