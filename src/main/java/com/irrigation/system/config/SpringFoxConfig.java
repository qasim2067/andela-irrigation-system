package com.irrigation.system.config;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class SpringFoxConfig {

	private static final String applicationName = "AIS";
	private static final String applicationVersion = "1.0";
	private static String lastStartup = applicationName + " was started at ";

	static {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		lastStartup = lastStartup + sdf.format(new Date());
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.irrigation.system.controller"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo()).pathMapping("");
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(applicationName, lastStartup, applicationVersion, null, null, null, null,
				Collections.emptyList());
	}
}