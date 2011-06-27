package ru.sid0renk0.marsroller;


/**
 * Surface is a flat plane with given dimensions. Coordinates start with 1.
 */
public class Surface {
  private int width;
  private int height;

  public Surface(int width, int height) {
    assert width > 0;
    assert height > 0;
    this.width = width;
    this.height = height;
  }

  public void validatePosition(Position position) throws OutOfSurfaceException {


  }

}
