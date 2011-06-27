package ru.sid0renk0.marsroller.story;

import org.junit.Before;
import org.junit.Test;
import ru.sid0renk0.marsroller.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Stories {

  private Roller roller;
  private CommandCenter center;

  @Before
  public void setUp() throws Exception {
    center = new CommandCenter(new Surface(4, 4));
    roller = center.addRoller();
  }

  @Test(expected = OutOfSurfaceException.class)
  public void testFirst() throws Exception {
    roller.forward();
    roller.turnLeft();
    roller.forward();
  }

  @Test(expected = OutOfSurfaceException.class)
  public void testSecond() throws Exception {
    roller.forward();
    roller.turnLeft();
    roller.turnLeft();
    roller.forward();
  }

  @Test
  public void testThird() throws Exception {
    roller.forward();
    roller.forward();
    roller.forward();
    roller.turnRight();
    roller.forward();
    roller.turnLeft();
    roller.forward();
    assertThat(roller.getPosition(), is(new Position(4, 2)));
  }
}
