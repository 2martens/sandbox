package de.twomartens.sandbox.kata;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CamelCase {

  public static String toCamelCase(String s) {
    String[] words = s.split("[_-]");
    String firstWord = words[0];
    String upperCase = Arrays.stream(words)
        .skip(1)
        .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
        .collect(Collectors.joining());
    return firstWord + upperCase;
  }
}
