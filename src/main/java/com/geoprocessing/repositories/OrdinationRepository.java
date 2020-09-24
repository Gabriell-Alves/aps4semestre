package com.geoprocessing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geoprocessing.entities.Ordination;

public interface OrdinationRepository extends JpaRepository<Ordination, Long> {

}
