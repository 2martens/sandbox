package de.twomartens.sandbox.kata;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindOdd {

  public static int findIt(int[] a) {
    Map<Integer, Long> numbers = Arrays.stream(a)
        .boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    return numbers.entrySet().stream()
        .filter(entry -> entry.getValue() % 2 == 1)
        .findFirst()
        .map(Map.Entry::getKey)
        .orElseThrow();
  }
}
