package com.gateway.initData.model.id;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class PersonSignId implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "PERSON_ID")
	private String personId;
	
	@Column(name = "SIGN_ID")
	private String signId;
	
	@Column(name = "PERSON_SIGN_NUMBER")
	private int personSignNumber;
}
