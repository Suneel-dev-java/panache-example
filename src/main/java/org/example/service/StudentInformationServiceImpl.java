package org.example.service;

import org.example.dto.StudentInformationDto;
import org.example.entity.StudentInformation;
import org.modelmapper.ModelMapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class StudentInformationServiceImpl implements StudentInforamtionService {

	@Inject
	ModelMapper modelMapper;

	@Override
	@Transactional
	public StudentInformationDto saveStudentInfo(StudentInformationDto studentInformationDto) {
		StudentInformation studentInformation = modelMapper.map(studentInformationDto, StudentInformation.class);
		studentInformation.persist();
		return modelMapper.map(studentInformation, StudentInformationDto.class);
	}

}
