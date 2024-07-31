package com.gateway.initData.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gateway.initData.model.PersonNote;

public interface PersonNoteRepository extends JpaRepository<PersonNote,String> {

}
