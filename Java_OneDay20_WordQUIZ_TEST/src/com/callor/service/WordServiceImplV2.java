package com.callor.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.callor.word.model.WordVO;

public class WordServiceImplV2 implements WordService {

	protected List<WordVO> wordList; // 영어단어와 한글단어가 나뉘어서 담긴 리스트
	protected Scanner scan;
	protected Integer point;
	protected Integer endOrNot;
	protected String quizWord;

	public WordServiceImplV2() {
		wordList = new ArrayList<WordVO>();
		scan = new Scanner(System.in);
		endOrNot = 0;
		quizWord = null;
		readFile();
	}

	public void mainScreen() {
		// TODO 메인 화면
		while (true) {
			System.out.println("저장된 포인트를 불러오시겠습니까? (1.불러오기 2.불러오지않기)"); // 불러오기를 원하는지 물어보기
			String selectYN = scan.nextLine();
			if (selectYN.equals("")) {
				System.out.println("선 택 하 세 요");
				continue;
			}
			if (selectYN.equals("1")) { // 불러오기 선택했으면
				while (true) {
					loadFile();
				}
			} else if (selectYN.equals("2")) { // 불러오지 않기 선택했으면 point 0 으로 바로 시작
				point = 0;
				break;

			} else {
				System.out.println("1이나 2 중에 선택해주세요");
				continue;
			}
		}
		System.out.println("시작합니다 (POINT : " + point + ")");
		while (true) { // endOrNot이 0인 동안(QUIT를 입력 안 한 상태)에는 계속 quizScreen()이 실행돼서 새로운 퀴즈 내줌
			quizScreen();
			while (endOrNot == 1) { // endOrNot이 1이라면 QUIT를 입력한 거라서 이 반복문이 돌아감 // 현재 상태 저장 후 종료
				System.out.println("현재 포인트를 저장하시겠습니까? (1.저장 2.저장안함)");
				String save = scan.nextLine();
				if (save.equals("")) {
					System.out.println("입 력 하 세 요");
					continue;
				}
				if (save.equals("1")) {
					saveFile(); // 파일 저장 함수
				} else if (save.equals("2")) {
					System.out.println("## 게임 종료 ##");
					return;
				}
			}
		}
	}

	public void loadFile() {
		System.out.println("저장된 파일 이름을 입력하세요");
		System.out.println(">> ");
		String loadFileName = scan.nextLine();

		if (loadFileName.equals("")) {
			System.out.println("입 력 하 세 요");
			return;
		}

		FileReader fileReader = null;
		BufferedReader buffer = null;
		try {
			fileReader = new FileReader("src/com/callor/service/" + loadFileName + ".txt");
			buffer = new BufferedReader(fileReader);
			String strPoint = buffer.readLine(); // 파일에서 포인트 읽어오기
			point = Integer.valueOf(strPoint); // 포인트 Integer형으로 바꿔서 저장하기
			buffer.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일 여는 동안 문제 발생");
			return;
		} catch (IOException e) {
			System.out.println("파일의 데이터를 읽는 동안 문제 발생");
			return;
		}
	}

