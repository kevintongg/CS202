package lab4part1;

public class Tile {

    private IconType iconOne;
    private IconType iconTwo;
    private boolean isSpotOccupied;

    public Tile(IconType iconOne, IconType iconTwo, boolean isSpotOccupied) {
        this.iconOne = iconOne;
        this.iconTwo = iconTwo;
        this.isSpotOccupied = isSpotOccupied;
    }

    @Override
    public String toString() {
        return "Tile{" +
                "iconOne=" + iconOne +
                ", iconTwo=" + iconTwo +
                ", isSpotOccupied=" + isSpotOccupied +
                '}';
    }

    public IconType getIconOne() {
        return iconOne;
    }

    public void setIconOne(IconType iconOne) {
        this.iconOne = iconOne;
    }

    public IconType getIconTwo() {
        return iconTwo;
    }

    public void setIconTwo(IconType iconTwo) {
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

    public enum IconType {
        SUN, LEAVES, CLOUD, FLOWER, TIGER, DRAGON, BIRD, COMPUTER
    }
}
