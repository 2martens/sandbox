package de.twomartens.sandbox.enums.model;

import java.util.Collection;
import java.util.List;
import lombok.Getter;

@Getter
public enum OtherEnum implements AscEnum {
  BULL("bull"),
  SHIT("shit");

  private final Collection<String> ascStrings;

  OtherEnum(String... ascStrings) {
    this.ascStrings = List.of(ascStrings);
  }
}
