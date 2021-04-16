package com.callor.word;

import com.callor.word.service.WordService;
import com.callor.word.service.impl.WordServiceImplV1;

public class WordEX_01 {
	
	public static void main(String[] args) {
		
		WordService wServiced = new WordServiceImplV1();
		wServiced.loadWord();
		wServiced.viewWord();
		wServiced.saveScore();
	
		
	}

}
