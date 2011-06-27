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
