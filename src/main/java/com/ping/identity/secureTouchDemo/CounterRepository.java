package com.ping.identity.secureTouchDemo;

import com.ping.identity.secureTouchDemo.model.Counter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterRepository extends CrudRepository<Counter,Integer> {
}