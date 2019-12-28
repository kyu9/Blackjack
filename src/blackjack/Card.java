package blackjack;

public class Card {
	private String pattern;
	private String denomination;
	private int point;
	
	
	public Card (String pattern, int point){
		this.pattern=pattern;
		this.denomination=this.numberToDenomination(point);
		this.point=this.numberToPoint(point);
	}
	
	private int numberToPoint(int number) {
		if(number>=11)
			return 10;
		return number;
	}
	
	private String numberToDenomination(int i) {
		if(i==1)
			return "A";
		else if(i==11)
			return "J";
		else if(i==12)
			return "Q";
		else if(i==13)
			return "K";
		else
			return String.valueOf(i);
	}
	
	public String getPattern() {
		return pattern;
	}
	
	public void setPattern(String pattern) {
		this.pattern=pattern;
	}
	
	public String getDenomination() {
		return denomination;
	}
	
	public void setDenomination(String denomination) {
		this.denomination=denomination;
	}
	
	public int getPoint() {
		return point;
	}
	
	public void setPoint(int point) {
		this.point = point;
	}
	
	public String toString() {
		return "Card{ pattern = "+pattern+", denomination = "+denomination+"}";
	}

}
