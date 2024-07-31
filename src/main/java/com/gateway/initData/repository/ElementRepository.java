package com.gateway.initData.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gateway.initData.model.Element;

public interface ElementRepository extends JpaRepository<Element,String> {

}
