package de.twomartens.sandbox.kata;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RomanNumerals {

  /*
   * I = 1
   * II = 2
   * III = 3
   * IV = 4
   * V = 5
   * VI = 6
   * VII = 7
   * VIII = 8
   * IX = 9
   * X = 10
   *
   * XL = 40
   * XLI = 41
   * XLII = 42
   * XLIII = 43
   * XLIV = 44
   * XLV = 45
   * XLVI = 46
   * XLVII = 47
   * XLVIII = 48
   * XLIX = 49
   * L = 50
   *
   * XC = 90
   * C = 100
   *
   * CD = 400
   * D = 500
   *
   * CM = 900
   * M = 1000
   */

  public String solution(int input) {
    if (input > 3999 || input < 0) {
      throw new IllegalArgumentException("Input must be between 0 and 3999");
    }

    Collection<RomanBase> numerals = List.of(
        new RomanBase(Base.THOUSAND, "M", null, null),
        new RomanBase(Base.HUNDRED, "C", "D", "M"),
        new RomanBase(Base.TEN, "X", "L", "C"),
        new RomanBase(Base.ONE, "I", "V", "X")
    );

    return numerals.stream()
        .map(base -> base.convert(input))
        .collect(Collectors.joining());
  }

  public enum Base {
    ONE(1),
    TEN(10),
    HUNDRED(100),
    THOUSAND(1000);

    private final int base;

    Base(int base) {
      this.base = base;
    }

    public int getBase() {
      return base;
    }
  }

  public record RomanBase(Base base, String one, String five, String ten) {

    public String convert(int number) {
      int baseNumber = (number / base.getBase()) % 10;
      return switch (baseNumber) {
        case 0 -> "";
        case 1 -> one;
        case 2 -> one + one;
        case 3 -> one + one + one;
        case 4 -> one + five;
        case 5 -> five;
        case 6 -> five + one;
        case 7 -> five + one + one;
        case 8 -> five + one + one + one;
        case 9 -> one + ten;
        default -> throw new IllegalStateException("Unexpected value: " + baseNumber);
      };
    }
  }
}
