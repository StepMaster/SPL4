
public class Game {

	public static void main(String[] args) {

		String[][] Feld = SpielfeldAnlegen(3, 3);
		// Feld = mineSetzen(0,3);

	}

	public static String[][] SpielfeldAnlegen(int zeilen, int spalten) {
		String[][] mineField = new String[zeilen][spalten];
		for (int z = 0; z < zeilen; z++) {
				for (int s = 0;s<spalten;s++) {
					mineField[z][s]="[ ]";
				}
		}
		return mineField;
	}

}
