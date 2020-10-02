package com.geoprocessing.services;

import java.util.List;

import com.geoprocessing.entities.Coordinate;

public interface OrdinationInterface {
	
	public List<Coordinate>  ordination100();
	public List<Coordinate>  ordination1000();
	public List<Coordinate>  ordination10000();
	public List<Coordinate>  ordination100000();

}
