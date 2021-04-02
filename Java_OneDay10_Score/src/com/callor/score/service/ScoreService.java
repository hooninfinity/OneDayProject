package com.callor.score.service;

import java.util.List;
import java.util.Scanner;

import com.callor.score.model.ScoreVO;

public class ScoreService {
	
	Scanner scan;
	List<ScoreVO> scoreList;
	
	
	public void MenuScore() {
		while(true) {
			System.out.println("=".repeat(50));
			System.out.println("빛고을 고등학교 성적처리 프로젝트 2021");
			System.out.println("=".repeat(50));
			System.out.println("1. 학생별 성적 입력");
			System.out.println("2. 학생 성적 리스트 출력");
			System.out.println("QUIT. 업무종료");
			System.out.println("=".repeat(50));
			System.out.print("업무선택 >> ");
			int intMenu = scan.nextInt();
			if (intMenu == 1) {
				
			}
		}
	}
	
	
	public void inputScore() {
		 
	}
	
	
	

}




