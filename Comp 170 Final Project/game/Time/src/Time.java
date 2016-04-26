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
            switch (hour) {
                case 1:case 2:case 3:case 4:case 5:case 6:case 13:case 14:case 15:case 16:case 17:case 18:case 25:case 26:case 27:case 28:case 29:case 30:
                case 37:case 38:case 39:case 40:case 41:case 42:case 49:case 50:case 51:case 52:case 53:case 54:
                case 61:case 62:case 63:case 64:case 65:case 66:case 73:case 74:case 75:case 76:case 77:case 78:
                case 85:case 86:case 87:case 88:case 89:case 90:case 97:case 98:case 99:case 100:case 101:case 102:
                case 109:case 110:case 111:case 112:case 113:case 114:case 121:case 122:case 123:case 124:case 125:case 126:
                case 133:case 134:case 135:case 136:case 137:case 138:case 145:case 146:case 147:case 148:case 149:case 150:
                case 157:case 158:case 159:case 160:case 161:case 162:
                    return true;
                default:
                    return false;
            }
        }return false;
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
    }
}
