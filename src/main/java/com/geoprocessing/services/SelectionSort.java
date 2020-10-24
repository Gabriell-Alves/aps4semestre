package com.geoprocessing.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.geoprocessing.entities.Coordinate;
import com.geoprocessing.entities.Ordination;

@Service
public class SelectionSort implements OrdinationInterface{
	
	private List<Coordinate> coordinates = new ArrayList<>();
	
	@Override
	public List<Coordinate> addList(List<Coordinate> list, Ordination newObj, String orderBy) {
		this.coordinates = list;
		updateOrdination(newObj, orderBy);
		ordination(this.coordinates, orderBy);
		return this.coordinates;
	}
	
	@Override	
	public Long ordination(List<Coordinate> list, String orderBy) {
		Long startOfordinationing = System.currentTimeMillis();
		switch (orderBy) {
		case "longitude":
			ordinationPerLongitude(list);
			break;
		case "latitude":
			ordinationPerLatitude(list);
			break;
		case "situation":
			ordinationPerSituation(list);
			break;
		case "id":
			ordinationPerId(list);
			break;
		default:
			break;
		}
		Long endOfordinationing = System.currentTimeMillis();
		return endOfordinationing - startOfordinationing;
	}
	
	@Override
	public void updateOrdination(Ordination obj, String orderBy) {
		obj.setElements100(ordination(coordinates.stream().limit(100).collect(Collectors.toList()), orderBy));
		obj.setElements1000(ordination(coordinates.stream().limit(1000).collect(Collectors.toList()), orderBy));
		obj.setElements10000(ordination(coordinates.stream().limit(10000).collect(Collectors.toList()), orderBy));
		obj.setElements5000(ordination(coordinates.stream().limit(5000).collect(Collectors.toList()), orderBy));
	}
	
	@Override
	public void ordinationPerLatitude(List<Coordinate> list){
		for (int i = 0; i < list.size(); i++) {
			Integer smaller = i;
		    for (int j = smaller + 1; j < list.size(); j++) {
		    	//Compare the elements
		       if (list.get(j).getLatitude() < list.get(smaller).getLatitude()) {
		    	   smaller = j;
		       }
		    }
		    //exchange elements
		    if(i != smaller ) {
		    	Coordinate change = list.get(i);
		    	list.set(i, list.get(smaller));
		    	list.set(smaller, change);
		    }
		}
	}
	
	@Override
	public void ordinationPerLongitude(List<Coordinate> list){
		for (int i = 0; i < list.size(); i++) {
			Integer smaller = i;
		    for (int j = smaller + 1; j < list.size(); j++) {
		    	//Compare the elements
		       if (list.get(j).getLongitude() < list.get(smaller).getLongitude()) {
		    	   smaller = j;
		       }
		    }
		    //exchange elements
		    if(i != smaller ) {
		    	Coordinate change = list.get(i);
		    	list.set(i, list.get(smaller));
		    	list.set(smaller, change);
		    }
		}
	}
	
	@Override
	public void ordinationPerSituation(List<Coordinate> list){
		for (int i = 0; i < list.size(); i++) {
			Integer smaller = i;
		    for (int j = smaller + 1; j < list.size(); j++) {
		    	//Compare the elements
		       if (list.get(j).getSituation().compareTo( list.get(smaller).getSituation()) <= 0) {
		    	   smaller = j;
		       }
		    }
		    //exchange elements
		    if(i != smaller ) {
		    	Coordinate change = list.get(i);
		    	list.set(i, list.get(smaller));
		    	list.set(smaller, change);
		    }
		}
	}
	
	@Override
	public void ordinationPerId(List<Coordinate> list){
		for (int i = 0; i < list.size(); i++) {
			Integer smaller = i;
		    for (int j = smaller + 1; j < list.size(); j++) {
		    	//Compare the elements
		       if (list.get(j).getId() < list.get(smaller).getId()) {
		    	   smaller = j;
		       }
		    }
		    //exchange elements
		    if(i != smaller ) {
		    	Coordinate change = list.get(i);
		    	list.set(i, list.get(smaller));
		    	list.set(smaller, change);
		    }
		}
	}

}
