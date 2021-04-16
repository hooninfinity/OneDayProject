package com.callor.service;

import com.callor.word.model.WordVO;

public interface WordService {
	
	public void mainScreen();
	public void readFile();
	public void quizScreen();
	public WordVO getWord();
	public String[] wordShuffle(WordVO word);
	
	
}
