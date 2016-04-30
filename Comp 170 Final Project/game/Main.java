import java.util.*;
public class Main {

  public static void main(String[] args){
  Sarz game = new Sarz();
  userNavigation n = new userNavigation();
  game.premise();
  game.play();
  n.userMoveIntro();
  }

}
