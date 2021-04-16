package com.callor.word.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.callor.word.model.WordVO;
import com.callor.word.service.WordService;

public class WordServiceImplV1 implements WordService {

	protected List<WordVO> wordList;
	protected Scanner scan;
	protected Integer count;

	protected final int 영어 = 0;
	protected final int 한글 = 1;

	public WordServiceImplV1() {
		wordList = new ArrayList<WordVO>();
		scan = new Scanner(System.in);
	}

	@Override
	public void loadWord() {
		// TODO word.txt 파일을 읽어서 wordList 만들기
		String fileName = "src/com/callor/word/word.txt";
		// FileReader와 BufferedReader를 사용해 파일을 읽어온다
		FileReader fileReader = null;
		BufferedReader buffer = null; // 빨간줄이 뜨면 예외처리 한다

		try {
			fileReader = new FileReader(fileName);
			buffer = new BufferedReader(fileReader);
			// 유효성검사 필요(무조건 while로 시작)
			while (true) {
				// 파일을 무조건 한 라인씩 읽어라
				String reader = buffer.readLine();
				// 파일로부터 읽을 값이 null(더이상 없다면)이면 멈춘다
				if (reader == null)
					break;

				// 배열을 사용해 한라인씩 읽은 자료를 ":"을 기준으로 쪼갠다
				String words[] = reader.split(":");

				// 쪼갠 단어들을 WordVO에 담아준다
				WordVO wordVO = new WordVO();
//				wordVO.setEnglish(words[0]);
//				wordVO.setKorean(words[1]);
				// 배열의 번호를 넣어도 되지만 가독성을 위해
				wordVO.setEnglish(words[영어]);
				wordVO.setKorean(words[한글]);
				// VO에 셋팅한 자료들을 리스트에 추가한다
				wordList.add(wordVO);
			}
			// buffer를 사용하면 꼭 close() 해준다
			buffer.close();

			// wordList에 잘 담겼는지 .toString()으로 테스트 할 수 있다
//			System.out.println(wordList.toString());
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다!!");
		} catch (IOException e) {
			System.out.println("파일을 읽어오는데 오류가 발생했습니다!!");
		}
	}

	protected WordVO getWord() {
		// TODO wordList에 담긴 데이터중 임의 데이터 1개를 추출하여 보여주기
		Random rnd = new Random();

		// wordList의 총 길이를 nSize로 생성
		int nSize = wordList.size();
		int num = rnd.nextInt(nSize); // 0 ~ (nSize-1) 의 길이중에 하나를 랜덤수로 num에 생성

		// 이제 리스트에 담긴 데이터중 랜덤수에 해당하는 번지수의 값을 가져와 wordVO에 담고
		WordVO wordVO = wordList.get(num);

		// 가져온 값을 리턴해서 보내준다
		return wordVO;
	}

	@Override
	public void viewWord() {
		// TODO 추출된 데이터와 입력하는 값이 일치해야 하는 문제 만들기
		Random rnd = new Random();

		while (true) {

			// getWord()로 추출된 랜덤한 라인을 word에 담고
			WordVO word = this.getWord();

			// 그 라인중 english에 해당하는 부분을 strEng에 담는다(이미 배열[0]번으로 wordVO.setEnglish를 셋팅했었다. ":"
			// 를 기준으로 쪼개져있음)
			String strEng = word.getEnglish();

			// strEng를 스펠링 하나하나씩 쪼개서 배열에 담는다
			String[] strWords = strEng.split("");

			// 랜덤을 사용하여 100회 앞뒤로 섞어준다
			for (int i = 0; i < 100; i++) {

				int index1 = rnd.nextInt(strWords.length); // strWords의 길이 중에 랜덤한 스펠링 하나를 indext1 번에
				int index2 = rnd.nextInt(strWords.length); // strWords의 길이 중에 랜덤한 스펠링 하나를 indext2 번에

				String temp = strWords[index1]; // temp 에 index1을 옮겨놓고(복사)
				strWords[index1] = strWords[index2]; // 2번을 1번자리에 담는다
				strWords[index2] = temp; // temp(현재 1) 값을 2번에 담으면 결국 index1과 index2가 서로 바뀐 셈
			}

			// 스펠링도 섞어줬으니 이제 단어문제를 출력해보자
			System.out.println("-".repeat(50));
			System.out.println(word.toString()); // getWord()로 가져온 라인(word)을 .toStrint()으로 정답확인용으로 출력
			System.out.println("=".repeat(50));
			System.out.println("제시된 영 단어를 바르게 배열하시오(qUIT: 게임종료)");
			System.out.println(Arrays.toString(strWords)); // 배열의 내용 출력하기 => Arrays.toString(내용)
			System.out.println("=".repeat(50));
			System.out.print(">> ");
			String strInput = scan.nextLine(); // 문자열을 입력받아

			if (strInput.equals("qUIT")) {
				System.out.println("오늘은 여기까지 ~~~ 퇴근하세요!!");
				break;
			}
			// 입력받은 문자열이 word.getEnglish() (배열 0 번) 에 담긴 것과 같은지 조건문을 통해 확인,
			// equalsIgnoreCase는 대소문자 가리지 않고 같은지 비교한다.
			else if (strInput.equalsIgnoreCase(word.getEnglish())) {
				System.out.println("정답입니다!!");
				System.out.println("뜻 : " + word.getKorean());
				System.out.println("현재 점수 : " + count);
			} else {
				
				for (int i = 0; i < 3; i++) {
					
					System.out.println("재도전하시겠습니까? : YES 또는 NO 입력");
					System.out.println("건너뛰기 : 1");
					System.out.print(">> ");
					String retry = scan.nextLine();
					if (retry.equals("YES")) {
						count--;
					}
					if (count < 0) {
						System.out.println("더이상의 포인트가 없습니다!!");
						break;
					}
					if (retry.equals("NO")) {
						break;
					}
					if (retry.equals("1")) {
						count--;
						this.viewWord();
					}
					
					System.out.println("재도전하기 전에 힌트를 보시겠습니까? 1:예 2:아니오");
					String hint = scan.nextLine();
					if (hint.equals("1")) {
						count--;
						System.out.println("힌트 : " + word.getKorean());
					} else if(hint.equals("2")) {
						System.out.println("힌트를 보지 않기를 선택하셨습니다");
						System.out.println("다시 입력해주세요");
					}
					
					System.out.print(">> ");
					String restart = scan.nextLine();
					if (restart.equalsIgnoreCase(word.getEnglish())) {
						System.out.println("정답입니다");
						break;
					} else {
						System.out.println("오답입니다");
					}
				} // end for()
				System.out.println("현재 점수 : " + count);
				continue;
			}

			System.out.println("=".repeat(50));
			System.out.println();
		} // end while
	} // end viewWord

	
	@Override
	public void saveScore() {
		// TODO 점수를 저장할 method
		String fileName = null;
		while(true) {
			System.out.println("저장할 파일 이름을 입력하세요");
			System.out.print(">> ");
			fileName = scan.nextLine();
			if (fileName.equals("")) {
				System.out.println("파일이름은 반드시 입력해야 합니다");
				continue;
			}
			break;
		}
		
		String strFileName = "src/com/callor/word/" + fileName;
		
		FileWriter fileWriter = null;
		PrintWriter out = null;
		
		try {
			fileWriter = new FileWriter(strFileName);
			out = new PrintWriter(fileWriter);
			out.print(count);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	

}




