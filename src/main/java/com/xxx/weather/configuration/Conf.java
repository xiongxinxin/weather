package com.xxx.weather.configuration;

import java.nio.charset.StandardCharsets;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * 配置类
 *
 * @author xiong.xinxin
 * @date 2019年5月3日
 */
@Configuration
public class Conf {
	/**
	 * restTemplate配置HttpClient的实现
	 * 
	 * @param restTemplateBuilder
	 * @return
	 * @author xiong.xinxin
	 * @date 2019-5-3
	 */
	@Bean
	public RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory()); // 使用HttpClient，支持GZIP
		restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8)); // 支持中文编码
		return restTemplate;
	}
}
