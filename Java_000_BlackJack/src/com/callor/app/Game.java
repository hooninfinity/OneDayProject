package com.callor.app;

import com.callor.app.service.DeckServiceV1;

public class Game {
	
	public static void main(String[] args) {
		
		DeckServiceV1 dService = new DeckServiceV1();
		dService.makeDeck();
		
	}

}
