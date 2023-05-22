package de.twomartens.sandbox.enums;

import java.util.Arrays;

public class Average {
  public static double find_average(int[] array){
    return Arrays.stream(array)
        .sum() / (double) array.length;
  }
}
