package com.xxx.weather.service;

import java.util.List;

import com.xxx.weather.vo.City;

/**
 * ��ȡ�������ݽӿ�
 *
 * @author xiong.xinxin
 * @date 2019-5-4
 */
public interface CityDataService {
	List<City> listCity() throws Exception;
}
