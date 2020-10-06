package com.geoprocessing.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.geoprocessing.entities.Coordinate;
import com.geoprocessing.repositories.CoordinateRepository;

@Service
public class CoordinateService {
	
	@Autowired
	private CoordinateRepository repository;
	
	@Autowired
	private OrdinationService ordinationService;
	
	@Transactional
	public List<Coordinate> findAll(){
		return repository.findAll();
	}
	
	public Page<Coordinate> FindByOrdination(Long id, PageRequest pageable, String orderBy){
		List<Coordinate> list = findAll();
		Page<Coordinate> page = ordinationService.sort(list, id, pageable, orderBy);
		return page;
	}

}