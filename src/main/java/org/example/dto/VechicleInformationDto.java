package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class VechicleInformationDto {
	
	private Long id;
	private String vechicleNumber;
	private String district;
	private String state;
	private Long districtCode;
	private String manufactureYear;

}
