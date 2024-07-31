package com.gateway.initData.model;

import com.gateway.initData.model.id.PersonSignId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(PersonSignId.class)
public class PersonSign implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "PERSON_ID")
	private String personId;
	
	@Id
	@Column(name = "SIGN_ID")
	private String signId;
	
	@Id
	@Column(name = "PERSON_SIGN_NUMBER")
	private int personSignNumber;
	
	private Integer percent;
	
	private Sign sign;
	
}
