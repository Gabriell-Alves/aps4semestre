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
import com.geoprocessing.services.exceptions.ResourceNotFoundException;

@Service
public class OrdinationService {

	@Autowired
	private OrdinationRepository repository;

	@Autowired
	private SelectionSort selectionSort;

	@Autowired
	private BubbleSort bubbleSort;
	
	@Autowired
	private QuickSort quickSort;

	@Transactional
	public Ordination findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ordination not found"));
	}
	
	@Transactional
	public List<Ordination> findAll(){
		return repository.findAll();
	}
	
	@Transactional
	public Page<Coordinate> sort(List<Coordinate> list, Long id, PageRequest pageable, String orderBy) {
		Ordination newObj = findById(id);
		switch (newObj.getName()) {
		case SELECTION_SORT:
			selectionSort.addList(list, newObj, orderBy);
			break;
		case BUBBLE_SORT:
			bubbleSort.addList(list, newObj, orderBy);
			break;
		case QUICK_SORT:
			quickSort.addList(list, newObj, orderBy);
			break;
		default:
			break;
		}
		repository.save(newObj);
		return listToPage(list, pageable);
	}

	public Page<Coordinate> listToPage(List<Coordinate> list, PageRequest pageable) {
		List<Coordinate> newList = list.stream()
				.skip(pageable.getPageSize() * pageable.getPageNumber())
				.limit(pageable.getPageSize())
				.collect(Collectors.toList());
		return new PageImpl<Coordinate>(newList, pageable, list.size());
	}

}
