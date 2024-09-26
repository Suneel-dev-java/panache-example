package org.example.service;

import java.util.List;

import org.example.dto.VechicleInformationDto;

public interface VechicleService {

	VechicleInformationDto saveVechicleInfo(VechicleInformationDto vechicleInformationDto);

	List<VechicleInformationDto> getAllVechicles();

	VechicleInformationDto getVechicleInfo(Long id);

	VechicleInformationDto deleteVechicleInfo(Long id);

	VechicleInformationDto updateVechicleInfo(VechicleInformationDto vechicleInformationDto);

}
