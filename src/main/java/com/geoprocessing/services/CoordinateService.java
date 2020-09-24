package com.geoprocessing.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geoprocessing.entities.Coordinate;
import com.geoprocessing.repositories.CoordinateRepository;

@Service
public class CoordinateService {
	
	@Autowired
	private CoordinateRepository repository;
	
	@Transactional
	public List<Coordinate> findAll(){
		return repository.findAll();
	}
	
	

}
