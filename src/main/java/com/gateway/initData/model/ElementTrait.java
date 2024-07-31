package com.gateway.initData.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ElementTrait implements java.io.Serializable {
	// 四大像系的特徵

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "ELEMENT_TRAIT_ID")
	private String elementTraitId;
	
	@Column(name = "ELEMENT_ID")
	private String elementId;
	
	private String content;
}
