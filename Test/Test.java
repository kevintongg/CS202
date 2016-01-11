public class Test {

	static int rows = 4;
	static int columns = 4;
	static char[][] table = new char[rows][columns];

	public static void main(String[] args) {

		makeTable();
		printTable(table);

	}

	public static void makeTable() {

		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				table[i][j] = ' ';
			}
		}
	}

	public static void printTable(char[][] table) {

		for (int i = 0; i < table.length; i++) {
			System.out.println("\t==============================");
			for (int j = 0; j < table[i].length; j++) {
				System.out.print("\t|" + table[i][j]);

			}
			System.out.println();
		}
	}
}

