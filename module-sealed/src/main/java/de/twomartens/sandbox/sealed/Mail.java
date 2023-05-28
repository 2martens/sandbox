package de.twomartens.sandbox.sealed;

public record Mail(String address) implements ContactMethod {

  @Override
  public void send(String message) {
    System.out.println("Sending mail to " + address + " with message: " + message);
  }
}
