/**
 * Created by Zack on 4/24/2016.
 */
 import java.util.*;
 import java.lang.*;


public class Enemies extends Sarz{

    private String enemyName;
    private int enemyHealth;
    private int enemyHitPoints;
    private String enemyLocation;
    public String enemyImage;
    Enemies[] enemies;

    public Enemies(){
       enemyName = null;
       enemyHealth = 0;
       enemyHitPoints = 0;
       enemyLocation = null;
       enemies = new Enemies[9];

   }

    public Enemies(String enemyName, int enemyHealth, int enemyHitPoints, String enemyLocation) {
        this.enemyName = enemyName;
        this.enemyHealth = enemyHealth;
        this.enemyHitPoints = enemyHitPoints;
        this.enemyLocation = enemyLocation;

    }
    /** Making enemy types here that can be picked from randomly in Sarz**/
    public void generateEnemies(){

    enemies[0] = new Enemies("DRAGON", 100, 100, "Cave");
    enemies[1] = new Enemies("SATURN FLY TRAP", 10, 15, "Forest");
    enemies[2] = new Enemies("ICE APE", 50, 40, "Snow Region");
    enemies[3] = new Enemies("RED SPOTTED PYTHON", 25, 50, "Grassland");
    enemies[4] = new Enemies("SWARM OF BLUE HORNETS", 15, 15, "Forest");
    enemies[5] = new Enemies("NEEDLE CAT", 35, 30, "Grassland");
    enemies[6] = new Enemies("SAKAI", 20, 10, "Snow Region");
    enemies[7] = new Enemies("SWINGING SQUIRREL", 25, 30, "Forest");
    enemies[8] = new Enemies("FLYING PENGUIN", 40, 30, "Snow Region");



    /*

    enemies[0].setEnemyImage("dragonCave.gif");
    enemies[1].setEnemyImage("trapForest.png");
    enemies[2].setEnemyImage("apeSnowy.png");
    enemies[3].setEnemyImage("snakePlains.png");
    enemies[4].setEnemyImage("hornetsForest.png");
    enemies[5].setEnemyImage("catPlains.png");
    enemies[6].setEnemyImage("sakaiSnowy.png");
    enemies[7].setEnemyImage("squirrelForest.png");
    enemies[8].setEnemyImage("flyingSnowy.png");
    */

    }



    public Enemies[] getEnemies(){
      return enemies;
    }

    public void setEnemies(Enemies[] enemiesArray){
      enemies = enemiesArray;
    }
    /*
    public String getEnemyImage() {
        return enemyImage;
    }

    public void setEnemyImage(String enemyImage) {
        this.enemyImage = enemyImage;
    }
    */

    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }


    public int getEnemyHealth() {

        return enemyHealth;
    }

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public int getEnemyHitPoints() {
        return enemyHitPoints;
    }

    public void setEnemyHitPoints(int enemyHitPoints) {
        this.enemyHitPoints = enemyHitPoints;
    }

    public String getEnemyLocation() {
        return enemyLocation;
    }

    public void setEnemyLocation(String enemyLocation) {
        this.enemyLocation = enemyLocation;
    }
}
