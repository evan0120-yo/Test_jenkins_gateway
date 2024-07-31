package com.gateway.initData.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gateway.initData.model.Person;

public interface PersonRepository extends JpaRepository<Person,String> {

}
