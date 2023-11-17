package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.controller.dto.CropDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.FertilizerDto;
import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.service.CropService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/** CropController. */
@RestController
@RequestMapping("/crops")
public class CropController {
  private final CropService cropService;

  @Autowired
  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  /** Route to GET all Crops. */
  @GetMapping
  @Secured({"ADMIN", "MANAGER"})
  public List<CropDto> findAll() {
    List<Crop> crops = cropService.findaAll();

    return crops.stream()
        .map(CropDto::fromEntity)
        .toList();
  }

  /** Route GET Crop by id. */
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public CropDto getCropById(@PathVariable long id) {

    Crop crop = cropService.findById(id);

    return CropDto.fromEntity(crop);
  }

  /** Route GET Crops by havest date. */
  @GetMapping("/search")
  @ResponseStatus(HttpStatus.OK)
  public List<CropDto> getCropsByHavestDate(
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end
  ) {

    List<Crop> crops = cropService.findCropsByHavestDate(start, end);

    return crops.stream()
        .map(CropDto::fromEntity)
        .toList();
  }

  /** Route POST to associate Crop and Fertilizer. */
  @PostMapping("/{cropId}/fertilizers/{fertilizerId}")
  @ResponseStatus(HttpStatus.CREATED)
  public String associateCropAndFertilizer(
      @PathVariable long cropId,
      @PathVariable long fertilizerId
  ) {

    cropService.associateCropAndFertilizer(cropId, fertilizerId);

    return "Fertilizante e plantação associados com sucesso!";
  }

  /** Route GET to find all Fertilizers by cropId. */
  @GetMapping("/{cropId}/fertilizers")
  @ResponseStatus(HttpStatus.OK)
  public List<FertilizerDto> getFertilizersByCropId(@PathVariable long cropId) {
    List<Fertilizer> fertilizers = cropService.findFertilizersByCropId(cropId);

    return fertilizers.stream()
        .map(FertilizerDto::fromEntity)
        .toList();
  }
}
