package com.xxx.weather.vo;

/**
 * δ��������ʵ����
 *
 * @author xiong.xinxin
 * @date 2019��5��3��
 */
public class ForecastVO {
	private String date;
	private String high;
	private String fengli;
	private String low;
	private String fengxiang;
	private String type;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getFengli() {
		return fengli;
	}

	public void setFengli(String fengli) {
		this.fengli = fengli;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ForecastVO [date=" + date + ", high=" + high + ", fengli=" + fengli + ", low=" + low + ", fengxiang="
				+ fengxiang + ", type=" + type + "]";
	}

}
