package com.betrybe.agrix.ebytr.staff.repository;

import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;

/** Fertilizer Repository. */
public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {

}
