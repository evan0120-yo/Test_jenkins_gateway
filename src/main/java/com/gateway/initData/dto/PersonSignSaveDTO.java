package com.gateway.initData.dto;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonSignSaveDTO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String personId;
	
	private String sunId;
	
	private LocalDate birthDay;
	
	private String moonId;
	
	private String raiseId;
	
	
}