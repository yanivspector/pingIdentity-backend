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



//  @Override
//  public void updateCompanyDB() {
//    Request actualRequest = getXmlParserService().getActualRequest();
//    List<Event> actualRequestEvents = actualRequest.getEvents();
//    String companyNameToInsert = actualRequest.getRequestDetails().getSourceCompany();
//    if(getAllCompaniesFromDB().stream().filter(existcompany -> existcompany.equals(companyNameToInsert)).count()>0){
//      log.info("Company "+companyNameToInsert + " already exist on DB - Updating the DB with latest data for the this company");
//      deleteAllRecordsBelongsToCompanyname(companyNameToInsert);
//    }
//    actualRequestEvents.stream().forEach(eventXml -> {
//      String insuredId = eventXml.getInsuredId();
//      String type = eventXml.getType();
//      List<ProductTable> products = getProducts(eventXml.getProductList());
//            Counters eventTable = new Counters(type, insuredId,companyNameToInsert,products);
//      getEventRepository().save(eventTable);//Save to DB
//    });
//
//    String companyName = actualRequest.getRequestDetails().getSourceCompany();
//    log.info("\n*  *  * DB belongs to "+ companyName + " has been updated * * * ");
//  }
//
//  @Override
//  public List<Counters> getAllEventsByCompanyName(String companyName) {
//    Iterable<Counters> iterable = getEventRepository().findAll();
//    List<Counters> events = new ArrayList<Counters>();
//    iterable.forEach(events::add);
//    return events.stream().filter(event -> event.getCompanyName().equals(companyName))
//            .collect(Collectors.toList());
//
//  }
//
//  @Override
//  public List<ProductTable> getAllProductsByInsuredIdAndCompanyName(String insuredId, String companyName) {
//    List<Counters> allEventsByCompanyName = getAllEventsByCompanyName(companyName);
//    List<ProductTable> products = allEventsByCompanyName.stream().filter(event -> event.getInsuredId().equals(insuredId))
//            .map(event -> event.getProducts())
//            .flatMap(List::stream)
//            .collect(Collectors.toList());
//    return products;
//  }
//
//  private List<String> getAllInsuredIdsByCompanyName(String companyName){
//    List<Counters> allEventsByCompanyName = getAllEventsByCompanyName(companyName);
//    return allEventsByCompanyName.stream().map(event -> event.getInsuredId()).collect(Collectors.toList());
//  }
//
//  @Override
//  public Map<String, Map<String, List<ProductTable>>> getAllProductsByInsuredIdGroupedByCompany() {
//    Map<String, Map<String, List<ProductTable>>> companiesMap = new HashMap<>();
//    Map<String, List<ProductTable>> productMap = new HashMap<>();
//    Iterable<Counters> iterable = getEventRepository().findAll();
//    List<Counters> events = new ArrayList<Counters>();
//    iterable.forEach(events::add);
//    List<String> companies = events.stream().map(event -> event.getCompanyName())
//            .collect(Collectors.toList());
//    companies.stream().distinct().forEach(companyName -> {
//      List<String> allInsuredIdsByCompanyName = getAllInsuredIdsByCompanyName(companyName);
//      allInsuredIdsByCompanyName.forEach(insuredId -> productMap.put(insuredId,getAllProductsByInsuredIdAndCompanyName(insuredId,companyName)));
//      companiesMap.put(companyName,productMap);
//    });
//    return companiesMap;
//  }
//
//  @Override
//  public List<String> getAllCompaniesFromDB() {
//    Iterable<Counters> iterable = getEventRepository().findAll();
//    List<Counters> events = new ArrayList<Counters>();
//    iterable.forEach(events::add);
//    return events.stream().map(event -> event.getCompanyName())
//            .collect(Collectors.toList());
//  }
//
//  @Override
//  public void deleteAllRecordsBelongsToCompanyname(String companyName) {
//    Iterable<Counters> iterable = getEventRepository().findAll();
//    List<Counters> events = new ArrayList<Counters>();
//    iterable.forEach(events::add);
//    events.stream().filter(event -> event.getCompanyName().equals(companyName))
//            .forEach(event -> getEventRepository().delete(event));
//    log.info("* * *  All events belong to  "+ companyName + " have been deleted ");
//  }
//
//  private List<ProductTable> getProducts(List<Product> productList) {
//    List<ProductTable> productTableList = productList.stream()
//            .map(product -> getProductTable(product))
//            .collect(Collectors.toList());
//    return productTableList;
//  }
//
//  @Override
//  public ProductTable getProductTable(Product productXml) {
//    String type = productXml.getType();
//    Integer price = Integer.valueOf(productXml.getPrice());
//    String startDate = productXml.getStartDate();
//    String  endDate = productXml.getEndDate();
//    return new ProductTable(type,price,startDate,endDate);
//
////    getProductRepository().save(productTable);//Save to DB
//  }
//
//  private Date convertStringToDate(String stringDate){
//    try {
//      return new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
//    } catch (ParseException e) {
//      e.printStackTrace();
//    }
//    return null;
//  }

  @Override
  public List<String> getCountersFromDB() {
    return null;
  }

  @Override
  public List<Session> getAllSessionsFromDB() {
    return null;
  }


}
