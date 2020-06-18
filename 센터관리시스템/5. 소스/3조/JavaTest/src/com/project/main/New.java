package com.project.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// 회원가입
public class New {
	public void ne() throws Exception {
		// 파일 선언
		File file = new File("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\수강생.txt");
		File file2 = new File("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\로그인 학생.txt");
		File file3 = new File("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\강사.txt");
		File file4 = new File("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\로그인 강사.txt");
		//버퍼라이터 선언
		BufferedWriter stream = new BufferedWriter(new FileWriter(file,true));
		BufferedWriter stream2 = new BufferedWriter(new FileWriter(file2,true));
		BufferedWriter stream3 = new BufferedWriter(new FileWriter(file3,true));	//교사정보
		BufferedWriter stream4 = new BufferedWriter(new FileWriter(file4,true));	//교사 id, pw
		// 스캐너 선언
		Scanner scan = new Scanner(System.in);
		// 반복문 제어
		boolean re = true;
		//학생 수 제어
		int count_s = 301;
		//교사 수 제어
		int count_l = 11;
		
		Login_Main lm = new Login_Main();
		
		while(re) {
		// 출력 되는 부분
		System.out.println("□□□□□□□□□□□□□□□");
		System.out.println("회원가입");
		System.out.println("1. 강사 회원 가입");
		System.out.println("2. 수강생 회원 가입");
		System.out.println("3. 종료");
		System.out.println("□□□□□□□□□□□□□□□");
		System.out.print("선택(번호) : ");
		// 번호 입력 받음
		String input = scan.nextLine();
		System.out.println("□□□□□□□□□□□□□□□");
		// 유효성 검사
		if(input.equals("1")||input.equals("2")||input.equals("3")) {
			//1번 선택시
			if(input.equals("1")) {
				System.out.println();
				System.out.println("------------------");
				System.out.print("아이디를 입력해주세요 : ");
				String q1 = scan.nextLine();
				System.out.print("비밀번호를 입력해주세요 : ");
				String q2 = scan.nextLine();
				System.out.println("------------------");
				//아이디에 lect필수
				if(q1.contains("lect")) {
					System.out.println("아이디 생성에 성공하였습니다.");
					System.out.println("강사 정보를 입력해주세요.");
					System.out.println("------------------");
					System.out.print("이름 : ");
					String q3 = scan.nextLine();
					System.out.print("나이 : ");
					String q4 = scan.nextLine();
					System.out.print("성별(남자 : 1, 여자 : 2) : ");
					String q5 = scan.nextLine();
					System.out.print("전화번호 : ");
					String q6 = scan.nextLine();
					System.out.print("주소 : ");
					String q7 = scan.nextLine();
					
					
					//파일에 교사정보 입력
					stream3.write(count_l+q3+","+q4+","+q5+","+q6+","+q7+"0,X,X,X,0,없음");
					//파일에 교사 로그인 정보 입력
					stream4.write(q1+","+q2);
					//파일 줄바꿈
					stream3.newLine();
					stream4.newLine();
					//스트림 닫기
					stream3.close();
					stream4.close();
					
					count_l++;
					
					System.out.println("회원가입에 성공했습니다.");			
					restart(scan);
					lm.login();
					
				}else if(input.equals("")) {
					System.out.println("아무것도 입력하지 않으셨습니다.");
					restart(scan);
				}
				else{
					System.out.println("유효하지 않은 아이디를 입력하셨습니다.");
					restart(scan);
				}
			// 2번 선택시	
			
		}else if(input.equals("2")) {
			System.out.println("------------------");
			System.out.print("아이디를 입력해주세요 : ");
			String q1 = scan.nextLine();
			System.out.print("비밀번호를 입력해주세요 : ");
			String q2 = scan.nextLine();
			System.out.println("------------------");
//			아이디에 stu필수
			if(q1.contains("stu")) {
				System.out.println("아이디 생성에 성공하였습니다.");
				System.out.println("학생 정보를 입력해주세요.");
				System.out.println("------------------");
				System.out.print("이름 : ");
				String q3 = scan.nextLine();
				System.out.print("나이 : ");
				String q4 = scan.nextLine();
				System.out.print("성별(남자 : 1, 여자 : 2) : ");
				String q5 = scan.nextLine();
				System.out.print("전화번호(-)입력 포함 : ");
				String q6 = scan.nextLine();
				System.out.print("주소 : ");
				String q7 = scan.nextLine();
				
				
				//파일에 학생정보 입력
				stream.write(count_s+q3+","+q4+","+q5+","+q6+","+q7+"0,X,X,X,0,없음");
				//파일에 학생 로그인 정보 입력
				stream2.write(q1+","+q2);
				//파일 줄바꿈
				stream.newLine();
				stream2.newLine();
				//스트림 닫기
				stream.close();
				stream2.close();
				
				System.out.println("회원가입에 성공했습니다.");
				restart(scan);
				
				count_s++;
										
				lm.login();//로그인 메인 화면으로 돌아가기
				
			}else if(input.equals("")) {
				System.out.println("아무것도 입력하지 않으셨습니다.");
				restart(scan);
			}
			else{
				System.out.println("유효하지 않은 아이디를 입력하셨습니다.");
				restart(scan);
			}
			
		}else if(input.equals("3")) {
			System.out.println("종료 합니다.");
			//아직 구현 안됨
			break;
		}
	}else if(input.equals("")) {
			System.out.println("아무것도 입력하지 않으셨습니다.");
			restart(scan);
		}else {
			System.out.println("목록에 없는 항목을 입력하셨습니다.");
			restart(scan);
		}
		}
	}
	//엔터 입력시 계속..
	private void restart(Scanner scan) {
		System.out.println("------------------");
		System.out.println("계속하시려면 엔터를 눌러주세요.");
		System.out.println("------------------");
		
		// 엔터 입력 
		String enter = scan.nextLine();
		
		
	}
}
