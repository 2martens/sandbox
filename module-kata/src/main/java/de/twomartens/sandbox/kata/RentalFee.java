package de.twomartens.sandbox.kata;

public class RentalFee {

  private static final int INITIAL_FEE = 500;
  private static final int SANCTION_MULTIPLIER = 100;
  public static final int NR_DAYS_PER_WEEK = 7;

  public static int calculate(int numberOfDays) {
    int nrWeeks = (numberOfDays - 1) / NR_DAYS_PER_WEEK;
    int weekModifier = Math.min(nrWeeks, 1);
    return (int) (INITIAL_FEE + weekModifier * Math.pow(2, nrWeeks) * SANCTION_MULTIPLIER);
  }
}
