package com.geoprocessing.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geoprocessing.entities.Ordination;
import com.geoprocessing.repositories.OrdinationRepository;

@Service
public class OrdinationService {
	
	@Autowired
	private OrdinationRepository repository;
	
	@Transactional
	public Ordination findById(Long id){
		return repository.findById(id).get();
	}
	
	public Ordination update(Ordination obj) {
		Ordination newObj = findById(obj.getId());
		 
		return repository.save(obj);
	}

}
