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
    center = new CommandCenter(new FlatSurface(4, 4));
    roller = center.addRoller();
  }

  @Test(expected = OutOfSurfaceException.class)
  public void testFirst() throws Exception {
    roller.forward();
    roller.turnLeft();
    roller.forward();
  }

  @Test
  public void testSecond() throws Exception {
    roller.forward();
    roller.turnLeft();
    roller.turnLeft();
    roller.forward();
    assertThat(roller.getPosition(), is(new Position(1, 1)));
  }

  @Test(expected = OutOfSurfaceException.class)
  public void testThird() throws Exception {
    roller.forward();
    roller.forward();
    roller.forward();
    roller.turnRight();
    roller.forward();
    roller.turnLeft();
    roller.forward();
  }
}
