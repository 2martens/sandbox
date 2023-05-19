package de.twomartens.sandbox.kata;

import java.util.Collection;
import java.util.List;

public class Tool {
  public static String disemvowel(String str) {
    Collection<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
    StringBuilder builder = new StringBuilder();
    for (char c: str.toCharArray()) {
      if (!vowels.contains(c)) {
        builder.append(c);
      }
    }
    return builder.toString();
  }
}
