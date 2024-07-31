package com.gateway.initData.model;

import java.time.LocalDate;

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
public class Sign implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	// 星座
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "SIGN_ID")
	private String signId;
	
	private String signName;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private LocalDate middleDate;
	
	private Integer serialNumber;
	
	private Element element;
	
	private String elementId;
	
}
