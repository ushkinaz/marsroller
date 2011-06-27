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
