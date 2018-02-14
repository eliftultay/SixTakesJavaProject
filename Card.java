import java.awt.Color;

public class Card {

	// 19-36 random horn number at

	private int cardNumber;
	private int hornNumber;
	private Color Color;

	public Card() {

	}

	public Color getColor() {
		return Color;
	}

	public void setColor(Color color) {
		Color = color;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getHornNumber() {
		return hornNumber;
	}

	public void setHornNumber(int hornNumber) {
		this.hornNumber = hornNumber;
	}

}
