package com.callor.score.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.score.model.ScoreVO;

public class ScoreService {
	
	Scanner scan;
	List<ScoreVO> scoreList;
	
	public ScoreService() {
		scan = new Scanner(System.in);
		scoreList = new ArrayList<ScoreVO>();
	}
	
	public void selectMenu() {
		while(true) {
			System.out.println("=".repeat(50));
			System.out.println("빛고을 고등학교 성적처리 프로젝트 2021");
			System.out.println("=".repeat(50));
			System.out.println("1. 학생별 성적 입력");
			System.out.println("2. 학생 성적 리스트 출력");
			System.out.println("QUIT. 업무종료");
			System.out.println("=".repeat(50));
			System.out.print("업무선택 >> ");
			String strMenu = scan.nextLine();
			int intNum;
			if (strMenu.equals("1")) {
				intNum = Integer.valueOf(strMenu);
				this.inputName();
				this.inputScore();
			} else if(strMenu.equals("2")) {
				this.printList();
			} else if(strMenu.equals("QUIT")) {
				System.out.println("업무를 종료합니다");
				break;
			} else {
				System.out.println("다시 입력하세요!!");
				continue;
			}
		}
	}
	
	// 학생 이름과 점수 입력
	public void inputName() {
		while(true) {
			ScoreVO scoreVO;
			scoreVO = new ScoreVO();
			System.out.println("=".repeat(50));
			System.out.println("학생이름을 입력하세요(입력을 중단하려면 QUIT)");
			System.out.println("=".repeat(50));
			System.out.print("이름 >> ");
			String name = scan.nextLine();
			if (name.equals("QUIT")) {
				break;
			} else {
				scoreVO.setName(name);
			}
			break;
		}
	}
	
	// 성적 입력
	public void inputScore() {
			ScoreVO scoreVO;
			scoreVO = new ScoreVO();
			System.out.println("=".repeat(50));
			System.out.println("학생이름의 성적을 입력하세요(성적범위 : 0 ~ 100, 입력을 중단하려면 QUIT");
			System.out.println("=".repeat(50));
			System.out.print("국어 >> ");
			String kor = scan.nextLine();
			Integer intKor = Integer.valueOf(kor);
			
			System.out.print("영어 >> ");
			String eng = scan.nextLine();
			Integer intEng = Integer.valueOf(eng);
			System.out.print("수학 >> ");
			String math = scan.nextLine();
			Integer intMath = Integer.valueOf(math);
			System.out.print("과학 >> ");
			String sci = scan.nextLine();
			Integer intSci = Integer.valueOf(sci);
			System.out.print("국사 >> ");
			String his = scan.nextLine();
			Integer intHis = Integer.valueOf(his);
			
			scoreVO.setIntKor(intKor);
			scoreVO.setIntEng(intEng);
			scoreVO.setIntMath(intMath);
			scoreVO.setIntSci(intSci);
			scoreVO.setIntHis(intHis);
			scoreVO.setIntTotal(intKor+intEng+intMath+intSci+intHis);
			scoreList.add(scoreVO);
			
			System.out.println("=".repeat(50));
			System.out.println(scoreVO.getName() + " 학생의 성적이 추가되었습니다");
			System.out.println("=".repeat(50));
			System.out.println("국어 : " + intKor);
			System.out.println("영어 : " + intEng);
			System.out.println("수학 : " + intMath);
			System.out.println("과학 : " + intSci);
			System.out.println("국사 : " + intHis);
			
		
//		Integer intKor = 0;
//		try {
//			intKor = Integer.valueOf(kor);
//		} catch (Exception e) {
//			System.out.println("값은 정수형 숫자로만 입력하세요");
//			continue;
//		}
//		if (intKor > 0 && intKor < 100) {
//			ScoreVO scoreVO = new ScoreVO();
//			scoreVO.setIntKor(intKor);
//			break;
//		} else {
//			System.out.println("성적은 0 ~ 100 범위에서 입력!!");
//		}
	}
	
	
	// 리스트 출력
	public void printList() {
		System.out.println("=".repeat(50));
		System.out.println("순번\t국어\t영어\t수학\t과학\t국사\t총점\t평균\n");
		for(int i = 0 ; i < scoreList.size() ; i++) {
			ScoreVO scoreVO = scoreList.get(i);
			System.out.print(scoreVO.getName() + "\t");
			System.out.print(scoreVO.getIntKor() + "\t");
			System.out.print(scoreVO.getIntEng() + "\t");
			System.out.print(scoreVO.getIntMath() + "\t");
			System.out.print(scoreVO.getIntSci() + "\t");
			System.out.print(scoreVO.getIntHis() + "\t");
			System.out.println(scoreVO.getIntTotal() + "\t");
			
		}
	}
	

}




