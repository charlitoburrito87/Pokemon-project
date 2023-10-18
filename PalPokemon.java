///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    PA8Tester.java
// File:               PalPokemon.java
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
 * Creates a new Pokemon type PalPokemon
 *
 * Bugs: None known
 *
 * @author Charlie Swaim
 */
public class PalPokemon extends Pokemon{

  private String pokeballName;

  /**
   * Default constructor that initializes the PalPokemon name to "Pokemon",
   * sound to "unknown", type to "unknown", and pokeballName to "undefined"
   *
   */
  public PalPokemon() {
    super();
    this.pokeballName = "undefined";
  }

  /**
 * Constructor that sets the PalPokemon name, sound, type, and pokeballName to
 * the parameters
 *
 * @param pokemonName represents the name of the PalPokemon object being created
 * @param pokemonSound represents the sound of the PalPokemon object being
 * created
 * @param pokemonType represents the type of the PalPokemon object being created
 * @param pokeballName represents the pokeballName of the PalPokemon object
 * being created
 */
  public PalPokemon (String pokemonName, String pokemonSound,
  String pokemonType, String pokeballName) {
    super(pokemonName, pokemonSound, pokemonType);
    this.pokeballName = pokeballName;
  }

  /**
 * Returns pokeballName of the PalPokemon object
 *
 * @return pokeballName of the PalPokemon object
 */
  public String getPokeballName() {
    return this.pokeballName;
  }

  /**
 * Prints the PalPokemon name, pokeballName, and type, and calls the speak
 * method from the parent class Pokemon
 *
 */
  public void comesOutFromBall() {
    String outputString;

    outputString = (this.getName() + " in " + this.pokeballName + ", " +
    this.getType() + " type pokemon.");
    System.out.println(outputString);
    this.speak();
  }

  /**
 * Returns name, pokeballName, and type of the PalPokemon object as
 * a string
 *
 * @return name, pokeballName, and type of the PalPokemon object as
 * a string
 */
  @Override
  public String toString() {
    String outputString;

    outputString = (this.getName() + ", PalPokemon\npokeballName: " +
    this.pokeballName + "\n" + "type: " + this.getType() + "\n");
    return outputString;
  }





























}
