package ru.sid0renk0.marsroller;

public class BasicRoller implements Roller {

  private Position position;
  private Direction direction;

  public BasicRoller(Position position, Direction direction) {
    this.position = position;
    this.direction = direction;
  }

  @Override
  public void forward() {
  }

  @Override
  public void turnLeft() {
  }

  @Override
  public void turnRight() {
  }

  @Override
  public Position getPosition() {
    return null;
  }

  @Override
  public Direction getDirection() {
    return null;
  }
}
