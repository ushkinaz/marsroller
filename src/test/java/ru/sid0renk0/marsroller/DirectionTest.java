package ru.sid0renk0.marsroller;


import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static ru.sid0renk0.marsroller.Direction.*;

public class DirectionTest{

  @Test
  public void testNextClockWise() throws Exception {
    assertThat(NORTH.nextClockWise(), CoreMatchers.is(EAST));
    assertThat(EAST.nextClockWise(), CoreMatchers.is(SOUTH));
    assertThat(SOUTH.nextClockWise(), CoreMatchers.is(WEST));
    assertThat(WEST.nextClockWise(), CoreMatchers.is(NORTH));
  }

  @Test
  public void testNextCounterClockWise() throws Exception {
    assertThat(NORTH.nextCounterClockWise(), CoreMatchers.is(WEST));
    assertThat(EAST.nextCounterClockWise(), CoreMatchers.is(NORTH));
    assertThat(SOUTH.nextCounterClockWise(), CoreMatchers.is(EAST));
    assertThat(WEST.nextCounterClockWise(), CoreMatchers.is(SOUTH));
  }
}
