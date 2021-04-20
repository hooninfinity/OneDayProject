package com.callor.blackjack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.callor.blackjack.model.CardVO;

public class Card {

	private List<CardVO> cardList;
	private Random rnd;
	private String[] pattern;
	private String[] cardNumber;

	public Card() {
		cardList = new ArrayList<CardVO>();
		rnd = new Random();
		pattern = new String[] { "♠", "◆", "♥", "♣" };
		cardNumber = new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K" };
	}

	public void makeCard() {
		CardVO cardVO = new CardVO();
		// 카드 모양이랑 번호 돌려서 저장
		for (int i = 0; i < pattern.length; i++) {
			for (int j = 0; j < cardNumber.length; j++) {
				cardVO.setPattern(pattern[i]);
				cardVO.setCardNumber(cardNumber[i]);
				cardList.add(cardVO);
			}
		}
		//AJQK 숫자로 변환해주기
		for (int i = 0; i < cardList.size(); i++) {
			CardVO cdVO = cardList.get(i);
			Integer num=null;
			num=Integer.valueOf(cdVO.getCardNumber());
			if(num.equals("A")) {
				num=1;
			}if(num.equals("J")) {
				num=10;
			}if(num.equals("Q")) {
				num=10;
			}if(num.equals("K")) {
				num=10;
			}//잠옴 수정해야함ㅇㅇ
			cdVO.setNumber(num);
		}

	}
}