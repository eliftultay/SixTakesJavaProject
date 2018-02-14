import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CardFrame extends JFrame {

	private JButton startB, finishB;
	private JButton[] player1 = new JButton[7];
	private JButton[] player2 = new JButton[12];
	private JButton[][] cards = new JButton[4][6];
	private JPanel[] panel = new JPanel[6];
	private int n1, n2, n3, n4;
	private ButtonGroup[] bg = new ButtonGroup[4];
	private Card[] card = new Card[53];
	private static int cursor = 0;
	private Row[] row = new Row[4];
	private Player[] player = new Player[2];

	public CardFrame(Card[] card) {
		this.card = card;

		for (int i = 0; i < 4; i++) {
			row[i] = new Row();
		}
		for (int i = 0; i < 2; i++) {
			player[i] = new Player();
		}

		setLayout(new FlowLayout());

		CardHandler handler = new CardHandler();

		startB = new JButton("Start");
		add(startB);
		startB.addActionListener(handler);
		finishB = new JButton("Finish");
		add(finishB);
		finishB.addActionListener(handler);

		for (int i = 0; i < 7; i++) {
			player1[i] = new JButton();
			add(player1[i]);
			player2[i] = new JButton();
			add(player2[i]);
		}

		panel[5] = new JPanel();
		for (int j = 0; j < 7; j++) {
			player2[j].setPreferredSize(new Dimension(80, 100));
			panel[5].add(player2[j]);
			player2[j].addActionListener(handler);
		}
		add(panel[5]);

		for (int i = 0; i < 4; i++) {
			panel[i] = new JPanel();
			for (int k = 0; k < 6; k++) {
				cards[i][k] = new JButton();
				cards[i][k].setPreferredSize(new Dimension(80, 100));
				panel[i].add(cards[i][k]);
			}
			add(panel[i]);
		}

		panel[4] = new JPanel();
		for (int j = 0; j < 7; j++) {
			player1[j].setPreferredSize(new Dimension(80, 100));
			panel[4].add(player1[j]);
			player1[j].addActionListener(handler);
		}
		add(panel[4]);

	}

	private class CardHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == startB) {

				pr("Welcome");
				pr("Above, Player 2 \n Below, Player 1. ");

				Collections.shuffle(Arrays.asList(card));
				setNumbers();

			} else if (e.getSource() == finishB) {

			} else if (e.getSource() == player1[0]) {

				int rowNum = findRow(player[0].cards[0]);
				settle(rowNum, player[0].cards[0], 0);
				cardChange(1, 0, 0); // (player1, player[], cards[])

			} else if (e.getSource() == player1[1]) {

				int rowNum = findRow(player[0].cards[0]);
				settle(rowNum, player[0].cards[1], 0);
				cardChange(1, 0, 1);

			} else if (e.getSource() == player1[2]) {

				int rowNum = findRow(player[0].cards[0]);
				settle(rowNum, player[0].cards[2], 0);
				cardChange(1, 0, 2);

			} else if (e.getSource() == player1[3]) {

				int rowNum = findRow(player[0].cards[0]);
				settle(rowNum, player[0].cards[3], 0);
				cardChange(1, 0, 3);

			} else if (e.getSource() == player1[4]) {

				int rowNum = findRow(player[0].cards[0]);
				settle(rowNum, player[0].cards[4], 0);
				cardChange(1, 0, 4);

			} else if (e.getSource() == player1[5]) {

				int rowNum = findRow(player[0].cards[0]);
				settle(rowNum, player[0].cards[5], 0);
				cardChange(1, 0, 5);

			} else if (e.getSource() == player1[6]) {

				int rowNum = findRow(player[0].cards[0]);
				settle(rowNum, player[0].cards[6], 0);
				cardChange(1, 0, 6);

			} else if (e.getSource() == player2[0]) {

				int rowNum = findRow(player[1].cards[0]);
				settle(rowNum, player[1].cards[0], 1);
				cardChange(2, 1, 0);

			} else if (e.getSource() == player2[1]) {

				int rowNum = findRow(player[1].cards[1]);
				settle(rowNum, player[1].cards[1], 1);
				cardChange(2, 1, 1);

			} else if (e.getSource() == player2[2]) {

				int rowNum = findRow(player[1].cards[2]);
				settle(rowNum, player[0].cards[2], 1);
				cardChange(2, 1, 2);
			} else if (e.getSource() == player2[3]) {

				int rowNum = findRow(player[1].cards[3]);
				settle(rowNum, player[1].cards[3], 1);
				cardChange(2, 1, 3);
			} else if (e.getSource() == player2[4]) {

				int rowNum = findRow(player[0].cards[4]);
				settle(rowNum, player[1].cards[4], 1);
				cardChange(2, 1, 4);

			} else if (e.getSource() == player2[5]) {

				int rowNum = findRow(player[1].cards[5]);
				settle(rowNum, player[1].cards[5], 1);
				cardChange(2, 1, 5);
			} else if (e.getSource() == player2[6]) {

				int rowNum = findRow(player[1].cards[6]);
				settle(rowNum, player[1].cards[6], 1);
				cardChange(2, 1, 6);
			}

		}

	}

	public void setNumbers() {

		for (int i = 0; i < 4; i++) {
			row[i].cardRow[0] = card[cursor];
			row[i].setTotalCard(1);
			cards[i][0].setText("" + (card[cursor].getCardNumber() + 1));
			cards[i][0].setForeground(card[cursor].getColor());
			cursor++;
		}

		for (int i = 0; i < 7; i++) {
			player[0].cards[i] = card[cursor];
			player1[i].setText("" + (card[cursor].getCardNumber() + 1));
			player1[i].setForeground(card[cursor].getColor());
			cursor++;

			player[1].cards[i] = card[cursor];
			player2[i].setText("" + (card[cursor].getCardNumber() + 1));
			player2[i].setForeground(card[cursor].getColor());
			cursor++;
		}

	}

	public void settle(int rowNum, Card c, int p) {

		if (row[rowNum].getTotalCard() == 5) {
			for (int i = 0; i < 5; i++) {
				player[p].setScore(player[p].getScore() + row[rowNum].cardRow[i].getHornNumber());
			}

			row[rowNum].cardRow[0] = c;
			cards[rowNum][0].setText("" + (c.getCardNumber() + 1));

			for (int i = 1; i < 6; i++) {
				row[rowNum].cardRow[i] = null;
				cards[rowNum][i].setText(" ");
			}
			row[rowNum].setTotalCard(1);
			
		} else {
			
			// sağdan öncelik vermemizin nedeni boynuzu az yemek kk 
			 
			int hold = 0, fark = 99;
			for (int i = (row[rowNum].getTotalCard() - 1); i >= 0; i--) {
				if ((Math.abs(row[rowNum].cardRow[i].getCardNumber() - c.getCardNumber()) < fark)) {

					hold = i;
					fark = Math.abs(row[rowNum].cardRow[i].getCardNumber() - c.getCardNumber());

				}
			}
			if (c.getCardNumber() > row[rowNum].cardRow[hold].getCardNumber()) {
				for (int i = (hold + 1); i < (row[rowNum].getTotalCard()); i++) {
					player[p].setScore(player[p].getScore() + row[rowNum].cardRow[i].getHornNumber());
					row[rowNum].cardRow[i] = null;
					cards[rowNum][i].setText("");
				}

				row[rowNum].cardRow[hold + 1] = c;
				cards[rowNum][hold + 1].setText("" + (c.getCardNumber() + 1));
				row[rowNum].setTotalCard(hold + 2);

			} else {
				for (int i = (hold); i < (row[rowNum].getTotalCard()); i++) {
					player[p].setScore(player[p].getScore() + row[rowNum].cardRow[i].getHornNumber());
					row[rowNum].cardRow[i] = null;
					cards[rowNum][i].setText("");
				}

				row[rowNum].cardRow[hold] = c;
				cards[rowNum][hold].setText("" + (c.getCardNumber() + 1));
				row[rowNum].setTotalCard(hold + 1);

			}
		}

	}

	public int findRow(Card c) {

		int hold = 0, fark = 99;

		for (int i = 0; i < 4; i++) {
			if (Math.abs(row[i].cardRow[0].getCardNumber() - c.getCardNumber()) < fark) {
				hold = i;
				fark = Math.abs(row[i].cardRow[0].getCardNumber() - c.getCardNumber());
			} else if (Math.abs(row[i].cardRow[row[i].getTotalCard() - 1].getCardNumber() - c.getCardNumber()) < fark) {
				hold = i;
				fark = Math.abs(row[i].cardRow[row[i].getTotalCard() - 1].getCardNumber() - c.getCardNumber());
			}

		}

		return hold;
	}

	public void cardChange(int playerButton, int p, int c) {

		player[p].cards[c] = card[cursor];
		cursor++;

		if (playerButton == 1) {
			player1[c].setText("" + (player[p].cards[c].getCardNumber() + 1));
		} else {
			player2[c].setText("" + (player[p].cards[c].getCardNumber() + 1));
		}

	}

	public void pr(Object o) {
		System.out.println(o);
	}

}
