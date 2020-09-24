package com.geoprocessing.services;

import java.util.List;

import com.geoprocessing.entities.Coordinate;

public interface OrdinationInterface {
	
	public List<Coordinate>  ordination100(List<Coordinate> list);
	public List<Coordinate>  ordination1000(List<Coordinate> list);
	public List<Coordinate>  ordination10000(List<Coordinate> list);
	public List<Coordinate>  ordination100000(List<Coordinate> list);

}
