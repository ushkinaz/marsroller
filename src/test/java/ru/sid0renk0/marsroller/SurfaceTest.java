package ru.sid0renk0.marsroller;

import org.junit.Before;
import org.junit.Test;

public class SurfaceTest {
  private static final int SIZE = 4;
  private Surface surface;

  @Before
  public void setUp() throws Exception {
    surface = new Surface(SIZE, SIZE);
  }

  @Test(expected = AssertionError.class)
  public void testInitialize() throws Exception {
    new Surface(-1, 0);
  }

  @Test(expected = OutOfSurfaceException.class)
  public void testValidatePositionNegative() throws Exception {
    surface.validatePosition(new Position(SIZE + 1, 1));
  }

  @Test
  public void testValidatePosition() throws Exception {
    surface.validatePosition(new Position(1, 1));
  }

}
