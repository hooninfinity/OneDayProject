package com.callor.blackjack;

public interface Player {
	
	void getCard(Card card);
	void printCards();
	int getSum();
	String getName(); 

}