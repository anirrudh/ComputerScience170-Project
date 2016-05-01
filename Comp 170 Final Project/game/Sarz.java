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
  Sarz[][] map = new Sarz[5][5];
  private int plantCount = 0;
  private int waterCount = 0;
  int userRow = 0;
  int userColumn  = 0;

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
    userMoveIntro();
    moveForward();
  }
  public void writeOutput() {
    setPlayerName();
    System.out.println("You have the choice between taking two items to help you on your journey: \n");
    System.out.print("Either some MEDICINE or a MACHETE. \n");
    System.out.println("");
    getWeapon();
    System.out.println("\nLet's begin this adventure!");

  }
  public int checkRowBounds()
    {
        try {
            //System.out.println("Checking here" + userRow);
            if(userRow == 5)
            {
                //System.out.println(userRow);
                System.out.println("Uh-oh, this looks like the end of the road. Try a differnt direction.");
                userMoveIntro();
                moveForward();
                userRow = 4;
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
  public int checkColumnBounds()

    {
        try
        {
            if(userColumn == 5)
            {
                System.out.println("Hey! You've reached the end of the road here. \n Looks like you'll have to find another way around.");
                userMoveIntro();
                moveForward();
                userColumn = 4;
                System.out.println(userColumn);
            }

        }
        catch(ArrayIndexOutOfBoundsException err)
        {
            System.out.println("You can't keep going. It's the end of the road. Please choose a different direction.");
            userColumn = userColumn - 1;
            userMoveIntro();
            moveForward();
            return userColumn;
        }
        return userColumn;
    }


  public String setPlayerName() {
    Scanner playerNameKeyboard = new Scanner(System.in);
    user = new UserStats(playerNameKeyboard.next());
    System.out.println("You are a brave one, " + user.getUserName() + ", welcome to the Sarz mission.");
    return user.getUserName();
  }
  public void reset(){
    UserStats user = new UserStats();
    Sarz[][] map = new Sarz[5][5];
    plantCount = 0;
    waterCount = 0;
    userRow = 0;
    userColumn  = 0;
  }
  public void playAgain(){
    System.out.println("Would you like to play again?");
    System.out.println("Enter 1 for YES or 2 for NO.");
    int playChoice = 0;
    playChoice = keyboard.nextInt();
    switch (playChoice) {
      case 1:
        reset();
        play();
        break;
      case 2:
        System.out.println("Thanks for visiting Sarz++.");
        System.exit(0);
        break;
      default:
        System.out.println("Please enter 1 or 2.");
        playAgain();
        break;
    }
  }
  public void checkForWin(){
    if ((plantCount == 1) && (waterCount ==1)) {
      System.out.println("Congratulations! The water and plant you found are the signs needed that Sarz is inhabitable.");
      System.out.println("You have to head back to Earth now and let your planet know there's more out there.");
      System.out.println("\nThanks for playing Sarz++.");
      playAgain();
    }

   }
  public void mapGeneration() {
    int count = 0;
    int row;
    int column;

    Enemies e = new Enemies();
    e.generateEnemies();
    //This generates enemies
    while (count < 9){
      row = r.nextInt(5);
      column = r.nextInt(5);
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
    while (count < 6){
      row = r.nextInt(5);
      column = r.nextInt(5);
      if (map[row][column] == null){
        map[row][column] = itemGenerator.plants[r.nextInt(5)];
        //System.out.println(((Item)map[row][column]).getItemName() + " at " + row + "," + column);
        count++;
      }
    }
    //This generates water
    count = 0;
    while(count < 3){
      row = r.nextInt(5);
      column = r.nextInt(5);
      if (map[row][column] == null){
        map[row][column] = itemGenerator.water[0];
        //System.out.println(((Item)map[row][column]).getItemName() + " at " + row + "," + column);
        count ++;
      }
    }
    //This generates useless items
    count = 0;
    while(count < 7){
      row = r.nextInt(5);
      column = r.nextInt(5);
      if (map[row][column] == null){
        map[row][column] = itemGenerator.uselessItems[r.nextInt(10)];
        //System.out.println(((Item)map[row][column]).getItemName() + " at " + row + "," + column);
        count ++;
      }
    }
  }
  /*This is simply the write output function so the code is streamlined*/
  /*This is where we ask the user about what their "ability" will be*/
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


    try
    {
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
  catch (InputMismatchException e)
  {
    System.out.println("You didn't enter a vaild number. Please enter a vaild number.");
    getWeapon();
  }
  return userChoice;
  }

  public void encounter(Sarz array){
    if (array instanceof Item){
      System.out.println("\nYou have encountered a " + ((Item)array).getItemName() + "\n");
      itemEncounter(array);
    }
    else if (array instanceof Enemies){
      System.out.println("\nYou have encountered a " + ((Enemies)array).getEnemyName() + "\n\nTime to battle!" );
      enemyAttack(array);
    }
  }

  public void itemEncounter(Sarz array){
    Item i = new Item();
    //System.out.println(((Item)array).getUseful());
    if (((Item)array).getUseful() == 2){
      System.out.println("Congratulations! This " + ((Item)array).getItemName() + " is a sign that Sarz++ may be inhabitable.");
      plantCount ++;
      checkForWin();
      userMoveIntro();
      moveForward();

    }
    if (((Item)array).getUseful() == 1){
      System.out.println("Congratulations! This " + ((Item)array).getItemName() + " is a sign that Sarz++ may be inhabitable.");
      waterCount ++;
      checkForWin();
      userMoveIntro();
      moveForward();
    }
    else {
      System.out.println("This won't help you on your mission.");
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
    if (((Enemies)array).getEnemyHealth() <= 0){
      System.out.println("You killed the " + ((Enemies)array).getEnemyName() + "!");
      userMoveIntro();
      moveForward();
    }
    else if ((user.getHP()) <= 0){
      System.out.println("The " + ((Enemies)array).getEnemyName() + " has killed you!\n");
      playAgain();
    }
  }

  public void userAttack(Sarz array) {
    ((Enemies)array).setEnemyHealth((((Enemies)array).getEnemyHealth()-user.getHitPoints()));
    System.out.println("You inflicted " + user.getHitPoints() + " damage!");
    battleWin(array);
    System.out.println("\nYour health is: " + user.getHP());
    System.out.println("\nThe enemy's health is: " + ((Enemies)array).getEnemyHealth());
    battleDialogue(array);
  }

  public void battleDialogue(Sarz array){

    int decision = 0;

    System.out.println("\nPlease enter:");
    System.out.println("\n1 to attack");
    System.out.println("2 to run away\n");

    decision = keyboard.nextInt();

    switch (decision) {

      case 1:
            userAttack(array);
            enemyAttack(array);
            break;
      case 2:
            if (r.nextInt(10) > 5){
              System.out.println("You managed to escape!\n");
              userMoveIntro();
              moveForward();
            }
            else {
              System.out.println("You couldn't escape!");
              enemyAttack(array);
            }
            break;
    }
  }

  public void userMoveIntro() {
    Scanner inputStreamPrompt = null; //Use the scanner to read the files in.
    //This is where we will ask the user which directinon they would like to move in.
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
        System.out.println("You're moving forward now. Into the dark.");
        userRow = 1 + userRow;
        checkRowBounds();
        checkColumnBounds();
        encounter(map[userRow][userColumn]);
        break;
      case "A":
        System.out.println("You're moving to the left now. It's cold.");
        userColumn = userColumn + 1;
        checkRowBounds();
        checkColumnBounds();
        encounter(map[userRow][userColumn]);
        break;
      case "D":
        System.out.println("You're moving to the right now. It's cold.");
        userColumn= 1 + userColumn;
        checkRowBounds();
        checkColumnBounds();
        encounter(map[userRow][userColumn]);
        break;
      default:
      System.out.println("This doesn't work, try again.");
      userMoveIntro();
      moveForward();
      break;
    }
  }

}
