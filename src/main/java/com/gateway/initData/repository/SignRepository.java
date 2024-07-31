package com.gateway.initData.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gateway.initData.model.Sign;

public interface SignRepository extends JpaRepository<Sign,String> {
	
    @Query("select s from Sign s where s.startDate <= :birthDay and s.endDate >= :birthDay")
	Sign findByBirthDay(LocalDate birthDay);
    
    Optional<Sign> findBySerialNumber(Integer serialNumber);
}
