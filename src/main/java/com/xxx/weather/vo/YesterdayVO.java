
package com.xxx.weather.vo;

/**
 * 
 * 昨天的数据
 *
 * @author xiong.xinxin
 * @date 2019年5月3日
 */
public class YesterdayVO {
	private String date; // 日期
	private String high; // 高温情况
	private String fx; // 风向
	private String low; // 低温情况
	private String fl; // 风力等级
	private String type; // 天气状况

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

	public String getFx() {
		return fx;
	}

	public void setFx(String fx) {
		this.fx = fx;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getFl() {
		return fl;
	}

	public void setFl(String fl) {
		this.fl = fl;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "YesterdayVO [date=" + date + ", high=" + high + ", fx=" + fx + ", low=" + low + ", fl=" + fl + ", type="
				+ type + "]";
	}

}
