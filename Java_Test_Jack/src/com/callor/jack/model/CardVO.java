package com.callor.jack.model;

public class CardVO {
	
	private String pattern;
	private String denomination;
	private int point;
	
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "CardVO [pattern=" + pattern + ", denomination=" + denomination + ", point=" + point + "]";
	}
	
	

}
