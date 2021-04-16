package com.callor.word.model;

public class WordVO {
	
	private String english;
	private String korean;
	private Integer count;
	
	
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getKorean() {
		return korean;
	}
	public void setKorean(String korean) {
		this.korean = korean;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "WordVO [영단어=" + english + ", 한글=" + korean + "]";
	}
	
	

}
