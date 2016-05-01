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
  Sarz[][] map = new Sarz[50][50];


  int plantCount = 0;
  int waterCount = 0;
  private int userRow = 25;
  private int userColumn  = 25;

  public void clearScreen(){
    final String ANSI_CLS = "\u001b[2J";
    final String ANSI_HOME = "\u001b[H";
    System.out.print(ANSI_CLS + ANSI_HOME);
    System.out.flush();
  }

  public int checkRowBounds() {
        try {
            //System.out.println("Checking here" + userRow);
            if(userRow == 50)
            {
                //System.out.println(userRow);
                System.out.println("Uh-oh, this looks like the end of the road. Try a differnt direction.");
                userMoveIntro();
                moveForward();
                userRow = userRow - 1;
                System.out.println(userRow);
                return userRow;
            }
            if(userRow <= 0)
            {
                //System.out.println(userRow);
                System.out.println("Uh-oh, this looks like the end of the road. Try a differnt direction.");
                userMoveIntro();
                moveForward();
                userRow = userRow + 1;
                System.out.println(userRow);
                return userRow;
            }
            return userRow;
        }
        catch(ArrayIndexOutOfBoundsException err)
        {
            System.out.println("You can't keep going forward, it's the end of the road. Please choose a different direction.");
            userRow = 4;
            userMoveIntro();
            moveForward();
            return userRow;
        }
    }
  public int checkColumnBounds() {
        try
        {
            if(userColumn == 50)
            {
                System.out.println("Hey! You've reached the end of the road here. \n Looks like you'll have to find another way around.");
                userMoveIntro();
                moveForward();
                userColumn = userColumn - 1;
                System.out.println(userColumn);
            }
            if(userColumn <= 0)
            {
                System.out.println("Hey! You've reached the end of the road here. \n Looks like you'll have to find another way around.");
                userMoveIntro();
                moveForward();
                userColumn = userColumn + 1;
                System.out.println(userColumn);
            }
        }
        catch(ArrayIndexOutOfBoundsException err)
        {
            System.out.println("You can't keep going. It's the end of the road. Please choose a different direction.");
            userColumn = 4;
            userMoveIntro();
            moveForward();
            return userColumn;
        }
        return userColumn;
    }

  public String setPlayerName() {
    Scanner playerNameKeyboard = new Scanner(System.in);
    user = new UserStats(playerNameKeyboard.next());
    clearScreen();
    System.out.println("\nYou're a brave one, " + user.getUserName() + "!");
    return user.getUserName();
  }
  public void reset(){
    UserStats user = new UserStats();
    Sarz[][] map = new Sarz[50][50];
    plantCount = 0;
    waterCount = 0;
    userRow = 25;
    userColumn  = 25;
  }

  public void mapGeneration() {
    int count = 0;
    int row;
    int column;

    Enemies e = new Enemies();
    e.generateEnemies();
    //This generates enemies
    while (count < 1000){
      row = r.nextInt(50);
      column = r.nextInt(50);
      if (map[row][column] == null){
        map[row][column] = e.enemies[r.nextInt(8)];
        //System.out.println(((Enemies)map[row][column]).getEnemyName() + " at " + row + "," + column);
        count++;
      }
    }

    Item itemGenerator = new Item();
    itemGenerator.generateItems();
    //This generates plants
    count = 0;
    while (count < 500){
      row = r.nextInt(50);
      column = r.nextInt(50);
      if (map[row][column] == null){
        map[row][column] = itemGenerator.plants[r.nextInt(5)];
        //System.out.println(((Item)map[row][column]).getItemName() + " at " + row + "," + column);
        count++;
      }
    }
    //This generates water
    count = 0;
    while(count < 375){
      row = r.nextInt(50);
      column = r.nextInt(50);
      if (map[row][column] == null){
        map[row][column] = itemGenerator.water[0];
        //System.out.println(((Item)map[row][column]).getItemName() + " at " + row + "," + column);
        count ++;
      }
    }
    //This generates useless items
    count = 0;
    while(count < 625){
      row = r.nextInt(50);
      column = r.nextInt(50);
      if (map[row][column] == null){
        map[row][column] = itemGenerator.uselessItems[r.nextInt(10)];
        //System.out.println(((Item)map[row][column]).getItemName() + " at " + row + "," + column);
        count ++;
      }
    }
  }
  public int getWeapon(){
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

    try {
      userChoice = userInput.nextInt();
      switch (userChoice) {
        case 1:
          clearScreen();
          System.out.println("\nMEDICINE will help you increase your Health Points by 300.");
          System.out.println("");
          getWeapon();
          break;
        case 2:
          clearScreen();
          System.out.println("\nYou chose the MEDICINE!\n");
          user.setMachete(false);
          user.setMedicine();
          break;
        case 3:
          clearScreen();
          System.out.println("\nThe MACHETE will cut all damage you take from enemies in half.");
          getWeapon();
          break;
        case 4:
          clearScreen();
          System.out.println("\nYou chose the MACHETE!\n");
          user.setMachete(true);
          break;
        default:
          System.out.println("\nInvalid input. Try again.");
          clearScreen();
          getWeapon();
          break;
        }
      return userChoice;
    }
  catch (InputMismatchException e) {
    System.out.println("You didn't enter a vaild number. Please enter a vaild number.");
    getWeapon();
  }
  return userChoice;
  }

  public void encounter(Sarz array){
    if (array instanceof Item){
      System.out.println("\nYou are in a " + ((Item)array).getItemLocation() +  ".");
      System.out.println("\nThere is a " + ((Item)array).getItemName() + "!\n");
      itemEncounter(array);
    }
    else if (array instanceof Enemies){
      System.out.println("\nYou are in a " + ((Enemies)array).getEnemyLocation() + ".");
      System.out.println("\nYou have encountered a " + ((Enemies)array).getEnemyName() + "; time to battle!" );
      enemyAttack(array);
    }
  }

  public void itemEncounter(Sarz array){
    Game g = new Game();
    Item i = new Item();
    //System.out.println(((Item)array).getUseful());
    if (((Item)array).getUseful() == 2){
      System.out.println("Congratulations! This " + ((Item)array).getItemName() + " is a sign that Sarz++ may be inhabitable.\n");
      plantCount ++;
      checkForWin();
    }
    if (((Item)array).getUseful() == 1){
      System.out.println("Congratulations! This " + ((Item)array).getItemName() + " is a sign that Sarz++ may be inhabitable.\n");
      waterCount ++;
      checkForWin();
    }
    else {
      System.out.println("This won't help you on your mission.\n");
      userMoveIntro();
      moveForward();
    }
  }

  public void enemyAttack(Sarz array) {
    battleWin(array);
    if (user.getMachete() == true){
      user.setHP((user.getHP())-(((Enemies)array).getEnemyHitPoints() * .5));
      System.out.println("The " + ((Enemies)array).getEnemyName() + " has inflicted " + (((Enemies)array).getEnemyHitPoints()*.5) + " damage!");
    }
    else {
      user.setHP((user.getHP())-((Enemies)array).getEnemyHitPoints());
      System.out.println("The " + ((Enemies)array).getEnemyName() + " has inflicted " + ((Enemies)array).getEnemyHitPoints() + " damage!");
      }
      battleWin(array);
      System.out.println("\nYour health is: " + user.getHP());
      System.out.println("\nThe enemy's health is: " + ((Enemies)array).getEnemyHealth());
      battleDialogue(array);
  }

  public void battleWin(Sarz array){
    Game g = new Game();
    if (((Enemies)array).getEnemyHealth() <= 0){
      System.out.println("\nYou killed the " + ((Enemies)array).getEnemyName() + "!\n");
      userMoveIntro();
      moveForward();
    }
    else if ((user.getHP()) <= 0){
      System.out.println("\nThe " + ((Enemies)array).getEnemyName() + " has killed you!\n");
      g.playAgain();
    }
  }

  public void userAttack(Sarz array) {
    ((Enemies)array).setEnemyHealth((((Enemies)array).getEnemyHealth()-user.getHitPoints()));
    clearScreen();
    System.out.println("\nYou inflicted " + user.getHitPoints() + " damage!");
    battleWin(array);
    System.out.println("\nYour health is: " + user.getHP());
    System.out.println("\nThe enemy's health is: " + ((Enemies)array).getEnemyHealth());
    battleDialogue(array);
  }

  public void battleDialogue(Sarz array){
    //int reloop = 0;
    boolean success  = false;
    int count = 0;
    int MAX_TRIES = 2;
    while(!success && count++ < MAX_TRIES)
      {
        int decision = 0;
        //Sarz redoBattle = new Sarz();
        System.out.println("\nPlease enter:");
        System.out.println("\n1 to attack");
        System.out.println("2 to run away\n");

        try {
          decision = keyboard.nextInt();

          switch (decision) {

            case 1:
              userAttack(array);
              enemyAttack(array);
              break;
            case 2:
              if (r.nextInt(10) > 5){
                clearScreen();
                System.out.println("\nYou managed to escape!\n");
                userMoveIntro();
                moveForward();
              }
              else {
                clearScreen();
                System.out.println("\nYou couldn't escape!\n");
                enemyAttack(array);
            }
            break;
          }
        success = true;
      }

      catch (InputMismatchException e) {
        System.out.println("You didn't enter a vaild number...try again.");
        //success = true;
        //Sarz.battleDialogue(Sarz array);
        //reloop++;
      }
    }
  }

  public void userMoveIntro() {
    Scanner inputStreamPrompt = null;
    try
    {
      inputStreamPrompt = new Scanner(new File("Directions.txt"));
    }
    catch(FileNotFoundException e){
      System.out.println("File not found. Did you pirate this game?");
      System.exit(0);
    }
    while(inputStreamPrompt.hasNextLine()){
      String prompt = inputStreamPrompt.nextLine();
      System.out.println(prompt);
    }
    inputStreamPrompt.close();
  }


  public void moveForward() {
    String KM = null;

    Scanner keyMove = new Scanner(System.in);
    KM = keyMove.nextLine().toUpperCase();

    switch(KM)
    {
      case "W":
        userColumn = 1 + userColumn;
        checkRowBounds();
        checkColumnBounds();
        clearScreen();
        encounter(map[userRow][userColumn]);
        break;
      case "A":
        userColumn = userRow - 1;
        checkRowBounds();
        checkColumnBounds();
        clearScreen();
        encounter(map[userRow][userColumn]);
        break;
      case "S":
        userColumn = userColumn -1;
        checkRowBounds();
        checkColumnBounds();
        clearScreen();
        encounter(map[userRow][userColumn]);
      case "D":
        userRow = userRow + 1;
        checkRowBounds();
        checkColumnBounds();
        clearScreen();
        encounter(map[userRow][userColumn]);
        break;
      default:
      System.out.println("This doesn't work, try again.");
      userMoveIntro();
      moveForward();
      break;
    }
  }

  public void checkForWin(){
    if ((plantCount == 2) && (waterCount ==1)) {
      Game g = new Game();
      System.out.println("The water and plants you found are the signs needed that Sarz is inhabitable.");
      System.out.println("You have to head back to Earth now and let your planet know there's more out there.");
      System.out.println("\nThanks for playing Sarz++.");
      g.playAgain();
    }
    else {
      userMoveIntro();
      moveForward();
    }
   }
}
