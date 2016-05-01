

public class UserStats {

  String userName;
  String decision;

  private double hp;
  private int day;
  private int hour;
  private int hours;
  private boolean weaponChoice;
  private double hitPoints;

  public UserStats(){
    userName = null;
    decision = null;
    weaponChoice = false;
    hitPoints = 0.0;
    hp = 0.0;
    day = 0;
    hour = 0;
  }

  public UserStats(String userName){
    this.userName = userName;
    decision = null;
    hitPoints= 15.00;
    hp = 100.00;
    day = 1;
    hour = 1;
  }
  public double getHitPoints() {
    return hitPoints;
  }
  public String getUserName(){
    return userName;
  }
  public String getDecision(){
    return decision;
  }

  public double getHP(){
    return hp;
  }
  public int getDay(){
    return day;
  }
  public int getHour(){
    return hour;
  }
  public void setHitPoints(double hitPoints){
    this.hitPoints = hitPoints;
  }
  public void setUserName(String userName){
    this.userName = userName;
  }
  public void setDecision(String decision){
    this.decision = decision;
  }

  public void setHP(double hp){
    this.hp = hp;
  }
  public void setDay(int day){
    this.day = day;
  }
  public void setHour(int hour){
    this.hour = hour;
  }
  public double setMedicine() {
    setHP(getHP() + 30.00);
    //System.out.println(hp);
    return hp;
  }

  public void setMachete(boolean weaponChoice){
    this.weaponChoice = weaponChoice;
  }
  public boolean getMachete(){
    return weaponChoice;
  }

  public int Time()
  {

    boolean playerMoveTime;
    playerMoveTime = false;
    if (playerMoveTime = true)
    {
      hours = hours + 1;
    }
    return hours;
  }

}
