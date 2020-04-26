package com.sample.pdf.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.pdf.main.jpa.CityRepository;
import com.sample.pdf.main.model.City;

@Service
public class CityService implements ICityService{

	@Autowired
	private CityRepository repository;
	
	@Override
	public List<City> findAll() {
		// TODO Auto-generated method stub
		return (List<City>)repository.findAll();
	}

}
