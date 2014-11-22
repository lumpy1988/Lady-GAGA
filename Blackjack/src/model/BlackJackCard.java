package model;

public class BlackJackCard extends Card implements Facing {
	
	private String cardImageLocation;
	private Face facing;
	
	public BlackJackCard(Suit s, int value) {
		super(s, value);
		cardImageLocation = CardImageLoader.getImageLocation(s, value);
	}
	
	public int value(){
		if(isAce()){
			return 1;
		}
		else if (faceValue >= 11 && faceValue <= 13) {
			return 10;
		}
		else {
			return faceValue;
		}
	}
		
	public int minValue(){
		if (isAce()){
			return 1;
		}
		else {
			return value();
		}
	}
	
	public int maxValue() {
		if (isAce()){
			return 11;
		}
		else {
			return value();
		}
	}
	
	public boolean isAce() {
		return faceValue == 1;
	}
	
	public boolean isFaceCard() {
		return faceValue >= 11 && faceValue <= 13;
	}

	@Override
	public void setFaceUp() {
		facing = Face.UP;
	}

	@Override
	public void setFaceDown() {
		facing = Face.DOWN;
	}

	public String getCardImageLocation() {
		return cardImageLocation;
	}

//	public void setCardImage(BufferedImage cardImage) {
//		this.cardImage = cardImage;
//	}

	public Face getFacing() {
		return facing;
	}

	public void setFacing(Face facing) {
		this.facing = facing;
	}
}
