package com.ping.identity.secureTouchDemo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sessions")
public class Session {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer Id;

  private Integer ordinal;
  private Integer sessionId;
  private String username;
  private Boolean authenticated;
  private Boolean fraud;
  private Boolean emulator;


  public Session(){}

  public Session(Integer ordinal, Integer sessionId, String username, Boolean authenticated, Boolean fraud, Boolean emulator) {
    this.ordinal = ordinal;
    this.sessionId = sessionId;
    this.username = username;
    this.authenticated = authenticated;
    this.fraud = fraud;
    this.emulator = emulator;
  }

  public Integer getId() {
    return Id;
  }

  public Integer getOrdinal() {
    return ordinal;
  }

  public Integer getSessionId() {
    return sessionId;
  }

  public String getUsername() {
    return username;
  }

  public Boolean isAuthenticated() {
    return authenticated;
  }

  public Boolean isFraud() {
    return fraud;
  }

  public Boolean isEmulator() {
    return emulator;
  }

  public void setOrdinal(Integer ordinal) {
    this.ordinal = ordinal;
  }

  public void setSessionId(Integer sessionId) {
    this.sessionId = sessionId;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setAuthenticated(Boolean authenticated) {
    this.authenticated = authenticated;
  }

  public void setFraud(Boolean fraud) {
    this.fraud = fraud;
  }

  public void setEmulator(Boolean emulator) {
    this.emulator = emulator;
  }



}
