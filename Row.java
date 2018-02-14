import java.util.ArrayList;

public class Row {

	public Card[] cardRow = new Card[6];
	private int totalCard;

	public Row() {

	}

	public Card[] getCardRow() {
		return cardRow;
	}

	public void setCardRow(Card[] cardRow) {
		this.cardRow = cardRow;
	}

	public int getTotalCard() {
		return totalCard;
	}

	public void setTotalCard(int totalCard) {
		this.totalCard = totalCard;
	}

}
