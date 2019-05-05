package com.xxx.weather.configuration;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xxx.weather.job.WeatherDataSyncJob;

/**
 * 数据同步的配置类
 *
 * @author xiong.xinxin
 * @date 2019-5-4
 */
@Configuration
public class DataSyncJobConf {

	/**
	 * 定义一个JobDetail
	 * 
	 * @return JobDetail
	 * @author xiong.xinxin
	 * @date 2019-5-4
	 */
	@Bean
	public JobDetail weatherDataSyncJobDetail() {
		return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJobDetail").storeDurably()
				.build();
	}

	/**
	 * 定义一个trigger
	 * 
	 * @param weatherDataSyncJobDetail
	 * @return Trigger
	 * @author xiong.xinxin
	 * @date 2019-5-4
	 */
	@Bean
	public Trigger weatherDataSyncTrigger(JobDetail weatherDataSyncJobDetail) {
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(60)
				.repeatForever();
		return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail).withIdentity("weatherDataSyncTrigger")
				.withSchedule(scheduleBuilder).build();
	}
}
