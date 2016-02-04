package lab4part1;

import java.util.ArrayList;

public class Tile {

	private static ArrayList<TileType> tileTypes = new ArrayList<>();
	private TileType iconOne;
	private TileType iconTwo;
	private boolean isSpotOccupied;

	public Tile(TileType iconOne, TileType iconTwo, boolean isSpotOccupied) {
		this.iconOne = iconOne;
		this.iconTwo = iconTwo;
		this.isSpotOccupied = isSpotOccupied;
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

		System.out.println(tileTypes.contains(TileType.DRAGON));
		tileTypes.forEach(System.out::println);

	}

	public static ArrayList<TileType> getTileTypes() {
		return tileTypes;
	}

	public static void setTileTypes(ArrayList<TileType> tileTypes) {
		Tile.tileTypes = tileTypes;
	}

	@Override
	public String toString() {
		return "Tile{" +
				"iconOne=" + iconOne +
				", iconTwo=" + iconTwo +
				", isSpotOccupied=" + isSpotOccupied +
				'}';
	}

	public TileType getIconOne() {
		return iconOne;
	}

	public void setIconOne(TileType iconOne) {
		this.iconOne = iconOne;
	}

	public TileType getIconTwo() {
		return iconTwo;
	}

	public void setIconTwo(TileType iconTwo) {
		this.iconTwo = iconTwo;
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
		if (iconOne != tile.iconOne) return false;
		return iconTwo == tile.iconTwo;

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
