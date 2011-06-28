package ru.sid0renk0.marsroller;

public class IncorrectCommandException extends RollerException {
  public IncorrectCommandException(char command) {
    super("Incorrect command:" + command);
  }


}
