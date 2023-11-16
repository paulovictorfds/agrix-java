package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.security.Role;

/** PersonDto. */
public record PersonDto(Long id, String username, String password, Role role) {

  /** fromEntity. */
  public static PersonDto fromEntity(Person person) {
    return new PersonDto(
        person.getId(),
        person.getUsername(),
        person.getPassword(),
        person.getRole()
    );
  }

  /** toEntity. */
  public Person toEntity() {
    Person person = new Person();
    person.setUsername(username);
    person.setPassword(password);
    person.setRole(role);

    return person;
  }
}
