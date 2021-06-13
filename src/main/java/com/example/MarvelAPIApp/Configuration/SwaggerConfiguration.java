package com.example.MarvelAPIApp.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Predicate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	    @Value("${title}")
	    private String title;

	    @Value("${description}")
	    private String description;

	    @Value("${contact.emailid}")
	    private String contactEmailId;

	    @Value("${api.version}")
	    private String apiVersion;

	    @Value("${contact.name}")
	    private String apiContactName;

	    @Value("${contact.url}")
	    private String apiContactUrl;

	    @Value("${license}")
	    private String license;

	    @Value("${license.url}")
	    private String licenseUrl;

	    @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2).apiInfo(new ApiInfo(
	                title,
	                description,
	                apiVersion,
	                null,
	                new Contact(
	                        apiContactName,
	                        apiContactUrl,
	                        contactEmailId
	                ),
	                license,
	                licenseUrl,
	                Collections.emptyList()
	        )).select().paths((Predicate<String>) PathSelectors.regex("^/marvelapi/.*$")).build();
	    }

}
