/*
 * Copyright (c) 2010-2011, Dmitry Sidorenko. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
