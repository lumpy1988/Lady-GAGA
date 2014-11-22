package model;

public enum Suit {
	HEART(0), CLUB(1), DIAMOND(2), SPADE(3);
	
	private int value;
	
	private Suit(int v){
		value = v;
	}

	public int getValue() {
		return value;
	}
	
	public static Suit getSuitFromValue(int value){
		switch(value) {
		case 0:	return HEART;
		case 1: return CLUB;
		case 2: return DIAMOND;
		case 3: return SPADE;
		default: return null;
		}
	}
}
