package com.geoprocessing.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.geoprocessing.entities.Coordinate;

@Service
public class SelectionSort implements OrdinationInterface {
	
	private Long timeOrdenation100;
	private Long timeOrdenation1000;
	private Long timeOrdenation10000;
	private Long timeOrdenation100000;
	private List<Coordinate> coordinates = new ArrayList<Coordinate>();
	
	public void selectionSortAddList(List<Coordinate> list) {
		this.coordinates = list;
		ordination100();
		ordination1000();
		ordination10000();
		ordination100000();
		ordination();
		}

	public Long getTimeOrdenation1000() {
		return timeOrdenation1000;
	}

	public void setTimeOrdenation1000(Long timeOrdenation1000) {
		this.timeOrdenation1000 = timeOrdenation1000;
	}

	public Long getTimeOrdenation10000() {
		return timeOrdenation10000;
	}

	public void setTimeOrdenation10000(Long timeOrdenation10000) {
		this.timeOrdenation10000 = timeOrdenation10000;
	}

	public Long getTimeOrdenation100000() {
		return timeOrdenation100000;
	}

	public void setTimeOrdenation100000(Long timeOrdenation100000) {
		this.timeOrdenation100000 = timeOrdenation100000;
	}

	public Long getTimeOrdenation100() {
		return timeOrdenation100;
	}

	public void setTimeOrdenation100(Long timeOrdenation100) {
		this.timeOrdenation100 = timeOrdenation100;
	}

	public List<Coordinate> ordination() {
		Long startOfSorting = System.currentTimeMillis();
		ordinationPerLatitude(this.coordinates);
		Long endOfSorting = System.currentTimeMillis();
		this.timeOrdenation100 = endOfSorting - startOfSorting;
		return this.coordinates;
	}
	
	@Override
	public List<Coordinate> ordination100() {
		List<Coordinate> newList = coordinates.stream().limit(100).collect(Collectors.toList());
		Long startOfSorting = System.currentTimeMillis();
		ordinationPerLatitude(newList);
		Long endOfSorting = System.currentTimeMillis();
		this.timeOrdenation100 = endOfSorting - startOfSorting;
		return newList;
	}

	@Override
	public List<Coordinate> ordination1000() {
		List<Coordinate> newList = coordinates.stream().limit(1000).collect(Collectors.toList());
		Long startOfSorting = System.currentTimeMillis();
		ordinationPerLatitude(newList);
		Long endOfSorting = System.currentTimeMillis();
		this.timeOrdenation1000 = endOfSorting - startOfSorting;
		return newList;
	}

	@Override
	public List<Coordinate> ordination10000() {
		List<Coordinate> newList = coordinates.stream().limit(10000).collect(Collectors.toList());
		Long startOfSorting = System.currentTimeMillis();
		ordinationPerLatitude(newList);
		Long endOfSorting = System.currentTimeMillis();
		this.timeOrdenation10000 = endOfSorting - startOfSorting;
		return newList;
	}

	@Override
	public List<Coordinate> ordination100000() {
		List<Coordinate> newList = coordinates.stream().limit(100000).collect(Collectors.toList());
		Long startOfSorting = System.currentTimeMillis();
		ordinationPerLatitude(newList);
		Long endOfSorting = System.currentTimeMillis();
		this.timeOrdenation100000 = endOfSorting - startOfSorting;
		return newList;
	}
	
	public List<Coordinate> ordinationPerLatitude(List<Coordinate> list){
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
		return list;
	}


}
