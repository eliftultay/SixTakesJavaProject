
public class Player {

	public Card[] cards = new Card[7];
	private int Score;
	private String Name;

	public Player() {
		Score=0;
	}

	public Card[] getCards() {
		return cards;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

}