	public void saveFile() {
		System.out.println("저장할 파일 이름을 입력해주세요");

		String endFile = scan.nextLine();

		FileWriter fileWriter = null;
		PrintWriter out = null;
		try {
			fileWriter = new FileWriter("src/com/callor/service/" + endFile + ".txt");
			out = new PrintWriter(fileWriter);
			out.print(point);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void readFile() {
		String fileName = "src/com/callor/service/word.txt";
		FileReader fileReader = null;
		BufferedReader buffer = null;

		try {
			fileReader = new FileReader(fileName);
			buffer = new BufferedReader(fileReader);

			String reader;
			while ((reader = buffer.readLine()) != null) { // 파일 읽어서 ":"으로 영단어,한단어 분리하고 단어 한 쌍을 객체에 저장 후 리스트에 추가
				WordVO wordVO = new WordVO();
				String words[] = reader.split(":");
				wordVO.setEnglish(words[0]);
				wordVO.setKorea(words[1]);
				wordList.add(wordVO);
			}
			buffer.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일 여는 동안 문제 발생");
		} catch (IOException e) {
			System.out.println("파일의 데이터를 읽는 동안 문제 발생");
		}
	}

	public void quizScreen() {
		// TODO 게임 시작 후 보이는 화면
		WordVO word = new WordVO();
		word = getWord(); // getWord() 함수에서 단어 하나 리턴받음
		String[] alpha = wordShuffle(word);
		System.out.println("=".repeat(80));
		System.out.println("현재 포인트 : " + point);
		System.out.println("제시된 영단어를 바르게 배열하시오 ( QUIT : 게임 종료 )");
		System.out.println(Arrays.toString(alpha)); // 알파벳이 뒤섞인 단어 화면에 보여주기
		System.out.println("=".repeat(80));

		int more = 3; // 재도전 가능 횟수
		while (true) {
			System.out.print(">> "); // 답 입력하라는 프롬프트
			String input = scan.nextLine();
			if (input.equals("")) {
				System.out.println("입 력 하 세 요");
				continue;
			}
			if (input.equals("QUIT")) {
				endOrNot = 1;
				return;
			}

			if ((word.getEnglish()).equals(input)) { // 입력한 단어가 정답이라면 (둘 다 String이라 ==가 아닌 equals 씀)
				System.out.println("**	정 답 입 니 다	**");
				System.out.println("뜻 : " + word.getKorea()); // 한글 뜻 보여주기
				point += 100; // 100 포인트 주기
				System.out.println("+ 100포인트 획득");
				return;
			} else {
				System.out.println("* 땡 *");

				while (more > 0) { // 재도전 기회가 남아있는 동안은 계속 반복해서 기회 주어짐
					System.out.println("1 재도전 (남은 기회 " + more + "번, -10포인트)");
					System.out.println("2 힌트 (-20포인트)");
					System.out.println("3 PASS (-50포인트)");
					System.out.print(">> ");
					String select = scan.nextLine();
					if (select.equals("1")) { // 1(재도전)을 선택했으면
						point -= 10;
						more -= 1;
						System.out.println("답을 다시 입력하세요");
						break;
					}
					if (select.equals("2")) {
						if (point < 0) { // 포인트가 0 미만이라면 힌트 안 줌
							System.out.println("포인트가 0보다 적어 힌트를 볼 수 없습니다");
							continue;
						} else {
							point -= 20;
							more -= 1;
							System.out.println("[힌트] 뜻 : " + word.getKorea());
							break;
						}
					}
					if (select.equals("3")) {
						point -= 50;
						return;
					}
				}

				// 근데 재도전 가능 횟수가 없다면
				System.out.println("재도전 기회가 없습니다");
				System.out.println("다음 문제로 이동합니다 (포인트 -50)");
				point -= 50;
				return;
			}
		}
	}
	
	public void goodORbad() {
		
	}


	public WordVO getWord() {
		// TODO wordList에서 단어 하나 가져오는 메서드

		Random rnd = new Random();
		int ran = rnd.nextInt(wordList.size()); // wordList에서 몇번째 단어를 불러올 것인지 랜덤 숫자 생성

		WordVO word = new WordVO();
		word = wordList.get(ran); // 생성한 랜덤숫자번째의 단어 하나 가져옴

		return word; // 단어 하나 리턴
	}

	public String[] wordShuffle(WordVO word) {
		// TODO 단어 하나 뽑아와서 알파벳 섞는 메서드

		String[] alpha = word.getEnglish().split(""); // 알파벳으로 쪼개서 배열에 담기

		Random rnd = new Random();

		// 알파벳 위치 섞기 위한 반복문
		for (int i = 0; i < 100; i++) { // 100번 섞을거임
			int index1 = rnd.nextInt(alpha.length); // 0 ~ 단어의 알파벳 개수 사이의 숫자 랜덤으로 뽑기
			int index2 = rnd.nextInt(alpha.length); // index1 자리의 알파벳과 자리 바꿀 알파벳 자리 랜덤으로 뽑기
			String temp; // index1 자리 알파벳과 index2 자리 알파벳 서로 자리 바꾸기
			temp = alpha[index1];
			alpha[index1] = alpha[index2];
			alpha[index2] = temp;
		}
		return alpha;
	}

}
