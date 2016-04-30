import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class Sarz {


  Scanner keyboard = new Scanner(System.in);
  Random r = new Random();
  String playerName;

  /** Reads in introduction text and asks for username.**/
public void premise(){

    Scanner inputStream = null;

    try{
      inputStream = new Scanner(new File("SarzIntro.txt"));
    }
    catch(FileNotFoundException e){
      System.out.println("Error in introduction.");
      System.exit(0);
    }
    while(inputStream.hasNextLine()){
      String line = inputStream.nextLine();
      System.out.println(line);
    }
    inputStream.close();
    Sarz start = new Sarz();
    start.writeOutput();
  }
  /*This is where we will set the playerName*/
public String setPlayerName()
  {

    Scanner playerNameKeyboard = new Scanner(System.in);
    playerName = playerNameKeyboard.next();
    System.out.println("You are a brave one, " + playerName + ", welcome to the Sarz mission.");
    return playerName; }
  /* This is where the map is generated & items are hidden*/

public void mapGeneration()

{
    int count = 0;
    int row;
    int column;

    Sarz[][] map = new Sarz[5][5];

    Enemies e = new Enemies();
    e.generateEnemies();

    //This generates enemies
    while (count < 5){
      row = r.nextInt(5);
      column = r.nextInt(5);
      if (map[row][column] == null){
        map[row][column] = e.enemies[r.nextInt(8)];
        System.out.println(((Enemies)map[row][column]).getEnemyName() + " at " + row + "," + column);
        count++;
      }
    }

    Item itemGenerator = new Item();
    itemGenerator.generateItems();

    //This generates plants
    count = 0;
    while (count < 6){
      row = r.nextInt(5);
      column = r.nextInt(5);
      if (map[row][column] == null){
        map[row][column] = itemGenerator.plants[r.nextInt(5)];
        System.out.println(((Item)map[row][column]).getItemName() + " at " + row + "," + column);
        count++;
      }
    }

    //This generates water
    count = 0;
    while(count < 4){
      row = r.nextInt(5);
      column = r.nextInt(5);
      if (map[row][column] == null){
        map[row][column] = itemGenerator.water[0];
        System.out.println(((Item)map[row][column]).getItemName() + " at " + row + "," + column);
        count ++;
      }
    }

    //This generates useless items
    count = 0;
    while(count < 10){
      row = r.nextInt(5);
      column = r.nextInt(5);
      if (map[row][column] == null){
        map[row][column] = itemGenerator.uselessItems[r.nextInt(10)];
        System.out.println(((Item)map[row][column]).getItemName() + " at " + row + "," + column);
        count ++;
      }
    }
  }


  /*This is simply the write output function so the code is streamlined*/
  /*This is where we ask the user about what their "ability" will be*/
  public int getWeapon()
  {
    int userChoice = 0;

    Scanner userInput = new Scanner(System.in);
    Scanner inputWeaponFile = null;
    try{
      inputWeaponFile = new Scanner(new File("WeaponsChoice.txt"));
    }
    catch(FileNotFoundException e){
      System.out.println("Bye, you fuckhead.");
      System.exit(0);
    }
    while(inputWeaponFile.hasNextLine()){
      String line = inputWeaponFile.nextLine();
      System.out.println(line);

    }
    userChoice = userInput.nextInt();
    switch (userChoice) {
    case 1: System.out.println("Medicine will help you increase your Health Points by 300.");
            System.out.println("");
            getWeapon();
            break;
    case 2: System.out.println("You chose the Medicine!");
            UserStats medInc = new UserStats();
            medInc.MedicineChosen();

            break;
    case 3: System.out.println("The Machete will cut all damage you take from enemies in half.");
            getWeapon();
            break;
    case 4: System.out.println("You chose the Machete!");
            break;
    default: System.out.println("Invalid input. Try again.");
             getWeapon();
             break;
  }
  return userChoice;
  }
  /* This is simply to write the Output here*/
public void writeOutput()
{
  setPlayerName();
  System.out.println("You have the choice between taking two items to help you on your journey: ");
  System.out.print("Either some Medicine or A Machete.");
  System.out.println("");
  getWeapon();
  System.out.println("Let's begin this adventure!");

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
