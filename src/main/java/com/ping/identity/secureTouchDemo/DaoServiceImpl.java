package com.ping.identity.secureTouchDemo;


import com.ping.identity.secureTouchDemo.model.Counter;
import com.ping.identity.secureTouchDemo.model.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class DaoServiceImpl implements DaoService {
  private static final Logger log = LoggerFactory.getLogger(DaoServiceImpl.class);

  @Autowired
  BeanFactory beanFactory;

  @Autowired
  SessionRepository sessionRepository;

  @Autowired
  CounterRepository counterRepository;


  @Override
  public void updateH2DB() {
    generateRandomSessionsAndSaveOnDB();
    generateRandomCountersAndSaveOnDB();

  }

  private void generateRandomCountersAndSaveOnDB() {
    Iterable<Counter> counters = counterRepository.findAll();
    counters.forEach(counter -> {
      Integer newThreats = getRandomNumber(1,50);
      Integer newTotalSession = getRandomNumber(100,300);
      Integer newAuthenticatedUsers = getRandomNumber(50,150);
      Integer newScoredSessions = getRandomNumber(60,80);
      Counter newCounter = new Counter();
      newCounter.setAuthenticated(newAuthenticatedUsers);
      newCounter.setScored(newScoredSessions);
      newCounter.setTotal(newTotalSession);
      newCounter.setThreats(newThreats);
      counterRepository.deleteAll();
      counterRepository.save(newCounter);
    });
  }


  private String getRandomUserName(){
    String[] usernameArray = {"Mark Otto","Jacob Throton","Israel Isaeli","Ariel Arieli","Jose Gomez","Rafael Alcaraz","Bruce Jen"};
    List<String> newUserNameList = Arrays.asList(usernameArray);
    Iterable<Session> iterableSessions = sessionRepository.findAll();
    List<Session> sessionList = new ArrayList<>();
    iterableSessions.forEach(sessionList::add);
    List<String> actualUserNames = sessionList.stream().map(session -> session.getUsername()).collect(Collectors.toList());
    return newUserNameList.stream().filter(newUserName -> !actualUserNames.contains(newUserName)).findFirst().get();
  }




  public void generateRandomSessionsAndSaveOnDB(){
    Iterable<Session> iterableSessions = sessionRepository.findAll();
    List<Session> sessionList = new ArrayList<>();
    iterableSessions.forEach(sessionList::add);
    sessionList.stream().forEach(session -> {
      Session newSession = new Session();
      Integer ordinal = session.getOrdinal();
      Integer newSessionID = session.getSessionId()+1;
      String newUserName = getRandomUserName();
      boolean newEmulatorFlag = !session.isEmulator();
      boolean newFraudFlag = !session.isFraud();
      boolean newAuthenticatedFlag = !session.isAuthenticated();
      newSession.setOrdinal(ordinal);
      newSession.setSessionId(newSessionID);
      newSession.setUsername(newUserName);
      newSession.setEmulator(newEmulatorFlag);
      newSession.setFraud(newFraudFlag);
      newSession.setAuthenticated(newAuthenticatedFlag);
      sessionRepository.delete(session);
      sessionRepository.save(newSession);
    });
  }


  private int getRandomNumber(int min , int max) {
    Random rand = new Random();
    return rand.nextInt((max - min) + 1) + min;
  }

  @Override
  public Counter getCountersFromDB() {
    Iterable<Counter> counters = counterRepository.findAll();
    List<Counter> counterList = new ArrayList<>();
    counters.forEach(counterList::add);
    return counterList.get(0);
  }

  @Override
  public List<Session> getAllSessionsFromDB() {
    Iterable<Session> iterableSessions = sessionRepository.findAll();
    List<Session> sessionList = new ArrayList<>();
    iterableSessions.forEach(sessionList::add);
    return sessionList;
  }


}
