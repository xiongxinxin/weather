package com.xxx.weather.vo;

/**
 * �������ݽ�����
 *
 * @author xiong.xinxin
 * @date 2019��5��3��
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
