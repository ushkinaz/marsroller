package ru.sid0renk0.marsroller;

public class RollerException extends Exception {
  public RollerException() {
  }

  public RollerException(String message) {
    super(message);
  }

  public RollerException(String message, Throwable cause) {
    super(message, cause);
  }

  public RollerException(Throwable cause) {
    super(cause);
  }
}
