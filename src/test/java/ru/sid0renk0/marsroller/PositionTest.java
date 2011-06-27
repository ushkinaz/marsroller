package ru.sid0renk0.marsroller;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * Come funny tests.
 */
public class PositionTest {

  private static final int MAGIC_5 = 5;
  private static final int MAGIC_6 = 6;
  private Position position;

  @Before
  public void setUp() {
    position = new Position(MAGIC_5, MAGIC_6);
  }

  @Test
  public void testGetX() {
    assertThat(position.getX(), is(MAGIC_5));
  }

  @Test
  public void testGetY() {
    assertThat(position.getY(), is(MAGIC_6));
  }

  @Test
  public void testEquals() {
    assertThat(new Position(MAGIC_5, MAGIC_6), is(new Position(MAGIC_5, MAGIC_6)));
  }

  @Test
  public void testNotEquals() {
    assertThat(new Position(MAGIC_5, MAGIC_6), not(new Position(MAGIC_6, MAGIC_6)));
  }

  @Test
  public void testHashCode() {
    assertThat(new Position(MAGIC_5, MAGIC_6).hashCode(), is(new Position(MAGIC_5, MAGIC_6).hashCode()));
  }

}
