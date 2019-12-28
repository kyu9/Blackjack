package blackjack;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class CardDeck {

	private List<Card> cards = new LinkedList<>();
	private static final String[] PATTERNS = {"Space", "Heart", "Diamond", "Clover"};
	private static final int CARD_COUNT = 13;
	
	public CardDeck() {
		cards = this.generateCards();
		
		
	}
	
	private List<Card> generateCards(){
		List<Card> cards = new LinkedList<>();
		
		for(String pattern : PATTERNS) {
			for(int i=0;i<=CARD_COUNT;i++) {
				Card card = new Card(pattern,i);
				cards.add(card);
			}
		}
		return cards;
		
	}
	

	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Card card : cards) {
			sb.append(card.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public Card draw() {
		int size = cards.size();
		int select = (int)(Math.random()*size);
		Card selectedCard = cards.get(select);
		cards.remove(select);
		return selectedCard;
	}
	
	private Card getRandomCard() {
		int size = cards.size();
		int select = (int)(Math.random()*size);
		return cards.get(select);
	}
	
	public Card getCard() {
		return null;
	}
}
