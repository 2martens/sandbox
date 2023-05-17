package de.twomartens.sandbox.sealed;

public sealed interface ContactMethod permits Email, Phone, Mail {
  void send(String message);
}
