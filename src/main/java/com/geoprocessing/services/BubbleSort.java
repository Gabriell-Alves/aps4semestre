package com.geoprocessing.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.geoprocessing.entities.Coordinate;
import com.geoprocessing.entities.Ordination;

@Service
public class BubbleSort implements OrdinationInterface {

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
		obj.setElements100000(ordination(coordinates.stream().limit(100000).collect(Collectors.toList()), orderBy));
	}
	
	@Override
	public void ordinationPerLatitude(List<Coordinate> list) {
		Coordinate next = null;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < (list.size() - 1 - i); j++) {
				if (list.get(j).getLatitude() > list.get(j + 1).getLatitude()) {
					next = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, next);
				}
			}
		}
	}

	@Override
	public void ordinationPerLongitude(List<Coordinate> list) {
		Coordinate next = null;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < (list.size() - 1 - i); j++) {
				if (list.get(j).getLongitude() > list.get(j + 1).getLongitude()) {
					next = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, next);
				}
			}
		}
	}

	@Override
	public void ordinationPerSituation(List<Coordinate> list) {
		Coordinate next = null;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < (list.size() - 1 - i); j++) {
				if (list.get(j).getSituation().compareTo(list.get(j + 1).getSituation()) < 0) {
					next = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, next);
				}
			}
		}
	}

	@Override
	public void ordinationPerId(List<Coordinate> list) {
		Coordinate next = null;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < (list.size() - 1 - i); j++) {
				if (list.get(j).getId() > list.get(j + 1).getId()) {
					next = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, next);
				}
			}
		}
	}

}
