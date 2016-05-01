import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Game {
  Sarz s = new Sarz();

  Scanner keyboard = new Scanner(System.in);

  public void premise(){
    s.clearScreen();
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
    s.mapGeneration();
    s.userMoveIntro();
    s.moveForward();
  }

  public void writeOutput() {
    s.setPlayerName();
    System.out.println("\nYou have the choice between taking two items to help you on your journey: \n");
    System.out.print("Either some MEDICINE or a MACHETE. \n");
    System.out.println("");
    s.getWeapon();
  }

  public void playAgain(){
    System.out.println("Would you like to play again?");
    System.out.println("Enter 1 for YES or 2 for NO.");
    int playChoice = 0;
    playChoice = keyboard.nextInt();
    switch (playChoice) {
      case 1:
        s.reset();
        Main.main(new String[0]);
        break;
      case 2:
        System.out.println("Thanks for visiting Sarz++.");
        System.exit(0);
        break;
      default:
        System.out.println("Invalid input. Please enter a valid choice.");
        playAgain();
        break;
    }
  }

  public void checkForWin(){
    if ((s.plantCount == 2) && (s.waterCount ==1)) {
      System.out.println("The water and plants you found are the signs needed that Sarz is inhabitable.");
      System.out.println("You have to head back to Earth now and let your planet know there's more out there.");
      System.out.println("\nThanks for playing Sarz++.");
      playAgain();
    }
   }
}
