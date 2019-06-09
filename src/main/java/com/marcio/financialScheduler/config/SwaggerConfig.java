/**
 * 
 */
package com.marcio.financialScheduler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author marcio
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_12)
				.select().apis(RequestHandlerSelectors.basePackage("com.marcio.financialScheduler.controler.rest"))
				.build().apiInfo(metadata());
	}
	
	private ApiInfo metadata() {
		Contact contact = new Contact("Marcio Alves da Silva", "https://github.com/LedBass", "marcioalvesdasilva60@gmail.com");
		ApiInfo apiInfo = new ApiInfo("Financial Scheduler API", "A sample financial scheduler made using Spring Boot, Spring Data and Swagger for API documentation", "1.0", null, contact, "GNU GPLv3", "https://www.gnu.org/licenses/lgpl-3.0.html");
		return apiInfo;
	}
}
