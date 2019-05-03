package com.xxx.weather.vo;

/**
 * 天气数据接收类
 *
 * @author xiong.xinxin
 * @date 2019年5月3日
 */
public class WeatherResponse {
	private WeatherVO data;
	private Integer status;
	private String desc;

	public WeatherVO getData() {
		return data;
	}

	public void setData(WeatherVO data) {
		this.data = data;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "WeatherResponse [data=" + data + ", status=" + status + ", desc=" + desc + "]";
	}

}
