
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class Sarz {


  Scanner keyboard = new Scanner(System.in);
  Random r = new Random();

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

    System.out.println("Enter your name.");
    userStats user = new userStats(keyboard.nextLine());
    user.setDecision("PLAY");

  }

  /* This is where the map is generated & items are hidden*/
  public void mapGeneration(){

    Sarz[][] map = new Sarz[5][5];

    //map[0][0] = new Enemies();


    for (int i = 0; i < 8; i++){
      int row;
      int column;

      row = r.nextInt(5);
      column = r.nextInt(5);

    }


    }

    //generateItems();
    //generateEnemies();
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
