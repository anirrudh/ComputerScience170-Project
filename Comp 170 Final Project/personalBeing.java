
public class personalBeing() {
/*Here we will initialize the variable we need for this project to work. We will initialize the player's HealthPoints
based upon several factors, such as the weapons which are chosen by the person when they are first introduced to the game
experience. (Last Edit was Sunday, April 10th 2016 by Anirrudh Krishnan)*/
int HP;

public int HealthPoints(int HP){

  this.HP = HP;
}
//This method will be used to checj whihc weapon was chosed to see if a bonus is needed
public static checkForWeapons(){
//Put the code here to check for shich items the user chose
//Write an if statement to check which weapon will be chosen for the future.
/*
*if(enum.slot1 == "Machete" || enum.slot2 == "Machete" && enum.slot 1 == "Torch" || enum.slot2 == "Torch")
{
HP = HP + 300;
return HP;
personalBeing Torcher = new personalBeing;
Torcher.checkForNightTime;
}
*
*
*
*
*
*
*
*
*
*/
}
  public bool checkForNightTime(string Torch)
  {
    personalBeing Time = new personalBeing();
    if(int Time >= 6){
      HP = HP + 10;
      return HP;
  }
    else {
      return false; 
    }

}
