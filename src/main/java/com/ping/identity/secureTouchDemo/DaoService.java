package com.ping.identity.secureTouchDemo;



import com.ping.identity.secureTouchDemo.model.Session;

import java.util.List;


public interface DaoService {
  List<String> getCountersFromDB();
  List<Session> getAllSessionsFromDB();
  public void updateH2DB();
}
