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

public interface Roller {
  /**
   * Move roller one unit in forward direction.
   *
   * @throws OutOfSurfaceException if move lead to falling from the surface. In this case previous position and direction is maintained
   */
  void forward() throws OutOfSurfaceException;

  /**
   * Turn 90% CCW
   */
  void turnLeft();

  /**
   * Turn 90% CW
   */
  void turnRight();

  /**
   * Returns current position of the roller
   *
   * @return position, not <code>null</code>
   */
  Position getPosition();

  /**
   * Gets facing direction.
   *
   * @return direction
   */
  Direction getDirection();


  /**
   * Attaching to surface. A roller can be attached to only one surface.
   *
   * @param surface attach to
   */
  void attachToSurface(Surface surface);

}
