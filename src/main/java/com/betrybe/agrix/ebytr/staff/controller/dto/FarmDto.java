package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Farm;

/** FarmDto. */
public record FarmDto(Long id, String name, Double size) {

  public static FarmDto fromEntity(Farm farm) {
    return new FarmDto(farm.getId(), farm.getName(), farm.getSize());
  }

  /** toEntity. */
  public Farm toEntity() {
    Farm farm = new Farm();
    farm.setName(name);
    farm.setSize(size);

    return farm;
  }

}
