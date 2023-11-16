package com.betrybe.agrix.repository;

import com.betrybe.agrix.entity.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;

/** Fertilizer Repository. */
public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {

}
