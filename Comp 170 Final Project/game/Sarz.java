import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class Sarz {


  Scanner keyboard = new Scanner(System.in);
  Random r = new Random();
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


    userStats user = new userStats(keyboard.nextLine());

  }

  /* This is where the map is generated & items are hidden*/
  public void mapGeneration(){
    int count = 0;
    int row;
    int column;
    //make an enemies object so we can generate the enemy types (we will do similarly for plants and whatever else we need)
    Enemies e = new Enemies();
    e.generateEnemies();

    Sarz[][] map = new Sarz[5][5];
    //this while loop generates four enemies as it is. the commented out print line tests where they are, but I can't get it to print the enemy names as strings
    while (count < 4){
      row = r.nextInt(5);
      column = r.nextInt(5);
      if (map[row][column] == null){
        map[row][column] = e.enemies[r.nextInt(8)];
        //System.out.println(map[row][column] + " at " + row + "," + column);
        count++;
      }
    }

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
