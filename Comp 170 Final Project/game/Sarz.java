import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class Sarz {

  Scanner keyboard = new Scanner(System.in);
  String userName;

  /* This is where we will ask for the username and explain the game to the user.
  We could totally have the explanation in a text file and have the program
  read it out instead of having it all here.
  Last Edited, Riley 4/13/16 */

  public void premise(){
    System.out.println("Welcome to Sars++");
    System.out.println("The year is 4052. Planet Earth has become increasingly barren due to humans' exhaustion of her resources. You are one of a select few chosen to journey to new planets in search of resources that could sustain life. Sarz++ has shown promise, and having just landed, your mission will begin soon.");
    System.out.println("What is your name?");
    userName = keyboard.nextLine();
    System.out.println("Welcome to Sarz++, " + userName);
    //Set game to play
  }
  /* This is where the game is generated. Variables, including counters, will be
  initialized here. Item slots made, etc. */

  public void sarzGeneration(){

    //Counters & Variables (there will probably be more)
    int hp;
    int defense;
    int day;
    int hour;

    hp = 100;
    defense = 100;
    day = 1;
    hour = 1;


    Items[] itemSlots = new Items[2];

  }
  /* This is where the map is generated & items are hidden*/
  public void mapGeneration(){
    int row;
    int column;

    //the map is of type item because everything in each location should be some type of item or enemy
    Items[][] map = new Items[5][5];

    Items itemGenerator = new Items();

    for (int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
        map[i][j] = new Items();
      }
    }

    /*This is to generate plants. There may be a better way to do this than a for loop?
    we also need to think about not having some other item generate in the same location when we generate other things */
    for (int i = 0; i < 6; i ++){
      Random r = new Random();
      row = r.nextInt(5);
      column = r.nextInt(5);
      if (map[row][column].getName().equals("")) {
                //need setters and getters for line below to work
                //map[row][column].setName(plants[i]);
              }





    }
  }

  /*SETTERS AND GETTERS FOR COUNTERS, DAY NUMBER, ETC */


  /*This is where the decisions/actions take place. The user will be presented with
  decisions he/she can make, and counters will be displayed (day, time, HP, hunger,
  etc.)*/
  public void action(){

  }

  /*This method is for when the player encounters an enemy, and will be invoked
   when the user enters the array location of an enemy Loosely, a battle method. */
  public void enemyEncounter(){

  }

  /*This method is invoked when the user finds an item.*/
  public void foundItem(){

  }
}
