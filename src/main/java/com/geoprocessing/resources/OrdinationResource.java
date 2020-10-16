package com.geoprocessing.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geoprocessing.entities.Ordination;
import com.geoprocessing.services.OrdinationService;

@RestController
@RequestMapping(value = "/ordinations")
public class OrdinationResource {

	@Autowired
	private OrdinationService service;
	
	
	@GetMapping
	public ResponseEntity<List<Ordination>> findAll(){
		List<Ordination> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
