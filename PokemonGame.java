///////////////////////////////////////////////////////////////////////////////
// Main Class File:    PokemonGame.java
// Quarter:            CSE 8B Winter 2021
//
// Authors:             Sachin Deshpande
//
//////////////////////////// 80 columns wide //////////////////////////////////

/**
* An interactive text game where users can capture Pokemon with Berries
* and Pokemon.
*
* @author Sachin Deshpande
*/

import java.util.Scanner;
import java.util.ArrayList;

public class PokemonGame {

    /**
    * Defined variables to use in the game
    * Do not modify any of these.
    *
    */
    private static String[] pokeballNames = {"pokeball", "superball",
    "ultraball"};
    private static int[] pokeballPerformance = {0, 10, 30};

    private static String[] berryNames = {"Razz Berry", "Nanap Berry",
    "Golden Razz Berry"};
    private static final int RAZZ_BERRY_PATIENCE_INC = 10;
    private static final int RAZZ_BERRY_SPEED_DEC = 0;
    private static final int NANAP_BERRY_PATIENCE_INC = 0;
    private static final int NANAP_BERRY_SPEED_DEC = 10;
    private static final int GOLDEN_RAZZ_BERRY_PATIENCE_INC = 30;
    private static final int GOLDEN_RAZZ_BERRY_SPEED_DEC = 30;

    private static String[] pokemonNames = {"Pikachu", "Bulbasaur",
    "Charmander", "Squirtle", "Mew"};
    private static String[] pokemonSounds = {"pikapika", "bulb", "char",
    "squir", "mew"};
    private static String[] pokemonTypes = {"electric", "grass", "fire",
    "water", "psychic"};
    private static int[] pokemonPatienceStats = {60, 50, 50, 50, 15};
    private static int[] pokemonSpeedStats = {25, 5, 20, 10, 50};

    //the amount of patience the WildPokemon decreases on escape from a pokeball
    private static final int PATIENCE_DEC_EACH_ESCAPE = 5;
    private static final String PROMPT_MSG_START =
    "You will encounter different pokemons.\n" +
    "You can throw different poke balls to catch them.\n" +
    "You can use Razz Berry or Golden Razz Berry to increase the catch rate.\n" +
    "You can use Nanap Berry to make the ball hit more easily.\n" +
    "Up to one berry per throw. Use the berry before your ball throw.\n";

    private static final String PROMPT_MSG_BERRY =
        "Which berry do you want to use? " +
        "Type skip if you are confident. " +
        "(Razz Berry, Nanap Berry, Golden Razz Berry, skip)";
    private static final String PROMPT_MSG_BERRY_WRONG_INPUT =
        "Your berry input was not recognized. " +
        "Choose one from the following four options: " +
        "Razz Berry, Nanap Berry, Golden Razz Berry, skip";
    private static final String PROMPT_MSG_POKEBALL =
        "Which pokeball do you want to use? (pokeball, superball, ultraball)";
    private static final String PROMPT_MSG_POKEBALL_WRONG_INPUT =
        "Your pokeball input was not recognized. " +
        "Choose one from the following four options: " +
        "pokeball, superball, ultraball";
    private static final String PROMPT_MSG_CHECK_CAUGHT_POKEMONS =
        "Now let's check who're your pals now!\n";

    /**
    * These are the number of Berries and Pokeballs the user starts with
    * You can change them if you want
    *
    */
    private static final int START_BERRY_COUNT = 2;
    private static final int START_POKEBALL_COUNT = 4;

    private static Backpack myBackpack;
    private static Pokedex myPokedex;

    /**
    * get a Berry from the user, as defined in the assignment pdf
    *
    * @param myScanner: reference to where user input will come from
    * @return : a Berry object that the user will use later on
    *
    * side effects: removes a berry from the backpack, if a user uses one.
    * If so, it should also decrement the appropriate berry count.
    *
    */
    public static Berry getUserBerry(Scanner myScanner){
        System.out.println(PROMPT_MSG_BERRY);
        String berry = myScanner.nextLine();
        boolean inArray = false;
        for (String berryName : berryNames) {
          if (berry.equals(berryName)) {
            inArray = true;
          }
        }
        if (berry.equals("skip")) {
          Berry skip = new Berry("", 0, 0);
          return skip;
        }
        else if (inArray == false) {
          System.out.println(PROMPT_MSG_BERRY_WRONG_INPUT);
          return getUserBerry(myScanner);
        }
        if (myBackpack.useBerry(berry, 0) == null) {
          System.out.println("You don't have any " + berry + " left!");
          return getUserBerry(myScanner);
        }
        else {
          return myBackpack.useBerry(berry, 0);
        }
    }

