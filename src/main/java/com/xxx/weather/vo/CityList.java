package com.xxx.weather.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 城市集合
 *
 * @author xiong.xinxin
 * @date 2019-5-4
 */
@XmlRootElement(name = "c")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {
	@XmlElement(name = "d")
	private List<City> cityList;

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	@Override
	public String toString() {
		return "CityList [cityList=" + cityList + "]";
	}

}
