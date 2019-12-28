package blackjack;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

	private int INIT_RECEIVE_CARD_COUNT=2;
	
	public void play() {
		System.out.println("==========Blackjack===========");
		Scanner sc = new Scanner(System.in);
		Rule rule = new Rule();
		CardDeck cardDeck = new CardDeck();
		
		List<Player> players = Arrays.asList(new Gamer("사용자1"), new Dealer());
		List<Player> initAfterPlayers = initPhase(cardDeck, players);
		List<Player> playingAfterPlayers = playingPhase(sc, cardDeck, initAfterPlayers);
		
		
		Player winner = rule.getWinner(playingAfterPlayers);
		System.out.println("승자는 "+winner.getName());
	}
	
	private List<Player> playingPhase(Scanner sc, CardDeck cardDeck, List<Player> players) {
		List<Player> cardReceivedPlayers;
		boolean isPlayerTurn=false;
		
		while(true) {
				cardReceivedPlayers = receiveCardAllPlayers(sc, cardDeck, players);
				if(isAllPlayerTurnOff(cardReceivedPlayers))
					break;
			}
		return cardReceivedPlayers;
	}
	
	private boolean isAllPlayerTurnOff(List<Player> players) {
		for(Player player : players){
			if(player.isTurn()) {
				return false;
			}
		}
		return true;
	}
	
	private List<Player> receiveCardAllPlayers(Scanner sc, CardDeck cardDeck, List<Player> players) {
		for(Player player : players) {
			System.out.println(player.getName()+"님 차례입니다.");
			if(isReceiveCard(sc)) {
				Card card = cardDeck.draw();
				player.receiveCard(card);
				player.turnOn();
			}
			else
				player.turnOff();
		}
		return players;
	}
	
	private boolean isReceiveCard(Scanner sc) {
		System.out.println("카드를 뽑으시겠습니까? Stop은 그만을 입력하세요.");
		return !STOP_RECEIVE_CARD.equals(sc.nextLine());
	}
	
	
	private List<Player> initPhase(CardDeck carddeck, List<Player> players) {
		System.out.println("처음 2장의 카드를 각자 뽑겠습니다.");
		for(int i=0;i<INIT_RECEIVE_CARD_COUNT;i++) {
			for(Player player : players) {
				Card card = carddeck.draw();
				player.receiveCard(card);
			}
		}
		return players;
	}
}
