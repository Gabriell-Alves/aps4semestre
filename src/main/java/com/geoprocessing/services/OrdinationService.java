package com.geoprocessing.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geoprocessing.entities.Coordinate;
import com.geoprocessing.entities.Ordination;
import com.geoprocessing.entities.enuns.SortName;
import com.geoprocessing.repositories.OrdinationRepository;

@Service
public class OrdinationService {
	
	@Autowired
	private OrdinationRepository repository;
	
	@Autowired
	private SelectionSort selectionSort;
	
	@Transactional
	public Ordination findById(Long id){
		return repository.findById(id).get();
	}

	public void sort(List<Coordinate> list, Long id) {
		Ordination newObj = repository.findById(id).get();
		switch (newObj.getName()) {
		case SELECTION_SORT:
			selectionSort.selectionSortAddList(list);
			break;

		default:
			break;
		}
			
	
		
	}

}
