package de.twomartens.sandbox.sealed;

public record Email(String email) implements ContactMethod {

  @Override
  public void send(String message) {
    System.out.println("Sending email to " + email + " with message: " + message);
  }
}
