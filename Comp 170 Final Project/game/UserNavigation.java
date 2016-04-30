/*
import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

/* This class will be used to let the user navigate and interact through the map.
* Given birth to by @AnirrudhKrishnan
* Last Edit:
*
*
*
public class UserNavigation {
  String KM = null;
  int userRow;
  int userColumn;
  Sarz s = new Sarz();

  //This will make the user move forward in the array.
  public void moveForward() {

    userRow = 0;
    userColumn = 0;
    Scanner keyMove = new Scanner(System.in);
    KM = keyMove.next().toUpperCase();
    switch(KM)
    {
      case "W":
      s.encounter(s.map[userRow][userColumn]);
      break;
      default:
      System.out.println("This doesn't work, try again.");
    }

  }
  //}

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
}
**/
