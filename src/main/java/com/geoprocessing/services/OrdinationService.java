package com.geoprocessing.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.geoprocessing.entities.Coordinate;
import com.geoprocessing.entities.Ordination;
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

	public Page<Coordinate> sort(List<Coordinate> list, Long id, PageRequest pageable, String orderBy ) {
		Ordination newObj = repository.findById(id).get();
		List<Coordinate> newList= null;
		switch (newObj.getName()) {
		case SELECTION_SORT:
			newList = selectionSort.addList(list, newObj, orderBy);
			break;
		case BUBBLE_SORT:

			break;
		default:
			break;
		}
		repository.save(newObj);
		return listToPage(newList, pageable);
	}
	
	public Page<Coordinate> listToPage(List<Coordinate> list, PageRequest pageable){
		List<Coordinate> newList = list.stream()
				.skip(pageable.getPageSize() * pageable.getPageNumber())
				.limit(pageable.getPageSize())
				.collect(Collectors.toList());
		return new PageImpl<Coordinate>(newList, pageable, list.size());
	}

}
