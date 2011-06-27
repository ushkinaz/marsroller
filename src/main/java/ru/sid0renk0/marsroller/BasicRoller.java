package ru.sid0renk0.marsroller;

public class BasicRoller implements Roller {

  private Position position;
  private Direction direction;
  private Surface surface;

  public BasicRoller(Position position, Direction direction) {
    this.position = position;
    this.direction = direction;
  }

  @Override
  public void forward() throws OutOfSurfaceException {
    position = surface.move(position, direction, 1);
  }

  @Override
  public void turnLeft() {
    direction = direction.nextCounterClockWise();
  }

  @Override
  public void turnRight() {
    direction = direction.nextClockWise();
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
