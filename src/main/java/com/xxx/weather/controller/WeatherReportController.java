package com.xxx.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.xxx.weather.service.CityDataService;
import com.xxx.weather.service.WeatherReportService;

/**
 * ��ȡ������Ϣ
 * 
 * @author xiong.xinxin
 * @date 2019-5-7
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {

	@Autowired
	private CityDataService cityDataService;
	@Autowired
	private WeatherReportService weatherReportService;

	/**
	 * ���ݳ���Id��ѯ������Ϣ
	 * 
	 * @param cityId ����ID
	 * @param model ��ͼmodel
	 * @return ��ͼ��Ϣ
	 * @throws Exception
	 */
	@GetMapping("/cityId/{cityId}")
	public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
		model.addAttribute("title", "����������Ԥ��");
		model.addAttribute("cityId", cityId);
		model.addAttribute("cityList", this.cityDataService.listCity());
		model.addAttribute("report", this.weatherReportService.getDataByCityId(cityId));

		return new ModelAndView("weather/report", "reportModel", model);
	}
}
