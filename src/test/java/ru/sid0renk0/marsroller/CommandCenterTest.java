package ru.sid0renk0.marsroller;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CommandCenterTest {
  private CommandCenter commandCenter;

  @Before
  public void setUp() throws Exception {
    commandCenter = new CommandCenter(new FlatSurface(4, 4));
  }

  @Test
  public void testAddRoller() throws Exception {
    Roller roller = commandCenter.addRoller();
    assertThat(roller, notNullValue());
  }

  @Test
  public void testAddRollerNotSame() throws Exception {
    Roller roller = commandCenter.addRoller();
    assertThat(commandCenter.addRoller(), CoreMatchers.not(roller));
  }

  @Test
  /**
   * White box testing. Because I can.
   */
  public void testMoveRoller() throws Exception {
    Roller roller = Mockito.mock(Roller.class);

    commandCenter.moveRoller(roller, "flr");

    verify(roller, times(1)).forward();
    verify(roller, times(1)).turnLeft();
    verify(roller, times(1)).turnRight();
  }
}
