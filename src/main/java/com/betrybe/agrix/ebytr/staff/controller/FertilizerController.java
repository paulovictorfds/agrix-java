package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.controller.dto.FertilizerDto;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.service.FertilizerService;
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

/** Fertilizer Controller. */
@RestController
@RequestMapping("/fertilizers")
public class FertilizerController {
  private final FertilizerService fertilizerService;

  @Autowired
  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  /** Post Fertilizer. */
  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public FertilizerDto createFarm(@RequestBody FertilizerDto fertilizerDto) {
    Fertilizer newFertilizer = fertilizerService.insertFertlizer(fertilizerDto.toEntity());

    return FertilizerDto.fromEntity(newFertilizer);
  }

  /** GET Fertilizer. */
  @GetMapping
  @Secured("ADMIN")
  public List<FertilizerDto> findAll() {
    List<Fertilizer> fertilizers = fertilizerService.findAll();

    return fertilizers.stream()
        .map(FertilizerDto::fromEntity)
        .toList();
  }

  /** Route GET Fertilizer by id. */
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public FertilizerDto getFertilizerById(@PathVariable Long id) {

    Fertilizer fertilizer = fertilizerService.findById(id);

    return FertilizerDto.fromEntity(fertilizer);
  }
}
