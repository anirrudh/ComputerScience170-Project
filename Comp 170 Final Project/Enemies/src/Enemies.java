/**
 * Created by Zack on 4/24/2016.
 */
public class Enemies {
    private String enemyName;
    private int enemyHealth;
    private int enemyHitPoints;
    private String enemyLocation;
    public String enemyImage;




    public Enemies(){
       this.enemyName=enemyName;
       this.enemyHealth=enemyHealth;
       this.enemyHitPoints=enemyHitPoints;
       this.enemyLocation=enemyLocation;
   }

    public Enemies(String enemyName, int enemyHealth, int enemyHitPoints, String enemyLocation) {
        this.enemyName = enemyName;
        this.enemyHealth = enemyHealth;
        this.enemyHitPoints = enemyHitPoints;
        this.enemyLocation = enemyLocation;
    }
    public String getEnemyImage() {
        return enemyImage;
    }

    public void setEnemyImage(String enemyImage) {
        this.enemyImage = enemyImage;
    }

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
