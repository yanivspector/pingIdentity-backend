package com.ping.identity.secureTouchDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.config.ScheduledTask;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ping.identity.secureTouchDemo")
@EnableScheduling
public class SecureTouchDemoApplication {

	private static final Logger log = LoggerFactory.getLogger(SecureTouchDemoApplication.class);



	@Autowired
	DaoService daoService;


	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SecureTouchDemoApplication.class, args);
		checkDBTableConnection(applicationContext);

	}



	private static void checkDBTableConnection(ConfigurableApplicationContext applicationContext){
		try {
			 applicationContext.getBean(CounterRepository.class);
			 applicationContext.getBean(SessionRepository.class);
			 log.info("All tables status OK");
		}
		catch (Exception ex){
			log.error(" * * * Connection problem with DB's Table , please check * * *");
		}
	}
}
