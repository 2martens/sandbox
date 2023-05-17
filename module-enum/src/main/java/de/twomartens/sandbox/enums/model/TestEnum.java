package de.twomartens.sandbox.enums.model;

import java.util.Collection;
import java.util.List;
import lombok.Getter;

@Getter
public enum TestEnum implements AscEnum {
  SOMETHING("SOMETHING"),
  OTHER("OTHER");

  private final Collection<String> ascStrings;

  TestEnum(String... ascString) {
    this.ascStrings = List.of(ascString);
  }
}
