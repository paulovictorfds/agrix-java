package com.betrybe.agrix.service;

import com.betrybe.agrix.entity.Crop;
import com.betrybe.agrix.entity.Fertilizer;
import com.betrybe.agrix.exception.CropNotFoundException;
import com.betrybe.agrix.repository.CropRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/** CropService. */
@Service
public class CropService {
  private final CropRepository cropRepository;
  private final FertilizerService fertilizerService;

  public CropService(CropRepository cropRepository, FertilizerService fertilizerService) {
    this.cropRepository = cropRepository;
    this.fertilizerService = fertilizerService;
  }

  public List<Crop> findaAll() {
    return cropRepository.findAll();
  }

  /** GET Crop from repository by ID. */
  public Crop findById(long id) {
    Optional<Crop> crop = cropRepository.findById(id);

    return crop.orElseThrow(CropNotFoundException::new);
  }

  public List<Crop> findCropsByHavestDate(LocalDate startDate, LocalDate endDate) {
    return cropRepository.findCropsByHarvestDateBetween(startDate, endDate);
  }

  /** Associate Crop and Fertilizer. */
  public void associateCropAndFertilizer(long cropId, long fertilizerId) {
    Crop crop = findById(cropId);
    Fertilizer fertilizer = fertilizerService.findById(fertilizerId);

    crop.getFertilizers().add(fertilizer);

    cropRepository.save(crop);
  }

  public List<Fertilizer> findFertilizersByCropId(long cropId) {
    Crop crop = findById(cropId);
    return crop.getFertilizers();
  }
}
