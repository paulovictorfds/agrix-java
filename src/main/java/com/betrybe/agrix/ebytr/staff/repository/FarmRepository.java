package com.betrybe.agrix.ebytr.staff.repository;

import com.betrybe.agrix.ebytr.staff.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** FarmRepository. */
@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> { }
