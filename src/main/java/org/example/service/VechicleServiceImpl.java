package org.example.service;

import java.util.Comparator;
import java.util.List;

import org.example.dto.VechicleInformationDto;
import org.example.entity.VechicleInfo;
import org.example.repository.VechicleRepository;
import org.modelmapper.ModelMapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class VechicleServiceImpl implements VechicleService {

	@Inject
	VechicleRepository vechileRepository;

	@Inject
	ModelMapper mapper;

	@Override
	@Transactional
	public VechicleInformationDto saveVechicleInfo(VechicleInformationDto vechicleInformationDto) {
		try {
			VechicleInfo vechicleInfo = mapper.map(vechicleInformationDto, VechicleInfo.class);
			vechileRepository.persist(vechicleInfo);
			return mapper.map(vechicleInfo, VechicleInformationDto.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error While Saving the Vechicle Information");
		}
	}

	@Override
	public List<VechicleInformationDto> getAllVechicles() {
		try {
			List<VechicleInfo> infos = vechileRepository.listAll();
			List<VechicleInformationDto> informationDtos = infos.stream().filter(response -> response != null)
					.sorted(Comparator.comparing(VechicleInfo::getId).reversed())
					.map(result -> mapper.map(result, VechicleInformationDto.class)).toList();
			return informationDtos;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error While getting the Vechicle Information");
		}
	}

	@Override
	public VechicleInformationDto getVechicleInfo(Long id) {
		try {
			VechicleInfo infos = vechileRepository.findById(id);
			VechicleInformationDto informationDtos = mapper.map(infos, VechicleInformationDto.class);
			return informationDtos;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error While getting the Vechicle Information");
		}
	}

	@Override
	@Transactional
	public VechicleInformationDto deleteVechicleInfo(Long id) {
		try {
			VechicleInfo infos = vechileRepository.findById(id);
			vechileRepository.deleteById(id);
			VechicleInformationDto vechicleInformationDto = mapper.map(infos, VechicleInformationDto.class);
			return vechicleInformationDto;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error While getting the Vechicle Information");
		}
	}

	@Override
	@Transactional
	public VechicleInformationDto updateVechicleInfo(VechicleInformationDto vechicleInformationDto) {
		try {
			VechicleInfo infos = vechileRepository.findById(vechicleInformationDto.getId());
			infos.setDistrict(vechicleInformationDto.getDistrict());
			infos.setDistrictCode(vechicleInformationDto.getDistrictCode());
			infos.setManufactureYear(vechicleInformationDto.getManufactureYear());
			infos.setState(vechicleInformationDto.getState());
			infos.setVechicleNumber(vechicleInformationDto.getVechicleNumber());
			vechileRepository.persist(infos);
			VechicleInformationDto vechicleInformation = mapper.map(infos, VechicleInformationDto.class);
			return vechicleInformation;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error While getting the Vechicle Information");
		}
	}

}
