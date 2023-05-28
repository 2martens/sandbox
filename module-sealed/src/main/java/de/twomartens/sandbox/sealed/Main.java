package de.twomartens.sandbox.sealed;

import java.util.Collection;
import java.util.List;

public class Main {

  private int mailCounter = 0;
  private int phoneCounter = 0;
  private int emailCounter = 0;

  public static void main(String[] args) {
    Collection<ContactMethod> contactMethods = List.of(
        new Phone("+49 123 456789"),
        new Mail("Some Street 1, 12345 Some City"),
        new Email("kontakt@something.de")
    );

    Main main = new Main();

    contactMethods.forEach(contactMethod -> main.send(contactMethod, "Hello World!"));
    contactMethods.forEach(contactMethod -> main.send(contactMethod, "Doomsday!"));
    System.out.println("Sent " + main.mailCounter + " mails, " + main.phoneCounter
        + " SMS and " + main.emailCounter + " emails.");
  }

  private void send(ContactMethod contactMethod, String message) {
    switch (contactMethod) {
      case Phone phone -> sendPhone(phone, message);
      case Mail mail -> sendMail(mail, message);
      case Email email -> sendEmail(email, message);
    }
  }

  private void sendPhone(Phone phone, String message) {
    phoneCounter++;
    phone.send(message);
  }

  private void sendMail(Mail mail, String message) {
    mailCounter++;
    mail.send(message);
  }

  private void sendEmail(Email email, String message) {
    emailCounter++;
    email.send(message);
  }
}
