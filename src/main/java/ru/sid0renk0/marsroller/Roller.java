package ru.sid0renk0.marsroller;

public interface Roller {
  /**
   * Move roller one unit in forward direction.
   */
  void forward();

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

}
