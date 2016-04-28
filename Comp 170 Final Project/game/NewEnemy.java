/**
 * Created by Zack on 4/24/2016.
 */
package game;

public class NewEnemy {
    public static void main(String[] args){


        Enemies[] enemies = new Enemies[8];

        enemies[0].setEnemyName("Dragon");
        enemies[0].setEnemyHealth(100);
        enemies[0].setEnemyHitPoints(100);
        enemies[0].setEnemyLocation("Cave");
        enemies[0].setEnemyImage("dragonCave.gif");

        enemies[1].setEnemyName("Saturn Fly Trap");
        enemies[1].setEnemyHealth(10);
        enemies[1].setEnemyHitPoints(15);
        enemies[1].setEnemyLocation("Forest");
        enemies[1].setEnemyImage("trapForest.png");

        enemies[2].setEnemyName("Ice Ape");
        enemies[2].setEnemyHealth(50);
        enemies[2].setEnemyHitPoints(40);
        enemies[2].setEnemyLocation("Snow Region");
        enemies[2].setEnemyImage("apeSnowy.png");

        enemies[3].setEnemyName("Red Spotted Python");
        enemies[3].setEnemyHealth(25);
        enemies[3].setEnemyHitPoints(50);
        enemies[3].setEnemyLocation("Grassland");
        enemies[3].setEnemyImage("snakePlains.png");

        enemies[4].setEnemyName("Swarm of Blue Hornets");
        enemies[4].setEnemyHealth(15);
        enemies[4].setEnemyHitPoints(15);
        enemies[4].setEnemyLocation("Forest");
        enemies[4].setEnemyImage("hornetsForest.png");

        enemies[5].setEnemyName("Needle Cat");
        enemies[5].setEnemyHealth(35);
        enemies[5].setEnemyHitPoints(30);
        enemies[5].setEnemyLocation("Grassland");
        enemies[5].setEnemyImage("catPlains.png");

        enemies[6].setEnemyName("Sakai");
        enemies[6].setEnemyHealth(20);
        enemies[6].setEnemyHitPoints(10);
        enemies[6].setEnemyLocation("Snow Region");
        enemies[6].setEnemyImage("sakaiSnowy.png");

        enemies[7].setEnemyName("Swinging Squirrel");
        enemies[7].setEnemyHealth(25);
        enemies[7].setEnemyHitPoints(30);
        enemies[7].setEnemyLocation("Forest");
        enemies[7].setEnemyImage("squirrelForest.png");

        enemies[8].setEnemyName("Flying Penguin");
        enemies[8].setEnemyHealth(40);
        enemies[8].setEnemyHitPoints(30);
        enemies[8].setEnemyLocation("Snow Region");
        enemies[8].setEnemyImage("flyingSnowy.png");

        System.out.println(enemies[8]);





    }

}
