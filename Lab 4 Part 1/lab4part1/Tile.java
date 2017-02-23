package lab4part1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tile {

  private static List<TileType> tileTypes = new ArrayList<>();
  private static boolean isSpotOccupied;
  private Random random = new Random();
  private TileType iconOne;
  private TileType iconTwo;
  private CurrentTileToken tokenOnTile = CurrentTileToken.NONE;

  public Tile(TileType iconOne, TileType iconTwo) {
    this.iconOne = iconOne;
    this.iconTwo = iconTwo;
  }

  public static void addTiles() {

    tileTypes.add(TileType.SUN);
    tileTypes.add(TileType.LEAVES);
    tileTypes.add(TileType.CLOUD);
    tileTypes.add(TileType.FLOWER);
    tileTypes.add(TileType.TIGER);
    tileTypes.add(TileType.DRAGON);
    tileTypes.add(TileType.BIRD);
    tileTypes.add(TileType.COMPUTER);

  }

  public static List<TileType> getTileTypes() {
    return tileTypes;
  }

  public static void setTileTypes(List<TileType> tileTypes) {
    Tile.tileTypes = tileTypes;
  }

  public static void setIsSpotOccupied(boolean isSpotOccupied) {
    Tile.isSpotOccupied = isSpotOccupied;
  }

  public TileType getIconTwo() {
    return iconTwo;
  }

  public void setIconTwo(TileType iconTwo) {
    this.iconTwo = iconTwo;
  }

  public TileType getIconOne() {
    return iconOne;
  }

  public void setIconOne(TileType iconOne) {
    this.iconOne = iconOne;
  }

  @Override
  public boolean equals(Object o) {

    PlayerMove playerMove = new PlayerMove(PlayerMove.getRows(), PlayerMove.getColumns());

    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Tile tile = (Tile) o;

    return iconOne == tile.iconOne && iconTwo == tile.iconTwo || iconOne == tile.iconTwo && iconTwo == tile.iconOne;
  }

  @Override
  public int hashCode() {
    int result = iconOne != null ? iconOne.hashCode() : 0;
    result = 31 * result + (iconTwo != null ? iconTwo.hashCode() : 0);
    return result;
  }

  public Random getRandom() {
    return random;
  }

  public void setRandom(Random random) {
    this.random = random;
  }

  public CurrentTileToken getTokenOnTile() {
    return tokenOnTile;
  }

  public void setTokenOnTile(CurrentTileToken tokenOnTile) {
    this.tokenOnTile = tokenOnTile;
  }

  @Override
  public String toString() {
    return iconOne + "/" + iconTwo + "/" + tokenOnTile;
  }

  public boolean isSpotOccupied() {
    return isSpotOccupied;
  }

  public void setSpotOccupied(boolean spotOccupied) {
    isSpotOccupied = spotOccupied;
  }


  public enum TileType {
    SUN, LEAVES, CLOUD, FLOWER, TIGER, DRAGON, BIRD, COMPUTER
  }

  public enum CurrentTileToken {
    RED, BLACK, NONE
  }
}
