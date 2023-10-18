///////////////////////////////////////////////////////////////////////////////
// Main Class File:    PA8Tester.java
// File:               Pokedex.java
// Quarter:            CSE 8B Winter 2021
//
// Author:             Rachel Chung, Charlie Swaim
//
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.ArrayList;

/**
 * This is Pokedex class that you can add pokemon which can be wild or pal
 * pokemon. You can display your pokedex with display() method
 *
 * Bugs: None known
 *
 * @authors Rachel Chung, Charlie Swaim
 */

public class Pokedex {

    // ArrayList for pokemon (WildPokemons, PalPokemons)
    ArrayList<Pokemon> myPokedex;

    /**
     * Creates a resizable-array ArrayLists of Pokemon
     *
     */
    public Pokedex() {
      this.myPokedex = new ArrayList<Pokemon>();
    }

    /**
     * Adds the pokemon to myPokedex
     *
     */
    public void add(Pokemon pokemon) {
      this.myPokedex.add(pokemon);
    }

    /**
     * Displays the elements in the myPokedex ArrayList
     *
     */
    public void display() {
      System.out.println("Pokemon in the pokedex:");
      System.out.println("");

      if (myPokedex.size() == 0) {
        System.out.println("None");
        System.out.println("");
      }
      else {
        for (Pokemon pokemon: myPokedex) {
          System.out.println(pokemon.toString());
        }
      }
    }
}
