package ru.sid0renk0.marsroller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class FlatSurfaceParametrizedTest {
  private static final int SIZE = 4;
  private FlatSurface surface;

  private final int x;
  private final int y;

  public FlatSurfaceParametrizedTest(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Parameterized.Parameters
  public static List<Object[]> data() {
    List<Object[]> params = new ArrayList<Object[]>();
    for (int x = 1; x <= SIZE; x++) {
      for (int y = 1; y <= SIZE; y++) {
        params.add(new Object[]{x, y});
      }
    }
    return params;
  }


  @Before
  public void setUp() throws Exception {
    surface = new FlatSurface(SIZE, SIZE);
  }

  @Test
  public void testValidatePosition() throws Exception {
    // No exception is good enough
    surface.validatePosition(new Position(x, y));
  }
}
