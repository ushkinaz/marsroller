package ru.sid0renk0.marsroller;

import org.junit.Test;

public class SurfaceTest {

  @Test(expected = AssertionError.class)
  public void testInitialize() throws Exception {
    new Surface(-1, 0);
  }

  @Test
  public void testMoveTo() throws Exception {
    //todo
  }
}
