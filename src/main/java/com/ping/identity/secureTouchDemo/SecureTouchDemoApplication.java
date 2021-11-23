package com.ping.identity.secureTouchDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SecureTouchDemoApplication {

	private static final Logger log = LoggerFactory.getLogger(SecureTouchDemoApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SecureTouchDemoApplication.class, args);
		checkDBTableConnection(applicationContext);
	}


	private static void checkDBTableConnection(ConfigurableApplicationContext applicationContext){
		try {
			applicationContext.getBean(CounterRepository.class);
			applicationContext.getBean(SessionRepository.class);
		}
		catch (Exception ex){
			log.error(" * * * Connection problem with DB's Table , please check * * *");
		}
	}
}
