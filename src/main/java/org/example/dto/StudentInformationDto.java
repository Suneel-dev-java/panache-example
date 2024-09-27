package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class StudentInformationDto {

	private Long id;
	private String studentName;
	private String dateOfBirth;
	private String motherName;
	private String fatherName;
	private String mobileNumber;

}
