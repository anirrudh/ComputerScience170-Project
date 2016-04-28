

public class userStats {

  String userName;
  String decision;

  private int hp;
  private int defense;
  private int day;
  private int hour;

  public userStats(){
    userName = null;
    decision = null;

    hp = 0;
    defense = 0;
    day = 0;
    hour = 0;
  }

  public userStats(String userName){
    this.userName = userName;
    decision = null;

    hp = 100;
    defense = 100;
    day = 1;
    hour = 1;
  }

  public String getUserName(){
    return userName;
  }
  public String getDecision(){
    return decision;
  }

  public int getHP(){
    return hp;
  }
  public int getDefense(){
    return defense;
  }
  public int getDay(){
    return day;
  }
  public int getHour(){
    return hour;
  }

  public void setUserName(String userName){
    this.userName = userName;
  }
  public void setDecision(String decision){
    this.decision = decision;
  }

  public void setHP(int hp){
    this.hp = hp;
  }
  public void setDefense(int defense){
    this.defense = defense;
  }
  public void setDay(int day){
    this.day = day;
  }
  public void setHour(int hour){
    this.hour = hour;
  }
  /*
  public boolean isDay() {

       while (playerInput == 1 || playerInput == 2 || playerInput == 3 || playerInput == 4) {
           hour++;
           At current moment, day is the first 6hrs of the game and every other 6hrs after that
           if (hour < 162){
             return true;
           }
         }
         return false;
       }
       public int getDay(){
     int day;
     day = (int) Math.ceil((hour / 12)) + 1;
     return day;
 }
*/

}
