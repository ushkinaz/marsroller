package ru.sid0renk0.marsroller;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FlatSurfaceTest {
  private static final int SIZE = 4;
  private FlatSurface surface;

  @Before
  public void setUp() throws Exception {
    surface = new FlatSurface(SIZE, SIZE);
  }

  @Test(expected = AssertionError.class)
  public void testInitialize() throws Exception {
    new FlatSurface(-1, 0);
  }

  @Test(expected = OutOfSurfaceException.class)
  public void testValidatePositionNegative() throws Exception {
    surface.validatePosition(new Position(SIZE + 1, 1));
  }

  @Test(expected = OutOfSurfaceException.class)
  public void testValidatePositionNegativeSubZero() throws Exception {
    surface.validatePosition(new Position(0, 0));
  }

  @Test
  public void testValidatePosition() throws Exception {
    surface.validatePosition(new Position(1, 1));
  }

  @Test
  public void testMoveEast() throws Exception {
    Position initialPosition = new Position(1, 1);
    Position newPosition = surface.move(initialPosition, Direction.EAST, 1);
    assertThat(newPosition, is(new Position(2, 1)));
  }

  @Test(expected = OutOfSurfaceException.class)
  public void testMoveSouthNegative() throws Exception {
    Position initialPosition = new Position(1, 1);
    Position newPosition = surface.move(initialPosition, Direction.SOUTH, 1);
  }

  @Test(expected = OutOfSurfaceException.class)
  public void testMoveWestNegative() throws Exception {
    Position initialPosition = new Position(1, 1);
    Position newPosition = surface.move(initialPosition, Direction.WEST, 1);
  }

  @Test
  public void testMoveSouthOk() throws Exception {
    Position initialPosition = new Position(1, 2);
    Position newPosition = surface.move(initialPosition, Direction.SOUTH, 1);
    assertThat(newPosition, is(new Position(1, 1)));
  }

  @Test
  public void testMoveWestOk() throws Exception {
    Position initialPosition = new Position(2, 1);
    Position newPosition = surface.move(initialPosition, Direction.WEST, 1);
    assertThat(newPosition, is(new Position(1, 1)));
  }

  @Test
  public void testMoveNorth() throws Exception {
    Position initialPosition = new Position(1, 1);
    Position newPosition = surface.move(initialPosition, Direction.NORTH, 1);
    assertThat(newPosition, is(new Position(1, 2)));
  }
}
