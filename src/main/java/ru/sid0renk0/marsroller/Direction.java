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

public enum Direction {
  NORTH,
  EAST,
  SOUTH,
  WEST;

  /**
   * Returns next direction if turning 90% clockwise
   *
   * @return new direction
   */
  public Direction nextClockWise() {
    //No fancy stuff
    switch (this) {
      case EAST:
        return SOUTH;
      case SOUTH:
        return WEST;
      case WEST:
        return NORTH;
      case NORTH:
        return EAST;
    }
    // Should never happen
    return null;
  }

  /**
   * Returns next direction if turning 90% counterclockwise
   *
   * @return new direction
   */
  public Direction nextCounterClockWise() {
    //No fancy stuff
    switch (this) {
      case EAST:
        return NORTH;
      case SOUTH:
        return EAST;
      case WEST:
        return SOUTH;
      case NORTH:
        return WEST;
    }
    // Should never happen
    return null;
  }


}
