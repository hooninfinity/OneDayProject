package call.callor.blackjack.model;
/*
 * 덱 한벌 이 총 52장
 * 딜러와 게이머 2명
 * 2~10은 숫자 그대로의 점수, A는 1점, J,K,Q은 10점으로 계산
 * 딜러와 게이머는 순차적으로 카드를 하나씩 뽑아 각자 2개 소지, 게이머는 추가로 뽑기 가능
 * 딜러는 2카드의 합이 16점 이하이면 반드시 1장을 추가로, 17점 이상이면 불가
 * 양쪽 모두 추가 뽑기 없이, 카드 오픈하면 소유한 카드의 합이 21점에 가까운 쪽이 승리
 * 21을 초과하면 초과한 쪽이 게임에서 진다
 * 
 * suits(무늬) : 다이아몬트, 하트, 스페이드, 클럽
 * denomination(카드 숫자) :  2, 3, 4, 5, 6, 7, 8, 9, 10, A(1), K(10), J(10), Q(10)
 */
public class DeckVO {
	
	private String suit; // 무늬
	private String denomination; // 카드 숫자
	private int value; // 무늬와 카드 숫자를 조합한 값
	
	
	
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "DeckVO [suit=" + suit + ", denomination=" + denomination + ", value=" + value + "]";
	}
	
	
	

	
	
	
	
	

}
