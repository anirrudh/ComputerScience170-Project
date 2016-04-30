import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class Sarz {

  Scanner keyboard = new Scanner(System.in);
  Random r = new Random();
  UserStats user = new UserStats();
  //UserNavigation n = new UserNavigation();
  Sarz[][] map = new Sarz[5][5];

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
    writeOutput();
  }

  public void play(){
    mapGeneration();
    encounter(map[4][4]);
    //n.userMoveIntro();
    //n.moveForward();
  }
    //enemyEncounter(map[0][0]);


  public void writeOutput() {
    setPlayerName();
    System.out.println("You have the choice between taking two items to help you on your journey: \n");
    System.out.print("Either some MEDICINE or a MACHETE. \n");
    System.out.println("");
    getWeapon();
    System.out.println("\nLet's begin this adventure!");

  }

  public String setPlayerName() {
    Scanner playerNameKeyboard = new Scanner(System.in);
    user = new UserStats(playerNameKeyboard.next());
    System.out.println("You are a brave one, " + user.getUserName() + ", welcome to the Sarz mission.");
    return user.getUserName();
  }

  public void mapGeneration() {
    int count = 0;
    int row;
    int column;

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
      System.out.println("Introduction error.");
      System.exit(0);
    }
    while(inputWeaponFile.hasNextLine()){
      String line = inputWeaponFile.nextLine();
      System.out.println(line);

    }

    userChoice = userInput.nextInt();

    switch (userChoice) {
      case 1: System.out.println("\nMEDICINE will help you increase your Health Points by 300.");
      System.out.println("");
      getWeapon();
      break;
      case 2: System.out.println("\nYou chose the MEDICINE!");
      user.setMachete(false);
      user.setMedicine();
      break;
      case 3: System.out.println("\nThe MACHETE will cut all damage you take from enemies in half.");
      getWeapon();
      break;
      case 4: System.out.println("\nYou chose the MACHETE!");
      user.setMachete(true);
      break;
      default: System.out.println("\nInvalid input. Try again.");
      getWeapon();
      break;
    }
    return userChoice;
  }

  public void encounter(Sarz array){

    if (array instanceof Item){
    System.out.println("You have encountered a " + ((Item)array).getItemName());
    }
    else if (array instanceof Enemies){
    System.out.println("You have encountered a " + ((Enemies)array).getEnemyName() + "\n\nTime to battle!" );
    battle(array);
    }
  }



  public void battle(Sarz array) {
    if (user.getMachete() == true){
      user.setHP((user.getHP())-(((Enemies)array).getEnemyHitPoints() * .5));
      System.out.println("The " + ((Enemies)array).getEnemyName() + " has inflicted " + (((Enemies)array).getEnemyHitPoints()*.5) + " damage!");

    }
    else {
    user.setHP((user.getHP())-((Enemies)array).getEnemyHitPoints());
    System.out.println("The " + ((Enemies)array).getEnemyName() + " has inflicted " + ((Enemies)array).getEnemyHitPoints() + " damage!");
    }
    System.out.println("\nYour health is: " + user.getHP());



  }
}
