package com.geoprocessing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geoprocessing.entities.Coordinate;

public interface CoordinateRepository extends JpaRepository<Coordinate, Long> {

}
