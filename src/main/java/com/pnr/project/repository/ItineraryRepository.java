package com.pnr.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pnr.project.entity.Itinerary;

@Repository
public interface ItineraryRepository extends JpaRepository<Itinerary, Integer> {

}
