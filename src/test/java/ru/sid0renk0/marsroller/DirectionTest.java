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
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static ru.sid0renk0.marsroller.Direction.*;

public class DirectionTest {

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
