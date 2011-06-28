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
