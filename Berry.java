///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    PA8Tester.java
// File:               Berry.java
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
 * Creates a new item type Berry
 *
 * Bugs: None known
 *
 * @author Charlie Swaim
 */
public class Berry extends Item{

  private int patienceIncrement;
  private int speedDecrement;

  /**
   * Default constructor that initializes the Berry name to "item",
   * patienceIncrement to 0, and speedDecrement to 0
   *
   */
  public Berry() {
    super();
    this.patienceIncrement = 0;
    this.speedDecrement = 0;
  }

  /**
 * Constructor that sets the Berry name, patienceIncrement, and speedDecrement
 * to the parameters
 *
 * @param berryName represents the name of the Berry object being created
 * @param patienceInc represents the patienceIncrement of the Berry object being
 * created
 * @param SpeedDec represents the speedDecrement of the Berry object being
 * created
 */
  public Berry(String berryName, int patienceInc, int speedDec) {
    super(berryName);
    this.patienceIncrement = patienceInc;
    this.speedDecrement = speedDec;
  }

  /**
 * Returns patienceIncrement of the Berry object
 *
 * @return patienceIncrement of the Berry object
 */
  public int getPatienceIncrement() {
    return this.patienceIncrement;
  }

  /**
 * Returns speedDecrement of the Berry object
 *
 * @return speedDecrement of the Berry object
 */
  public int getSpeedDecrement() {
    return this.speedDecrement;
  }

  /**
 * Returns name, patienceIncrement, and speedDecrement of the pokeball object as
 * a string
 *
 * @return name, patienceIncrement, and speedDecrement of the pokeball object as
 * a string
 */
  @Override
  public String toString() {
    String outputString;

    outputString =(super.toString() + "patienceIncrement: " +
    this.patienceIncrement + "\n" + "speedDecrement: " + this.speedDecrement +
    "\n");
    return outputString;
  }























}
