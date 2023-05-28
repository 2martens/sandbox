package de.twomartens.sandbox.enums;

import de.twomartens.sandbox.enums.model.OtherEnum;
import de.twomartens.sandbox.enums.model.TestEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Store {

  private TestEnum test;
  private OtherEnum other;
}
