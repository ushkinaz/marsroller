package ru.sid0renk0.marsroller;

public interface Surface {

  /**
   * Move virtual position from initialPosition in given direction, by given number of points
   *
   * @param initialPosition initial position
   * @param direction       facing direction
   * @param units           units
   * @return new position
   * @throws OutOfSurfaceException if new position is not valid
   */
  Position move(Position initialPosition, Direction direction, int units) throws OutOfSurfaceException;
}
