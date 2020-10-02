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
	
	@Autowired
	private OrdinationService ordinationService;
	
	@Transactional
	public List<Coordinate> findAll(){
		return repository.findAll();
	}
	
	public List<Coordinate> FindByOrdination(Long id){
		List<Coordinate> list = findAll();
		ordinationService.sort(list, id);
		return list;
	}

}

/* Criar um metodo
 * PageRequest pageRequest = PageRequest.of(2, 50, Direction.valueOf("ASC"), "");
 * Page<Coordinate> ord = new PageImpl<Coordinate>(list, pageRequest, list.size());
 */
 
