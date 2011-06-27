package ru.sid0renk0.marsroller;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BasicRollerTest {
  private BasicRoller roller;

  @Before
  public void setUp() throws Exception {
    roller = new BasicRoller(new Position(1, 1), Direction.NORTH);
    roller.attachToSurface(new FlatSurface(1027, 768));
  }

  @Test
  public void testForward() throws Exception {

    roller.forward();
    assertThat(roller.getPosition(), is(new Position(1, 2)));
  }

  @Test
  public void testTurnLeft() throws Exception {
    roller.turnLeft();
    assertThat(roller.getPosition(), is(new Position(1, 1)));
    assertThat(roller.getDirection(), is(Direction.WEST));
  }

  @Test
  public void testTurnRight() throws Exception {
    roller.turnRight();
    assertThat(roller.getPosition(), is(new Position(1, 1)));
    assertThat(roller.getDirection(), is(Direction.EAST));
  }

  @Test
  public void testGetPosition() throws Exception {
    assertThat(roller.getPosition(), is(new Position(1, 1)));
  }

  @Test
  public void testGetDirection() throws Exception {
    assertThat(roller.getDirection(), is(Direction.NORTH));
  }
}
