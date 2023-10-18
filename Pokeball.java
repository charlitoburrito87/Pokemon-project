///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    PA8Tester.java
// File:               Pokeball.java
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
 * Creates a new item type Pokeball
 *
 * Bugs: None known
 *
 * @author Charlie Swaim
 */
public class Pokeball extends Item {

  private int performance;

  /**
   * Default constructor that initializes the Pokeball name to "item" and
   * performance to 0.
   *
   */
  public Pokeball() {
    super();
    this.performance = 0;
  }

  /**
 * Constructor that sets the Pokeball name and performance to the parameters
 *
 * @param pokeballName represents the name of the Pokeball object being created
 * @param performanceIn represents the performance of the Pokeball object being
 * created
 */
  public Pokeball(String pokeballName, int performanceIn) {
    super(pokeballName);
    this.performance = performanceIn;
  }

  /**
 * Returns performance of the Pokeball object
 *
 * @return performance of the Pokeball object
 */
  public int getPerformance() {
    return this.performance;
  }

  /**
 * Returns name and performance of the Pokeball object as a string
 *
 * @return name and performance of the Pokeball object as a string
 */
  @Override
  public String toString() {
    String outputString;

    outputString = (super.toString() + "performance: " +
    String.valueOf(performance) + "\n");
    return outputString;
  }























}
