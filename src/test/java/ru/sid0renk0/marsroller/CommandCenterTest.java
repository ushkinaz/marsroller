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
