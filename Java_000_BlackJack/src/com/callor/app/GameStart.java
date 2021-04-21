package com.callor.app;

import java.util.List;

import com.callor.app.model.DeckVO;
import com.callor.app.service.DeckServiceV1;
import com.callor.app.service.PlayerService;

public class GameStart {
	
	public static void main(String[] args) {
		
		DeckServiceV1 dS = new DeckServiceV1();
		dS.makeDeck();
//		List<DeckVO> deckList = dS.getDeck();
//		
//		PlayerService 딜러 = new PlayerService(deckList);
//		PlayerService 게이머 = new PlayerService(deckList,"게이머");
//		
//		딜러.hit();
//		게이머.hit();
//		
//		딜러.hit();
//		게이머.hit();
//		
//		if(딜러.sumValue() < 17) 딜러.hit();
//		게이머.hit();
		
	}

}
