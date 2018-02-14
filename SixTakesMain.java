import java.awt.Color;



import javax.swing.JFrame;

public class SixTakesMain {

	public static void main(String[] args) {

		Player p1 = new Player();
		Player p2 = new Player();
		Row[] row = new Row[4];
		Card[] cards = new Card[52];

		for (int i = 0; i < 4; i++) {
			row[i] = new Row();
		}

		for (int i = 0; i < 52; i++) {
			cards[i] = new Card();
			cards[i].setCardNumber(i);

			if (i % 13 == 0) {
				cards[i].setHornNumber(7);
				cards[i].setColor(Color.RED);
			} else if (i % 11 == 0) {
				cards[i].setHornNumber(5);
				cards[i].setColor(Color.GREEN);
			} else if (i % 10 == 0) {
				cards[i].setHornNumber(3);
				cards[i].setColor(Color.BLUE);
			} else if (i % 5 == 0) {
				cards[i].setHornNumber(2);
				cards[i].setColor(Color.MAGENTA);
			} else {
				cards[i].setHornNumber(1);
				
			}

		}

		// Collections.shuffle(Arrays.asList(cards));


		CardFrame app = new CardFrame(cards);
		app.setSize(650, 800);
		app.setResizable(false);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}

}
