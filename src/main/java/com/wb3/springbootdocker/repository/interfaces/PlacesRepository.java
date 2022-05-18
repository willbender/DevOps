package com.wb3.springbootdocker.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wb3.springbootdocker.data.domain.schema1.Place;

public interface PlacesRepository extends JpaRepository<Place, Long> {

}