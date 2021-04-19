package call.callor.blackjack;

import java.util.List;

import call.callor.blackjack.model.DeckVO;
import call.callor.blackjack.service.DeckService_01;

public class BlackJackEx_01 {
	
	public static void main(String[] args) {
		
		DeckService_01 dService = new DeckService_01();
		dService.makeDeck();
		
		// getDeck을 사용하여 리스트를 가져온다 
		List<DeckVO> deckList = dService.getDeck();
		for(DeckVO vo : deckList) {
			System.out.println(vo);
		}
		
		
	}

}
