package com.geoprocessing.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.geoprocessing.entities.Coordinate;
import com.geoprocessing.repositories.CoordinateRepository;
import com.geoprocessing.services.exceptions.ResourceNotFoundException;

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
	
	@Transactional
	public Coordinate findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Coordinate not found"));
	}
	
	@Transactional
	public Page<Coordinate> findByOrdination(Long id, PageRequest pageable, String orderBy){
		List<Coordinate> list = findAll();
		Page<Coordinate> page = ordinationService.sort(list, id, pageable, orderBy);
		return page;
	}
	
	@Transactional
	public Page<Coordinate> findPaged(PageRequest pageable){
		return repository.findAll(pageable);
	}

	public Coordinate insert(Coordinate obj) {
		return repository.save(obj);
	}
	
	public Coordinate update(Long id, Coordinate obj) {
		Coordinate newObj = findById(id);
		newObj.setLatitude(obj.getLatitude());
		newObj.setLongitude(obj.getLongitude());
		newObj.setSituation(obj.getSituation());
		newObj.setUrlImage(obj.getUrlImage());
		newObj.setDate(new Date());
		return repository.save(newObj);
	}
	
	public void delete(Long id) {
		Coordinate obj = findById(id);
		repository.deleteById(obj.getId());
	}
	
}