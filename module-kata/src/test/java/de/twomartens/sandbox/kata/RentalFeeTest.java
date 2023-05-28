package de.twomartens.sandbox.kata;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RentalFeeTest {

  @ParameterizedTest
  @MethodSource("getValues")
  void shouldReturn500InFirstWeek(int days, int expectedPrice) {
    int result = RentalFee.calculate(days);

    Assertions.assertThat(result).isEqualTo(expectedPrice);
  }

  static Stream<Arguments> getValues() {
    return Stream.of(
        Arguments.of(1, 500),
        Arguments.of(7, 500),
        Arguments.of(8, 700),
        Arguments.of(14, 700),
        Arguments.of(15, 900),
        Arguments.of(21, 900),
        Arguments.of(22, 1300)
    );
  }

}