package com.ping.identity.secureTouchDemo;


import com.ping.identity.secureTouchDemo.model.Counter;
import com.ping.identity.secureTouchDemo.model.Session;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;


@RestController
public class DemoController {


  @Autowired
  BeanFactory beanFactory;


  public DaoService getDaoService(){
    return beanFactory.getBean(DaoService.class);
  }

  @PostConstruct
  void initEventReaderController() throws IOException {
  }



  //When the Mapping back an Object it is automatically converted to 'Json' by the Dispatcher Servlet
  @GetMapping("/SecuredTouch/rest/v2/counters")
  public Counter getCounters() throws IOException {
    return getDaoService().getCountersFromDB();
  }

  @GetMapping("/SecuredTouch/rest/v2/sessions")
  public List<Session> getSessionList(){
    return getDaoService().getAllSessionsFromDB();
  }




}
