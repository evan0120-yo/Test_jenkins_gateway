package com.gateway.initData.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDTO implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private String personName;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDay;
	@JsonFormat(pattern = "HH-mm")
	private LocalDateTime birthTime;
	
	
	private String sunId;
	
	private String moonId;
	
	private String raiseId;
}