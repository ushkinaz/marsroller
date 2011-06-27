package ru.sid0renk0.marsroller;


/**
 * Surface is a square flat plane with given dimensions. Coordinates start with 1. (1,1) is lower left corner.
 */
public class FlatSurface implements Surface {
  private int width;
  private int height;

  public FlatSurface(int width, int height) {
    //Why asserts? Because imo in most cases size of surface will be known at dev time.
    assert width > 0;
    assert height > 0;

    this.width = width;
    this.height = height;
  }

  /**
   * Validates position. Might be overridden in descendants
   *
   * @param position position to check
   * @throws OutOfSurfaceException if position is out of surface space
   */
  protected void validatePosition(Position position) throws OutOfSurfaceException {
    if (position.getX() > width || position.getY() > height || position.getX() <= 0 || position.getY() <= 0) {
      throw new OutOfSurfaceException("Fallen into Great Void");
    }
  }

  @Override
  public Position move(Position initialPosition, Direction direction, int units) throws OutOfSurfaceException {
    Position wouldBePosition = null;
    // PositionVisitor#visitNorth()? Not worth it atm.
    switch (direction) {
      case NORTH:
        wouldBePosition = new Position(initialPosition.getX(), initialPosition.getY() + units);
        break;
      case EAST:
        wouldBePosition = new Position(initialPosition.getX() + units, initialPosition.getY());
        break;
      case SOUTH:
        wouldBePosition = new Position(initialPosition.getX(), initialPosition.getY() - units);
        break;
      case WEST:
        wouldBePosition = new Position(initialPosition.getX() - units, initialPosition.getY());
        break;
    }
    validatePosition(wouldBePosition);
    return wouldBePosition;
  }
}
