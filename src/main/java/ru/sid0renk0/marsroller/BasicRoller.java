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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicRoller implements Roller {

  private static final Logger LOGGER = LoggerFactory.getLogger(BasicRoller.class);

  private Position position;
  private Direction direction;
  private Surface surface;

  public BasicRoller(Position position, Direction direction) {
    this.position = position;
    this.direction = direction;
  }

  @Override
  public void forward() throws OutOfSurfaceException {
    assert surface != null;

    LOGGER.debug("Moving forward");

    position = surface.move(position, direction, 1);
  }

  @Override
  public void turnLeft() {
    direction = direction.nextCounterClockWise();
    LOGGER.debug("Turning left");
  }

  @Override
  public void turnRight() {
    direction = direction.nextClockWise();
    LOGGER.debug("Turning right");
  }

  @Override
  public Position getPosition() {
    return position;
  }

  @Override
  public Direction getDirection() {
    return direction;
  }

  @Override
  public void attachToSurface(Surface surface) {
    this.surface = surface;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("BasicRoller");
    sb.append("{position=").append(position);
    sb.append(", direction=").append(direction);
    sb.append(", surface=").append(surface);
    sb.append('}');
    return sb.toString();
  }
}
