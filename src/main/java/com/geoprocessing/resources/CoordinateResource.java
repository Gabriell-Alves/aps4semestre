package com.geoprocessing.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geoprocessing.entities.Coordinate;
import com.geoprocessing.entities.Ordination;
import com.geoprocessing.services.CoordinateService;
import com.geoprocessing.services.OrdinationService;
import com.geoprocessing.services.SelectionSort;

@RestController
@RequestMapping(value = "/coordinates")
public class CoordinateResource {
	
	@Autowired
	private CoordinateService service;
	
	@Autowired
	private SelectionSort selectionSortSevice;
	
	@Autowired
	private OrdinationService OrdinationService;
	
	@GetMapping
	public ResponseEntity<List<Coordinate>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping(value = "/sort/{id}")
	public ResponseEntity<List<Coordinate>> findAllSelectionSort(@PathVariable Long id){
		Ordination ordination = OrdinationService.findById(id);
		List<Coordinate> newList = selectionSortSevice.ordination100(service.findAll());
		ordination.setElements100(selectionSortSevice.getTimeOrdenation100());
		
		return ResponseEntity.ok().body(newList);
	}

}