    /**
    * get a Pokeball from the user, as defined in the assignment pdf
    *
    * @param myScanner: reference to where user input will come from
    * @return : a Pokeball object that the user will use later on
    *
    * side effects: removes a Pokeball from the backpack.
    * Decrement the appropriate pokeball count.
    *
    */
    public static Pokeball getUserPokeball(Scanner myScanner){
      System.out.println(PROMPT_MSG_POKEBALL);
      String pokeball = myScanner.nextLine();
      boolean inArray = false;
      for (String pokeballName : pokeballNames) {
        if (pokeball.equals(pokeballName)) {
          inArray = true;
        }
      }
      if (inArray == false) {
        System.out.println(PROMPT_MSG_POKEBALL_WRONG_INPUT);
        return getUserPokeball(myScanner);
      }
      if (myBackpack.useBall(pokeball) == null) {
        System.out.println("You don't have any " + pokeball + " left!");
        return getUserPokeball(myScanner);
      }
      else {
        return myBackpack.useBall(pokeball);
      }
    }


    public static void startYourJourney() {
        ArrayList <PalPokemon> myPalPokemons = new ArrayList<PalPokemon>();

        myBackpack = new Backpack();
        myPokedex = new Pokedex();


        // the user starts out with some berries and pokeballs of each type
        // TODO: write a for loop to add berries to the backpack object
        // add START_BERRY_COUNT berries of each type

        //  TODO: write a for loop to add pokeballs to the backpack object
        // add START_POKEBALL_COUNT Pokeballs of each type


        System.out.println("A new adventurer wakes up to start their journey!");
        System.out.println("Their backpack contains the following...");
        myBackpack.display();

        // Start the user-machine interaction below
        Scanner myScanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println(PROMPT_MSG_START); // Prompt user
        for (int i = 0; i < pokemonNames.length; i++) {
            WildPokemon wildPokemon = new WildPokemon(pokemonNames[i],
                pokemonSounds[i],
                pokemonTypes[i],
                pokemonPatienceStats[i],
                pokemonSpeedStats[i]);
            wildPokemon.appear();
            myPokedex.add(wildPokemon);

            while (true) {
                Berry userBerry = getUserBerry(myScanner);
                Pokeball userPokeball = getUserPokeball(myScanner);


                if (wildPokemon.isCaught(userBerry, userPokeball) ){
                    System.out.println(wildPokemon.getName() + " is caught!\n");
                    PalPokemon caughtPokemon = new PalPokemon(wildPokemon.getName(),
                        wildPokemon.getSound(),
                        wildPokemon.getType(),
                        userPokeball.getName());
                    myPalPokemons.add(caughtPokemon);
                    myPokedex.add(caughtPokemon);
                    break;
                }
                // The WildPokemon escaped.
                System.out.println(wildPokemon.getName() + " escapes!");
                System.out.println(wildPokemon.getName() +
                "'s times escaped from ball: " +
                wildPokemon.getTimesEscapedFromBall()+"\n");

                // Decrease its patience
                int patienceDec =
                wildPokemon.getTimesEscapedFromBall() * PATIENCE_DEC_EACH_ESCAPE;
                wildPokemon.setPatience(pokemonPatienceStats[i] - patienceDec);
                wildPokemon.setSpeed(pokemonSpeedStats[i]);

                // Check if the pokemon gets away.  If so, stop trying to
                // catch it.
                if (wildPokemon.disappear()){
                    break;
                }
            }
        }


        System.out.println(PROMPT_MSG_CHECK_CAUGHT_POKEMONS);
        for (PalPokemon pal: myPalPokemons ){
            pal.comesOutFromBall();
        }

        System.out.println("Your pokedex now says:");
        myPokedex.display();

        System.out.println("Items left in Backpack:");
        myBackpack.display();
    }

    /**
    * Test your methods useBerry and isCaught here
    * make tests to ensure that your Pokemon classes work correctly
    * 2 additional tests for isCaught and useBerry each
    *
    * @param: nothing
    * @return: true if all your tests pass, false otherwise
    *
    */
    public static boolean unitTests() {
        // TODO

        Backpack testBackpack = new Backpack();
        testBackpack.display();

        Berry razzBerry = new Berry("Razz Berry", 10, 0);
        Berry nanapBerry = new Berry("Nanap Berry", 0, 10);
        Pokeball superball = new Pokeball("superball", 10);
        Pokeball ultraball = new Pokeball("ultraball", 30);

        System.out.println("\nAdding 2 pokeballs -------------------------\n");
        testBackpack.add(superball);
        testBackpack.add(ultraball);


        System.out.println("\nAdding 2 berries ----------------------------\n");
        testBackpack.add(razzBerry);
        testBackpack.add(nanapBerry);
        testBackpack.display();

        System.out.println("\nRemoving some berries -----------------------\n");
        // use some berries in the backpack
        testBackpack.useBerry("Razz Berry", 0);
        testBackpack.useBerry("Nanap Berry", 0);
        testBackpack.display();

        System.out.println("\nRemoving some pokeballs ---------------------\n");
        // use some pokeballs in the backpack
        testBackpack.useBall("superball");
        testBackpack.useBall("ultraball");
        testBackpack.display();
        return true;
    }


    public static void main(String[] args) {
        // Perform unitTests first
        if(unitTests()) {
            System.out.println("All unit tests passed.\n");
        } else {
            System.out.println("Failed test.\n");
            return;
        }

        startYourJourney();
    }
}
