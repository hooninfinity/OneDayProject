package call.callor.blackjack.service;
/*
 * 한벌의 카드를 생성하고 저장할 클래스
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import call.callor.blackjack.model.DeckVO;

public class DeckService_01 {
	// 생성된 카드를 저장할 리스트
	List<DeckVO> deckList;
	// suits(무늬) : 다이아몬트, 하트, 스페이드, 클럽
	String suit = "다이아몬드(◆), 하트(♥), 스페이드(♠), 클로버(♣)";
	String[] arrSuit = new String[] {"다이아몬드(◆), 하트(♥), 스페이스(♠), 클로버(♣)"};
	/// denomination(카드 숫자) :  2, 3, 4, 5, 6, 7, 8, 9, 10, A(1), K(10), J(10), Q(10)
	String denomination = "A234567890KJQ";
	
	public DeckService_01() {
		// TODO deckList 생성
		this.deckList = new ArrayList<DeckVO>();
	}
	
	// 리스트를 만들어서 외부에서 가져갈 수 있도록
	public List<DeckVO> getDeck(){
		int nSize = deckList.size();
		for(int i = 0 ; i < nSize ; i++) {
			Collections.shuffle(this.deckList);
		}
//		for(DeckVO vo : deckList) {
//			Collections.shuffle(this.deckList);
//		} 
		return this.deckList;
	}
	
	
	
	public void makeDeck() {
		// TODO 카드를 생성하는 method
		String[] denoms = denomination.split(""); // 카드숫자를 쪼개서 배열로 생성
		
		for(String suit : arrSuit) {
			for(String denom : denoms ) {
				// 각 무늬가 한번 실행될때 카드숫자를 하나씩 무늬에 넣는다
				// 무늬와 카드 숫자를 조합한 값의 변수 value 사용
				// 2~9까지는 그대로, A는 1로, JQK는 10으로
				int intValue = 0;
				try {
					intValue = Integer.valueOf(denom); // 2 ~ 9 까지의 값이 입력되었을때
					if(intValue == 0) {
						intValue = 10;
					}
				} catch (Exception e) {
					if (denom.equals("A")) {
						intValue = 1;
					} else {
						intValue = 10;
					}
					DeckVO deckVO = new DeckVO();
					deckVO.setSuit(suit);
					deckVO.setDenomination(denom);
					deckVO.setValue(intValue);
					deckList.add(deckVO);
				}
			}
		}
		
	} // end makeDeck()
	

}
