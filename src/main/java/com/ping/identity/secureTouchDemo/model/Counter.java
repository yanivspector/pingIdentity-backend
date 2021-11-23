package com.ping.identity.secureTouchDemo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="counters")
public class Counter {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private Integer ordinal;
  private Integer sessionId;
  private String username;
  boolean authenticated;
  boolean fraud;
  boolean emulator;

  public Counter(){};

  public Counter(Integer ordinal, Integer sessionId, String username, boolean authenticated, boolean fraud, boolean emulator) {
    this.ordinal = ordinal;
    this.sessionId = sessionId;
    this.username = username;
    this.authenticated = authenticated;
    this.fraud = fraud;
    this.emulator = emulator;
  }

  public Integer getId() {
    return id;
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

  public boolean isAuthenticated() {
    return authenticated;
  }

  public boolean isFraud() {
    return fraud;
  }

  public boolean isEmulator() {
    return emulator;
  }

}







