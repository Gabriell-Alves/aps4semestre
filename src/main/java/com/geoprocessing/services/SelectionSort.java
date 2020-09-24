package com.geoprocessing.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.geoprocessing.entities.Coordinate;

@Service
public class SelectionSort implements OrdinationInterface {
	
	private Long timeOrdenation100;
	

	public Long getTimeOrdenation100() {
		return timeOrdenation100;
	}

	public void setTimeOrdenation100(Long timeOrdenation100) {
		this.timeOrdenation100 = timeOrdenation100;
	}

	@Override
	public List<Coordinate> ordination100(List<Coordinate> list) {
		List<Coordinate> newList = list.stream().limit(100).collect(Collectors.toList());
		Long startOfSorting = System.currentTimeMillis();
		
		//order by selection sort
		for (int i = 0; i < newList.size(); i++) {
			Integer smaller = i;

		    for (int j = smaller + 1; j < newList.size(); j++) {
		    	//Compare the elements
		       if (newList.get(j).getLatitude() < newList.get(smaller).getLatitude()) {
		    	   smaller = j;
		       }
		    }
		    
		    //exchange elements
		    if(i != smaller ) {
		    	Coordinate change = newList.get(i);
		    	newList.set(i, newList.get(smaller));
		    	newList.set(smaller, change);
		    }
		}
		Long endOfSorting = System.currentTimeMillis();
		this.timeOrdenation100 = endOfSorting - startOfSorting;
		return newList;
	}

	@Override
	public List<Coordinate> ordination1000(List<Coordinate> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coordinate> ordination10000(List<Coordinate> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coordinate> ordination100000(List<Coordinate> list) {
		// TODO Auto-generated method stub
		return null;
	}


}
