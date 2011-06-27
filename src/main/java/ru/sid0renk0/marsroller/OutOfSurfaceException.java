package ru.sid0renk0.marsroller;

public class OutOfSurfaceException extends Exception{
  public OutOfSurfaceException() {
  }

  public OutOfSurfaceException(String message) {
    super(message);
  }

  public OutOfSurfaceException(String message, Throwable cause) {
    super(message, cause);
  }

  public OutOfSurfaceException(Throwable cause) {
    super(cause);
  }
}
