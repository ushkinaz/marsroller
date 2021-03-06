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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class CommandCenter {
  private static final Logger LOGGER = LoggerFactory.getLogger(CommandCenter.class);

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
    //Adding factory would be better, but then it would break "the test is only 25-lines of code" promise.
    BasicRoller roller = new BasicRoller(new Position(1, 1), Direction.NORTH);
    roller.attachToSurface(surface);
    rollers.add(roller);
    return roller;
  }

  /**
   * Controls roller by char based commands.<br/>
   * f - forward
   * l - turn left
   * r - turn right
   *
   * @param roller   roller to control
   * @param sequence command sequence
   */
  public void moveRoller(Roller roller, CharSequence sequence) throws IncorrectCommandException, OutOfSurfaceException {
    for (int i = 0; i < sequence.length(); i++) {
      handleOneCommand(roller, sequence.charAt(i));
    }

  }

  private void handleOneCommand(Roller roller, char command) throws IncorrectCommandException, OutOfSurfaceException {
    switch (command) {
      case 'f':
        roller.forward();
        break;
      case 'l':
        roller.turnLeft();
        break;
      case 'r':
        roller.turnRight();
        break;
      default:
        throw new IncorrectCommandException(command);
    }
  }


  public static void main(String[] args) {
    CommandCenter commandCenter = new CommandCenter(new FlatSurface(4, 4));
    commandCenter.startControlling();
  }


  /**
   * Control from keyboard
   */
  public void startControlling() {
    Roller roller = addRoller();
    String line = "";

    InputStreamReader converter = new InputStreamReader(System.in);
    BufferedReader in = new BufferedReader(converter);


    try {
      while (!(line.toLowerCase().equals("quit"))) {
        System.out.println("Enter command line (type 'quit' to exit): ");
        line = in.readLine().toLowerCase();

        if (!(line.equals("quit"))) {
          moveRoller(roller, line);
          System.out.println("Roller state:" + roller);
        }
      }
    } catch (IOException e) {
      LOGGER.error("IOException", e);
    } catch (IncorrectCommandException e) {
      LOGGER.warn("Incorrect user detected", e);
    } catch (OutOfSurfaceException e) {
      LOGGER.warn("Never test boundaries of your world", e);
    }
  }
}
