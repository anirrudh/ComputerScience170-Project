/**
 * Created by SBlack on 26-Apr-16.
 */
import java.util.Scanner;

public class Time {
    Scanner keyboard = new Scanner(System.in);
    int playerInput = 0;
    int hour = 0;

    public boolean isDay() {
        /**Assuming the player has 4 options to choose from,*/
        while (playerInput == 1 || playerInput == 2 || playerInput == 3 || playerInput == 4) {
            hour++;
            /**At current moment, day is the first 6hrs of the game and every other 6hrs after that*/
            if (hour < 162){
              return true;
            }
          }
          return false;
        }


    public int getHour(){
        return (hour);
    }
    public int getDay(){
        int day;
        day = (int) Math.ceil((hour / 12)) + 1;
        return day;
    }
    public int getPlayerInput() {
        return playerInput;
    }

    /**Testing isDay*/
    /*
    public void testRun() {
        System.out.println("Enter current hour number: ");
        hour = keyboard.nextInt();
        System.out.println("Enter player input #");
        playerInput = keyboard.nextInt();
        System.out.println("Day = true, Night = false");
        System.out.println(isDay());
        System.out.println("It is day # " + getDay());
        System.out.println("It is hour # " + getHour());

    }

    public static void main(String []args){
        Time test = new Time();
        test.testRun();
    }*/
}
