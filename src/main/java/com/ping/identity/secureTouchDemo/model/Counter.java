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

  Integer threats;
  Integer total;
  Integer authenticated;
  Integer scored;

  public Counter() {
  }

  public Counter( Integer threats, Integer total, Integer authenticated, Integer scored) {
    this.threats = threats;
    this.total = total;
    this.authenticated = authenticated;
    this.scored = scored;
  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getThreats() {
    return threats;
  }

  public void setThreats(Integer threats) {
    this.threats = threats;
  }

  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public Integer getAuthenticated() {
    return authenticated;
  }

  public void setAuthenticated(Integer authenticated) {
    this.authenticated = authenticated;
  }

  public Integer getScored() {
    return scored;
  }

  public void setScored(Integer scored) {
    this.scored = scored;
  }


}






