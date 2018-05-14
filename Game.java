import javax.swing.JOptionPane;

public class Game {

	static int _zeilen = 3;
	static int _spalten = 3;
	static String[][] Minenfeld = SpielfeldAnlegen(_zeilen, _spalten, true);
	static String[][] Spielfeld = SpielfeldAnlegen(_zeilen, _spalten, false);
	static int mines = 0;

	public static void main(String[] args) {

		boolean ende = false;
		while (ende == false) {
			SpielfeldAnzeigen(false);

			int koZeile = eingabe("Bitte Zeile wählen");
			int koSpalte = eingabe("Bitte Spalte wählen");

			ende = spielfeldPruefen(koZeile, koSpalte);
		}

	}

	public static int eingabe(String hinweis) {

		int eingabe;
		boolean ende = false;

		do {
			String ein = JOptionPane.showInputDialog(hinweis);
			eingabe = Integer.parseInt(ein);
			if (eingabe <= _zeilen-- && eingabe >= 0) {

				ende = true;
			} else {
				System.out.println("Achtung: Bitte geben Sie nur einen Wert zwischen 0 und " + _zeilen--);
			}
		} while (ende == false);

		return eingabe;
	}

	public static boolean spielfeldPruefen(int Zeile, int Spalte) {
		if (Minenfeld[Zeile][Spalte] == "[x]") {
			System.out.println("Boom - du hast leider die Bombe getroffen");
			System.out.println("Game Over!");
			SpielfeldAnzeigen(true);
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
			String x = JOptionPane.showInputDialog("Gib deine Anzahl der Minen an");
			int Mineneingabe= Integer.parseInt(x);
			for(int i =0;i<=Mineneingabe;i++) {
				mineField[(int) ((Math.random()*_zeilen)+1)][(int) ((Math.random()*_spalten)+1)] = "[x]";
			}


		}
		return mineField;

	}

	public static void SpielfeldAnzeigen(boolean minen) {
		
		if (minen == false) {
			for (int z = 0; z < _zeilen; z++) {
				for (int s = 0; s < _spalten; s++) {
					System.out.print(Spielfeld[z][s]);
				}
				System.out.println();
			}
			System.out.println("----------");
			
			
			
		} else {
			for (int z = 0; z < _zeilen; z++) {
				for (int s = 0; s < _spalten; s++) {
					if (Minenfeld[z][s] == "[x]") {
						System.out.print(Minenfeld[z][s]);
					} else {
						System.out.print(Spielfeld[z][s]);
					}
				}
				System.out.println();
			}
			
		}
	}

}
