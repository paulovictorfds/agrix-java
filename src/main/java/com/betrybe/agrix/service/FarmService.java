package com.betrybe.agrix.service;

import com.betrybe.agrix.entity.Crop;
import com.betrybe.agrix.entity.Farm;
import com.betrybe.agrix.exception.FarmNotFoundException;
import com.betrybe.agrix.repository.CropRepository;
import com.betrybe.agrix.repository.FarmRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** FarmService. */
@Service
public class FarmService {
  private final FarmRepository farmRepository;

  private final CropRepository cropRepository;

  @Autowired
  public FarmService(FarmRepository farmRepository, CropRepository cropRepository) {
    this.farmRepository = farmRepository;
    this.cropRepository = cropRepository;
  }

  public Farm insertFarm(Farm farm) {
    return farmRepository.save(farm);
  }

  public List<Farm> findAll() {
    return farmRepository.findAll();
  }

  /** Get Farm from repository by ID. */
  public Farm findById(long id) {
    Optional<Farm> farm = farmRepository.findById(id);

    return farm.orElseThrow(FarmNotFoundException::new);
  }

  /** Insert a crop into a farm. */
  public Crop insertCrop(long farmId, Crop crop) {
    Farm farm = findById(farmId);

    crop.setFarm(farm);

    return cropRepository.save(crop);
  }

  /** Find all crops by farm id. */
  public List<Crop> findAllCropsByFarmId(long farmId) {

    return findById(farmId).getCrops();
  }
}
