package com.sample.pdf.main.jpa;

import org.springframework.stereotype.Repository;

import com.sample.pdf.main.model.City;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface CityRepository extends CrudRepository<City, Long>{

}
