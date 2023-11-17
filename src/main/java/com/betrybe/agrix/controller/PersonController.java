package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.PersonRequestDto;
import com.betrybe.agrix.controller.dto.PersonResponseDto;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/** PersonController. */
@RestController
@RequestMapping("/persons")
public class PersonController {
  private final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  /** Route to POST a Person. */
  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public PersonResponseDto save(@RequestBody PersonRequestDto personRequestDto) {
    Person newPerson = personService.create(personRequestDto.toEntity());

    return PersonResponseDto.fromEntity(newPerson);
  }
}
