package com.xxx.weather.job;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.xxx.weather.service.CityDataService;
import com.xxx.weather.vo.City;

/**
 * 天气数据同步
 *
 * @author xiong.xinxin
 * @date 2019-5-4
 */
public class WeatherDataSyncJob extends QuartzJobBean {
	private final static Logger log = LoggerFactory.getLogger(WeatherDataSyncJob.class);
	
	@Autowired
	private CityDataService cityDataService;

	/**
	 * 
	 * 
	 * @param context
	 * @throws JobExecutionException
	 * @author xiong.xinxin
	 * @date 2019-5-4
	 */
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		log.info("数据同步开始");
		
		try {
			List<City> listCity = this.cityDataService.listCity();
			listCity.forEach(x->System.out.println(x));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
