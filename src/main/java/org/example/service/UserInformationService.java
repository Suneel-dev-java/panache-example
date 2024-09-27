package org.example.service;

import java.util.List;

import org.example.dto.UserInformationDto;

public interface UserInformationService {

	UserInformationDto saveUserInforamtion(UserInformationDto userInformationDto);

	List<UserInformationDto> getAllUserInfo();

	UserInformationDto deleteUserInformation(Long id);

}
