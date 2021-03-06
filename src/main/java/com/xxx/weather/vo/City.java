package com.xxx.weather.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 城市列表的实体类
 *
 * @author xiong.xinxin
 * @date 2019-5-4
 */
@XmlRootElement(name = "d")
@XmlAccessorType(XmlAccessType.FIELD)
public class City {

	@XmlAttribute(name = "d1")
	private String cityId;
	@XmlAttribute(name = "d2")
	private String cityName;
	@XmlAttribute(name = "d3")
	private String cityCode;
	@XmlAttribute(name = "d4")
	private String province;

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + ", cityCode=" + cityCode + ", province=" + province
				+ "]";
	}

}
