package com.gateway.initData.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gateway.initData.model.PersonTagCross;
import com.gateway.initData.model.id.PersonTagCrossId;

public interface PersonTagCrossRepository extends JpaRepository<PersonTagCross,PersonTagCrossId> {

}
