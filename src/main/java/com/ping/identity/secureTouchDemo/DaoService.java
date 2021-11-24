package com.ping.identity.secureTouchDemo;



import com.ping.identity.secureTouchDemo.model.Counter;
import com.ping.identity.secureTouchDemo.model.Session;

import java.util.List;


public interface DaoService {
  Counter getCountersFromDB();
  List<Session> getAllSessionsFromDB();
  public void updateH2DB();
}
