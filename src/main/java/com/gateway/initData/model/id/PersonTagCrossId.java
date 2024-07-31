package com.gateway.initData.model.id;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class PersonTagCrossId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "PERSON_ID")
	private String personId;
	
	@Column(name = "PERSON_TAG_ID")
	private String personTagId;
	
}
