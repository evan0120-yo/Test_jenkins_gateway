package com.gateway.initData.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gateway.initData.model.PersonSign;
import com.gateway.initData.model.id.PersonSignId;

public interface PersonSignRepository extends JpaRepository<PersonSign,PersonSignId> {

}
