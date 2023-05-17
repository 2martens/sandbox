package de.twomartens.sandbox.enums.model;

import java.util.Collection;
import java.util.List;

public enum TestEnum implements AscEnum {
  SOMETHING("SOMETHING"),
  OTHER("OTHER");

  private final Collection<String> ascStrings;

  TestEnum(String... ascString) {
    this.ascStrings = List.of(ascString);
  }

  public Collection<String> getAscStrings() {
    return this.ascStrings;
  }
}
