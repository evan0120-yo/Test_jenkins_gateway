package com.gateway.initData.model;

import java.util.Set;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Element implements java.io.Serializable {
	// 水火風土
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "ELEMENT_ID")
	private String elementId;
	
	private String elementName;
	
	private String mentalImage;
	
	@OneToMany
	private Set<ElementTrait> elementTraits;
	
}
