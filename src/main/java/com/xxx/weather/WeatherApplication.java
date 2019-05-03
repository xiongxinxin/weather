/**
 * 
 */
package com.xxx.weather;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 2019年5月3日 熊新新
 * 
 * @author xiong.xinxin
 *
 */

@SpringBootApplication
public class WeatherApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(WeatherApplication.class, args);
		String[] beanDefinitionNames = run.getBeanDefinitionNames();
		Arrays.asList(beanDefinitionNames).forEach(x -> System.out.println(x));
	}
}
