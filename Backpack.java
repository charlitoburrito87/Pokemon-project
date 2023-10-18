///////////////////////////////////////////////////////////////////////////////
// Main Class File:    PA8Tester.java
// File:               Backpack.java
// Quarter:            CSE 8B Winter 2021
//
// Author:             Rachel Chung, Charlie Swaim
//
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.ArrayList;

/**
 * This is Backpack class that you can add items which are berries and
 * pokeballs. You can display your backpack with display() method
 *
 * Bugs: None known
 *
 * @authors Rachel Chung, Charlie Swaim
 */

public class Backpack {

    // ArrayList for items (berries, pokeballs)
    private ArrayList<Item> myItems;

    /**
     * Creates a resizable-array ArrayLists of Items
     *
     */
    public Backpack() {
      this.myItems = new ArrayList<Item>();
    }

    /**
     * Adds the item to myItems
     *
     */
    public void add(Item item) {
      this.myItems.add(item);
    }

    /**
     * Displays the elements in the myItems ArrayList
     *
     */
    public void display() {
      System.out.println("Items in the backpack:");
      System.out.println("");

      if (myItems.size() == 0) {
        System.out.println("None");
        System.out.println("");
      }
      else {
        for (Item item: myItems) {
          System.out.println(item.toString());
        }
      }
    }


    public Pokeball useBall(String ballName) {
      for (int i = 0; i < myItems.size(); i++) {
        if (myItems.get(i).getName().equals(ballName)){
            Pokeball usedPokeball = (Pokeball)myItems.get(i);
            myItems.remove(i);
            return usedPokeball;
        }
      }
      System.out.print("Pokeball " + ballName);
      System.out.println(" does not exist in the backpack!");
      return null;
    }


    public Berry useBerry(String berryName, int index) {
      if (index >= myItems.size()) {
        return null;
      }
      if (myItems.get(index).getName().equals(berryName)) {
        Berry usedBerry = (Berry)myItems.get(index);
        myItems.remove(index);
        return usedBerry;
      }
      else {
        return useBerry(berryName, index + 1);
      }
    }
}
