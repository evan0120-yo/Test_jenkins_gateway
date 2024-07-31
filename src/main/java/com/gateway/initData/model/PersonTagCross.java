package com.gateway.initData.model;

import com.gateway.initData.model.id.PersonTagCrossId;

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
@IdClass(PersonTagCrossId.class)
public class PersonTagCross implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PERSON_TAG_ID")
	private String personTagId;
	
	@Id
	@Column(name = "PERSON_ID")
	private String personId;
	
	/**
	 * -2 -1 0 +1 +2
	 */
	private Integer range;
}
