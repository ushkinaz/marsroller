package ru.sid0renk0.marsroller;

import java.util.HashSet;
import java.util.Set;

public class CommandCenter {
  private Surface surface;

  private Set<Roller> rollers;

  public CommandCenter(Surface surface) {
    this.surface = surface;
    rollers = new HashSet<Roller>(2);
  }

  /**
   * Adds a roller to position 1,1, facing north
   *
   * @return added roller
   */
  public Roller addRoller() {
    //Adding factory would be better, but then it would break " the test is only 25-lines of code" promise.
    DieselRoller roller = new DieselRoller();
    rollers.add(roller);
    return roller;
  }

  public void moveRoller(Roller roller, String sequence){

  }

}
