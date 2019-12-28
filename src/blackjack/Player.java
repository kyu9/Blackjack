package blackjack;

import java.util.List;

public interface Player {

	void receiveCard(Card card);
	
	void showCards();
	
	List<Card> openCards();
	
	boolean isTurn();
	
	void turnOn();
	
	void turnOff();
	
	String getName();
}
