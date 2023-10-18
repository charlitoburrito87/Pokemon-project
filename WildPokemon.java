///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    PA8Tester.java
// File:               WildPokemon.java
// Quarter:            CSE 8B Winter 2021
//
// Author:             Charlie Swaim - cswaim@ucsd.edu
// Instructor's Name:  Christine Alvarado
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
// Pair Partner:       None
// Email:              N/A
// Instructor's Name:  N/A
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   fully acknowledge and credit all sources of help,
//                   other than Instructors and TAs.
//
// Persons:          None
//
// Online sources:   None
//////////////////////////// 80 columns wide //////////////////////////////////

/**
 * Creates a new Pokemon type WildPokemon
 *
 * Bugs: None known
 *
 * @author Charlie Swaim
 */

import java.util.Random;

public class WildPokemon extends Pokemon{

  private int patience;
  private int speed;
  private int timesEscapedFromBall;

  Random randGen = new Random();

  /**
   * Default constructor that initializes the WildPokemon name to "Pokemon",
   * sound to "unknown", type to "unknown", patience to 100, speed to 0, and
   * timesEscapedFromBall to 0
   *
   */
  public WildPokemon() {
    super();
    this.patience = 100;
    this.speed = 0;
    this.timesEscapedFromBall = 0;
  }

  /**
 * Constructor that sets the WildPokemon name, sound, type, patience, and speed
 * to the parameters, and initializes the timesEscapedFromBall to 0
 *
 * @param pokemonName represents the name of the WildPokemon object being
 * created
 * @param pokemonSound represents the sound of the WildPokemon object being
 * created
 * @param pokemonType represents the type of the WildPokemon object being
 * created
 * @param patienceIn represents the patience of the WildPokemon object
 * being created
 * @param speedIn represents the speed of the WildPokemon object
 * being created
 */
  public WildPokemon (String pokemonName, String pokemonSound,
  String pokemonType, int patienceIn, int speedIn) {
    super(pokemonName, pokemonSound, pokemonType);
    this.patience = patienceIn;
    this.speed = speedIn;
    this.timesEscapedFromBall = 0;
  }

  /**
 * Returns patience of the WildPokemon object
 *
 * @return patience of the WildPokemon object
 */
  public int getPatience() {
    return this.patience;
  }

  /**
 * Returns speed of the WildPokemon object
 *
 * @return speed of the WildPokemon object
 */
  public int getSpeed() {
    return this.speed;
  }

  /**
 * Returns timesEscapedFromBall of the WildPokemon object
 *
 * @return timesEscapedFromBall of the WildPokemon object
 */
  public int getTimesEscapedFromBall() {
    return this.timesEscapedFromBall;
  }

  /**
 * Sets patience of the WildPokemon object to the parameter
 *
 * @param newPatience new patience of the WildPokemon object
 */
  public void setPatience(int newPatience) {
    this.patience = newPatience;
  }

  /**
 * Sets speed of the WildPokemon object to the parameter
 *
 * @param newSpeed new speed of the WildPokemon object
 */
  public void setSpeed(int newSpeed) {
    this.speed = newSpeed;
  }

  /**
 * Adds 1 to the number of timesEscapedFromBall
 */
  public void incrementTimesEscapedFromBall() {
    this.timesEscapedFromBall += 1;
  }

  /**
 * Prints message when a WildPokemon appears
 */
  public void appear() {
    System.out.println("You encounter a wild " + this.getName() + "!");
    this.speak();
  }

  /**
 * Prints message when a WildPokemon disappears
 *
 * @return boolean telling if the pokemon has disappeared
 */
  public boolean disappear() {
    boolean output = false;

    if (this.patience <= 0 || this.timesEscapedFromBall > 3) {
      output = true;
      System.out.println(this.getName() + " disappears...");
    }
    return output;
  }


  public boolean isCaught(Berry berry, Pokeball pokeball) {
    boolean isCaught;

    this.patience = this.patience + berry.getPatienceIncrement();
    this.speed = this.speed - berry.getSpeedDecrement();
    int threshold = this.speed - this.patience;
    threshold = threshold + (randGen.nextInt(61) - 30);

    if (pokeball.getPerformance() > threshold) {
      isCaught = true;
    }
    else {
      this.incrementTimesEscapedFromBall();
      isCaught = false;
    }


    return isCaught;
  }

  /**
 * Returns name, type, patience, speed, and timesEscapedFromBall of the
 * WildPokemon object as a string
 *
 * @return name, type, patience, speed, and timesEscapedFromBall of the
 * WildPokemon object as a string
 */
  @Override
  public String toString() {
    String outputString;

    outputString = (this.getName() + ", WildPokemon\ntype: " + this.getType() +
    "\npatience: " + this.patience + "\nspeed: " + this.speed +
    "\ntimesEscapedFromBall: " + this.timesEscapedFromBall + "\n");

    return outputString;
  }
























}
