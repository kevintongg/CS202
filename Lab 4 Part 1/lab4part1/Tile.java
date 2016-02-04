package lab4part1;

import java.util.ArrayList;
import java.util.Random;

public class Tile {

	private static ArrayList<TileType> tileTypes = new ArrayList<>();
	private static Random random = new Random();
	private static TileType iconOne;
	private static TileType iconTwo;
	private static boolean isSpotOccupied;

	public Tile(TileType iconOne, TileType iconTwo) {
		Tile.iconOne = iconOne;
		Tile.iconTwo = iconTwo;
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

	public static Random getRandom() {
		return random;
	}

	public static void setRandom(Random random) {
		Tile.random = random;
	}

	public static ArrayList<TileType> getTileTypes() {
		return tileTypes;
	}

	public static void setTileTypes(ArrayList<TileType> tileTypes) {
		Tile.tileTypes = tileTypes;
	}

	public static TileType getIconOne() {
		return iconOne;
	}

	public static void setIconOne(TileType iconOne) {
		Tile.iconOne = iconOne;
	}

	@Override
	public String toString() {
		return "Tile{" +
				"isSpotOccupied=" + isSpotOccupied +
				'}';
	}

	public TileType getIconTwo() {
		return iconTwo;
	}

	public static void setIconTwo(TileType iconTwo) {
		Tile.iconTwo = iconTwo;
	}

	public boolean isSpotOccupied() {
		return isSpotOccupied;
	}

	public void setSpotOccupied(boolean spotOccupied) {
		isSpotOccupied = spotOccupied;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Tile tile = (Tile) o;

		if (isSpotOccupied != tile.isSpotOccupied) return false;
		if (iconOne != iconOne) return false;
		return iconTwo == iconTwo;

	}

	@Override
	public int hashCode() {
		int result = iconOne != null ? iconOne.hashCode() : 0;
		result = 31 * result + (iconTwo != null ? iconTwo.hashCode() : 0);
		result = 31 * result + (isSpotOccupied ? 1 : 0);
		return result;
	}

	public enum TileType {
		SUN, LEAVES, CLOUD, FLOWER, TIGER, DRAGON, BIRD, COMPUTER
	}
}
