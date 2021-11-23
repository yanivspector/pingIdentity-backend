package com.ping.identity.secureTouchDemo;


import com.ping.identity.secureTouchDemo.model.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends CrudRepository<Session,Integer> {
}
