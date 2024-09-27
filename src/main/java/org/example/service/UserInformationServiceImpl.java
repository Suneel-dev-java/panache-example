package org.example.service;

import java.util.Comparator;
import java.util.List;

import org.example.dto.UserInformationDto;
import org.example.entity.UserInforamtion;
import org.modelmapper.ModelMapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UserInformationServiceImpl implements UserInformationService {

	@Inject
	ModelMapper mapper;

	@Override
	@Transactional
	public UserInformationDto saveUserInforamtion(UserInformationDto userInformationDto) {
		UserInforamtion userInforamtion = mapper.map(userInformationDto, UserInforamtion.class);
		userInforamtion.persist();
		return mapper.map(userInforamtion, UserInformationDto.class);
	}

	@Override
	public List<UserInformationDto> getAllUserInfo() {
		List<UserInforamtion> userInforamtions = UserInforamtion.listAll();
		List<UserInformationDto> userInformationDtos = userInforamtions.stream().filter(response -> response != null)
				.sorted(Comparator.comparing(UserInforamtion::getId).reversed())
				.map(result -> mapper.map(result, UserInformationDto.class)).toList();
		return userInformationDtos;
	}

	@Override
	@Transactional
	public UserInformationDto deleteUserInformation(Long id) {
		UserInforamtion userInforamtion = UserInforamtion.findById(id);
		userInforamtion.delete();
		return mapper.map(userInforamtion, UserInformationDto.class);
	}

}
