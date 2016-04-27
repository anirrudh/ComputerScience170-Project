public class UserStats {
  String userName;
  String decision;

  private int hp;
  private int defense;
  private int day;
  private int hour;

  public UserStats(){
    userName = null;
    decision = null;

    hp = 0;
    defense = 0;
    day = 0;
    hour = 0;
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
}
