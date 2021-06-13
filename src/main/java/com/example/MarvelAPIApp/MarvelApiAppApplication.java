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
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

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
        return restTemplate;
}
    
    @CacheEvict(value ="characterdetails",allEntries = true)
    @Scheduled(fixedDelayString = "${cache-clear-time}")
    public void cacheEvict() {
        logger.info("Cache Cleared");
    }


}
