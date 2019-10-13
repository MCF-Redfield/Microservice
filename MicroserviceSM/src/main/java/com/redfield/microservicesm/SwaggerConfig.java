package com.redfield.microservicesm;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig
{
	@Bean
	public Docket api()
	{
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(metaInfo());
	}
	
	private ApiInfo metaInfo() {

		ApiInfo apiInfo = new ApiInfo("API Rest SOcial Media",
									"API REST Users & Posts",
									"1.0",
									"Terms of Service",
									new Contact("Matheus Correia", "https://github.com/MCF-Redfield", "matheuscf.redfield@gmail.com"),
									"Apache License Version 2.0", "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>());

		return apiInfo;
	}
}
