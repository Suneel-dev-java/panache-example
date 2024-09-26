package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "vechicle_inforamtion")
public class VechicleInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "vechicle_number")
	private String vechicleNumber;

	@Column(name = "district")
	private String district;

	@Column(name = "state")
	private String state;

	@Column(name = "district_code")
	private Long districtCode;

	@Column(name = "manufactire_year")
	private String manufactureYear;

}
