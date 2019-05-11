package com.xxx.weather.serviceimpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.xxx.weather.service.CityDataService;
import com.xxx.weather.util.XmlBuilder;
import com.xxx.weather.vo.City;
import com.xxx.weather.vo.CityList;

/**
 * 获取城市数据
 *
 * @author xiong.xinxin
 * @date 2019-5-4
 */
@Service
public class CityDataServiceImpl implements CityDataService {
	private static final Logger log = LoggerFactory.getLogger(CityDataServiceImpl.class);
	/**
	 * 获取城市天气列表
	 * 
	 * @return
	 * @throws Exception
	 * @author xiong.xinxin
	 * @date 2019-5-5
	 */
	@Override
	public List<City> listCity() throws Exception {
		Resource resource = new ClassPathResource("citylist.xml");
		BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
		StringBuilder sb = new StringBuilder();
		String line = "";

		while ((line = br.readLine()) != null) {
			sb.append(line);
		}

		br.close();

		CityList cityList = (CityList) XmlBuilder.xmlStrToObject(sb.toString(), CityList.class);
		log.info("cityList:\n{}",JSON.toJSONString(cityList));
		return cityList.getCityList();
	}

}
