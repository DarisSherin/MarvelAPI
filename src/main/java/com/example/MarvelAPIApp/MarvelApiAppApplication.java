package com.example.MarvelAPIApp;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import com.example.MarvelAPIApp.Constant.Constants;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableCaching
@EnableSwagger2
@EnableScheduling
@SpringBootApplication
public class MarvelApiAppApplication {
	 private static final Logger logger = LoggerFactory.getLogger(MarvelApiAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MarvelApiAppApplication.class, args);
	}
	
    @Bean(name = "restTemplate")
    RestTemplate restTemplate() {
    	 RestTemplate restTemplate = new RestTemplate();
         List<HttpMessageConverter<?>> mc = restTemplate.getMessageConverters();
         // Add JSON message Converter
         MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
         List<MediaType> supportedMediaTypes = new ArrayList<>();
         supportedMediaTypes.add(new MediaType(Constants.MEDIA_TYPE, Constants.TYPE_JSON,
                 Charset.forName(Constants.FOR_NAME)));
         supportedMediaTypes.add(new MediaType(Constants.MEDIA_TYPE, Constants.TYPE_STREAM,
                 Charset.forName(Constants.FOR_NAME)));
         mappingJacksonHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
         mc.add(mappingJacksonHttpMessageConverter);
         restTemplate.setMessageConverters(mc);
        return restTemplate;
}
    
    @CacheEvict(value ="characterdetails",allEntries = true)
    @Scheduled(fixedDelayString = "${cache-clear-time}")
    public void cacheEvict() {
        logger.info("Cache Cleared");
    }


}
