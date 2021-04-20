package com.callor.blackjack.model;

public class CardVO {
	
	private String pattern;//카드모양
	private String cardNumber;//카드에 써진숫자
	private Integer number;//카드에써진 숫자 정수형변환	
	
	
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
}