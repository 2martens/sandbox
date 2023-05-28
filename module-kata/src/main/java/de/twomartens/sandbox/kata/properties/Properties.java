package de.twomartens.sandbox.kata.properties;

import lombok.Getter;
import lombok.Setter;

public class Properties {
  @Getter @Setter
  private String property = "hallo";

  public static void main(String[] arguments) {
    Properties properties = new Properties();
    properties.property("");
  }
}
