package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.CropDto;
import com.betrybe.agrix.controller.dto.FarmDto;
import com.betrybe.agrix.entity.Crop;
import com.betrybe.agrix.entity.Farm;
import com.betrybe.agrix.service.FarmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/** Controller. */
@RestController
@RequestMapping(value = "/farms")
public class FarmController {

  private final FarmService farmService;

  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  /** Post Farm. */
  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public FarmDto createFarm(@RequestBody FarmDto farmDto) {
    Farm newFarm = farmService.insertFarm(farmDto.toEntity());

    return FarmDto.fromEntity(newFarm);
  }

  /** GET Farms. */
  @GetMapping
  @Secured({"ADMIN", "MANAGER", "USER"})
  public List<FarmDto> findAll() {
    List<Farm> farms = farmService.findAll();

    return farms.stream()
        .map(FarmDto::fromEntity)
        .toList();
  }

  /** Route GET Farm by id. */
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public FarmDto getFarmById(@PathVariable long id) {

    Farm farm = farmService.findById(id);

    return FarmDto.fromEntity(farm);
  }

  /** Route POST a crop into Farm. */
  @PostMapping("/{farmId}/crops")
  @ResponseStatus(HttpStatus.CREATED)
  public CropDto createCrop(@PathVariable long farmId, @RequestBody CropDto cropDto) {
    Crop newCrop = farmService.insertCrop(farmId, cropDto.toEntity());

    return CropDto.fromEntity(newCrop);
  }

  /** Route GET all crops by farm id. */
  @GetMapping("/{farmId}/crops")
  @ResponseStatus(HttpStatus.OK)
  public List<CropDto> getAllCropsByFarmId(@PathVariable long farmId) {
    List<Crop> crops = farmService.findAllCropsByFarmId(farmId);

    return crops.stream()
        .map(CropDto::fromEntity)
        .toList();
  }
}
