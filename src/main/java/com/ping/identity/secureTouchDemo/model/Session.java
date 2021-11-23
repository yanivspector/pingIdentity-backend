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
  private boolean authenticated;
  private boolean fraud;
  private boolean emulator;


  public Session(){}

  public Session(Integer ordinal, Integer sessionId, String username, boolean authenticated, boolean fraud, boolean emulator) {
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
