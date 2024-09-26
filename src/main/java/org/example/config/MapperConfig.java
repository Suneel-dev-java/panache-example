package org.example.config;

import org.modelmapper.ModelMapper;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MapperConfig {
	
	
	@jakarta.enterprise.inject.Produces
	@ApplicationScoped
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
