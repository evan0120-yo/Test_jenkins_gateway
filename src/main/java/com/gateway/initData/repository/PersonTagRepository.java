package com.gateway.initData.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gateway.initData.model.PersonTag;

public interface PersonTagRepository extends JpaRepository<PersonTag,String> {

}
