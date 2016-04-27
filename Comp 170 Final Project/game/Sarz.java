import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class Sarz {

  Scanner keyboard = new Scanner(System.in);

  UserStats user = new UserStats();

  /* This is where we will ask for the username and explain the game to the user.
  We could totally have the explanation in a text file and have the program
  read it out instead of having it all here.
  Last Edited, Riley 4/13/16 */

  public void premise(){
    user.setDecision("PLAY");
    System.out.println(user.getDecision());
  }


  /* This is where the map is generated & items are hidden*/
  public void mapGeneration(){
    int row;
    int column;

    //the map is of type item because everything in each location should be some type of item or enemy
    Sarz[][] map = new Sarz[5][5];


      }
    }







  /*This is where the decisions/actions take place. The user will be presented with
  decisions he/she can make, and counters will be displayed (day, time, HP, hunger,
  etc.)
  public void action(){

  }

  This method is for when the player encounters an enemy, and will be invoked
   when the user enters the array location of an enemy Loosely, a battle method.
  public void enemyEncounter(){

  }

  This method is invoked when the user finds an item.
  public void foundItem(){

  }*/
