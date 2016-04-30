import java.util.Random;

public class Item extends Sarz{

  private String itemName;
  private String itemLocation;
  Random r = new Random();
  Item[] plants;
  Item[] water;
  Item[] uselessItems;

  private enum Plants{

    MANGO("MANGO"), PEACH("PEACH"), BANANA("BANANA"), APPLE("APPLE"), ORANGE("ORANGE"), LEMON("LEMON");

    private String name;

    private Plants(String name){
      this.name = name;
    }

    public String toString(){
      return name;
    }
  }

  private enum Biomes{

    FOREST("FOREST"), SNOWREGION("SNOW REGION"), GRASSLAND("GRASSLAND"), CAVE("CAVE");

    private String name;

    private Biomes(String name){
      this.name = name;
    }

    public String toString(){
      return name;
    }
  }

  private enum UselessItems{

    RUBBERBAND("USELESS RUBBER BAND"), ROCK("USELESS ROCK"), STICK("USELESS STICK"), NOTHING("NOTHING HERE"), PIZZA("LEFTOVER GIORDANOS...MMM");

    private String name;

    private UselessItems(String name){
      this.name = name;
    }

    public String toString(){
      return name;
    }
  }

  public Item(){
    itemName = null;
    plants = new Item[6];
    water = new Item[1];
    uselessItems = new Item[11];
  }

  public Item(String itemName, String itemLocation){

    this.itemName = itemName;

  }

  public void generateItems(){
    for (int i = 0; i < 5; i++){
      plants[i] = new Item((Plants.values()[r.nextInt(5)]).name(), Biomes.values()[r.nextInt(3)].name());
    }

    water[0] = new Item("WATER", Biomes.values()[r.nextInt(3)].name());

    for (int i = 0; i < 10; i++){
      uselessItems[i] = new Item((UselessItems.values()[r.nextInt(4)]).name(), Biomes.values()[r.nextInt(3)].name());
    }

  }

  public String getItemName() {
      return itemName;
  }

  public void setItemName(String itemName) {
      this.itemName = itemName;
  }

  public String getItemLocation() {
    return itemLocation;
  }
  public void setItemLocation(String itemLocation){
    this.itemLocation = itemLocation;
  }


}
