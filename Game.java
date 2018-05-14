import javax.swing.JOptionPane;

public class Game {

	static int _zeilen = 3;
	static int _spalten = 3;
	static String[][] Minenfeld = SpielfeldAnlegen(_zeilen, _spalten, true);
	static String[][] Spielfeld = SpielfeldAnlegen(_zeilen, _spalten, false);
	static int mines = 0;

	public static void main(String[] args) {

		String[][] Feld = SpielfeldAnlegen(_zeilen, _spalten, false);
		boolean ende = false;
		while (ende == false) {
			SpielfeldAnzeigen();
			int koZeile = eingabe("Bitte Zeile wählen");
			int koSpalte = eingabe("Bitte Spalte wählen");
			spielfeldPruefen(koZeile, koSpalte);

		}

	}

	public static int eingabe(String hinweis) {
		String eingabe = JOptionPane.showInputDialog(hinweis);
		return Integer.parseInt(eingabe);
	}

	public static boolean spielfeldPruefen(int Zeile, int Spalte) {
		if (Minenfeld[Zeile][Spalte] == "[x]") {
			System.out.println("Boom - du hast leider die Bombe getroffen");
			System.out.println("Game Over");
			return true;
		}

		else {
			Spielfeld[Zeile][Spalte] = "[*]";
			return false;
		}
	}

	public static String[][] SpielfeldAnlegen(int zeilen, int spalten, boolean minenanlegen) {
		String[][] mineField = new String[zeilen][spalten];
		for (int z = 0; z < zeilen; z++) {
			for (int s = 0; s < spalten; s++) {
				mineField[z][s] = "[ ]";
			}
		}
		if (minenanlegen == true) {
			mineField[0][1] = "[x]";
			mineField[(zeilen - 1)][0] = "[x]";
			mineField[(zeilen - 1)][2] = "[x]";
			mines = 3;
		}
		return mineField;

	}

	public static void SpielfeldAnzeigen() {
		for (int z = 0; z < _zeilen; z++) {
			for (int s = 0; s < _spalten; s++) {
				System.out.print(Spielfeld[z][s]);
			}
			System.out.println();
		}
		System.out.println("----------");

	}

}
