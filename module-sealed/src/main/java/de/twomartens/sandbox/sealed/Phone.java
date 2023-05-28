package de.twomartens.sandbox.sealed;

public record Phone(String phoneNumber) implements ContactMethod {

  @Override
  public void send(String message) {
    System.out.println("Sending SMS to " + phoneNumber + " with message: " + message);
  }
}
