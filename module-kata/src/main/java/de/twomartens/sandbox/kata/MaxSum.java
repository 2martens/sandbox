package de.twomartens.sandbox.kata;

import java.util.Arrays;

public class MaxSum {

  public static int sequenceBetter(int[] arr) {
    int maxSum = 0;
    int currentSum = 0;
    for (int currentValue : arr) {
      currentSum = Math.max(0, currentSum + currentValue);
      maxSum = Math.max(maxSum, currentSum);
    }
    return maxSum;
  }

  public static int sequence(int[] arr) {
    if (arr.length == 0) {
      return 0;
    }
    if (Arrays.stream(arr).allMatch(value -> value < 0)) {
      return 0;
    }
    if (Arrays.stream(arr).allMatch(value -> value >= 0)) {
      return Arrays.stream(arr).sum();
    }

    int maxSum = 0;
    int currentSum = 0;
    for (int currentValue : arr) {
      boolean isNegative = currentValue < 0;
      if (currentSum > maxSum) {
        maxSum = currentSum;
      }
      if (isNegative && currentSum + currentValue < 0) {
        currentSum = 0;
        continue;
      }
      currentSum += currentValue;
    }
    if (currentSum > maxSum) {
      maxSum = currentSum;
    }
    return maxSum;
  }
}
