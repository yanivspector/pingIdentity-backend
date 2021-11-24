package com.ping.identity.secureTouchDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@PropertySource("classpath:env/file.properties")
public class ScheduledTasks {

  @Autowired
  DaoService daoService;

  @Value("${cronTime}")
  public String cronTime;

  private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

  //Initial Delay of 100 mili seconds to sync all  DB Tables
  //Scheduler of 2 second
  @Scheduled(fixedDelay = 2000, initialDelay = 100)
//  @Scheduled(cron ="${cronTime}")
  public void reportCurrentTime() throws Exception {
    log.info("Initial delay 1 seconds , The time is now {}", dateFormat.format(new Date()));
    daoService.updateH2DB();
  }

}
