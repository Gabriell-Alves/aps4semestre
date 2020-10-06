package com.geoprocessing.services;

import java.util.List;

import com.geoprocessing.entities.Coordinate;
import com.geoprocessing.entities.Ordination;

public interface OrdinationInterface {
	
	public List<Coordinate> addList(List<Coordinate> list, Ordination newObj, String orderBy);
	public Long ordination(List<Coordinate> list, String orderBy);
	public void updateOrdination(Ordination obj, String orderBy);
	public void ordinationPerLatitude(List<Coordinate> list);
	public void ordinationPerLongitude(List<Coordinate> list);
	public void ordinationPerSituation(List<Coordinate> list);
	public void ordinationPerId(List<Coordinate> list);

}
