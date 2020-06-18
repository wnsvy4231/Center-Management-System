package com.project.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.project.admin.Admin;
import com.project.guest.Guest_Menu;
import com.project.student.Student_menu;
import com.project.teacher.Teacher_Login;

// 로그인
public class Login {
	static int stdNum;
	 static {
		
	}
	public void rogin() throws Exception{
		//ArrayList 선언(텍스트 파일 한줄씩 입력 받을)
		ArrayList<String> list =new ArrayList<String>();
				
		// 더미 데이터 불러오기
		try {
		//파일 객체 생성
			
		File file = new File ("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\로그인 강사.txt"); // 로그인 강사 더미파일 경로
		//입력 스트림 생성
		FileReader filereader = new FileReader(file);			
		//입력 버퍼 생성
		 BufferedReader read = new BufferedReader(filereader);
		 String text ="";
		//더미 데이터 요소가 있을때까지 while 
		while((text  = read.readLine())!=null) {
     	//list에 더미데이터 한줄씩 추가함 while 끝날동안 반복		
		 list.add(text);
		}
		} catch (Exception e1) {
		System.out.println("더미 파일 경로에서 오류");
			 			}
		
		//ArrayList 선언(더미데이터에서 필요한 요소만 받을)
		//id 받기
		 ArrayList<String> listsort1_id = new ArrayList<String>();
		 for(int i=0; i<list.size(); i++) {
				 String temp[] = list.get(i).split(",");
				listsort1_id.add(temp[0]);
		 }
		 //pw받기
		 ArrayList<String> listsort1_pw = new ArrayList<String>();
		 for(int i=0; i<list.size(); i++) {
				 String temp[] = list.get(i).split(",");
				listsort1_pw.add(temp[1]);
		 }
		 //------------------------------------------------------
		//ArrayList 선언(텍스트 파일 한줄씩 입력 받을)
			ArrayList<String> list2 =new ArrayList<String>();
					
			// 더미 데이터 불러오기
			try {
			//파일 객체 생성
				
			File file = new File ("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\로그인 학생.txt"); // 로그인 학생 더미파일 경로
			//입력 스트림 생성
			FileReader filereader = new FileReader(file);			
			//입력 버퍼 생성
			 BufferedReader read = new BufferedReader(filereader);
			 String text ="";
			//더미 데이터 요소가 있을때까지 while 
			while((text  = read.readLine())!=null) {
	     	//list에 더미데이터 한줄씩 추가함 while 끝날동안 반복		
			 list2.add(text);
			}
			} catch (Exception e1) {
			System.out.println("더미 파일 경로에서 오류");
				 			}
			
			//ArrayList 선언(더미데이터에서 필요한 요소만 받을)
			 ArrayList<String> listsort2_id = new ArrayList<String>();
			 for(int i=0; i<list2.size(); i++) {
					 String temp[] = list2.get(i).split(",");
					listsort2_id.add(temp[0]);
			 }
			 ArrayList<String> listsort2_pw = new ArrayList<String>();
			 for(int i=0; i<list2.size(); i++) {
					 String temp[] = list2.get(i).split(",");
					listsort2_pw.add(temp[1]);
			 }
			
		 //-----------------------------------------------------------------------------
		 
		 
		 
		// 스캐너 선언
		Scanner scan = new Scanner(System.in);
		// 반복문 제어
		boolean re = true;
		while(re) {
		// 출력 되는 부분
		System.out.println("□□□□□□□□□□□□□□□");
		System.out.println("센터 관리 시스템");
		System.out.println("1. 관리자 로그인");
		System.out.println("2. 교/강사 로그인");
		System.out.println("3. 학생 로그인");
		System.out.println("4. 비회원 로그인");
		System.out.println("5. 회원가입");
		System.out.println("6. 종료");
		System.out.println("□□□□□□□□□□□□□□□");
		System.out.print("선택(번호) : ");
		// 번호 입력 받음
		String input = scan.nextLine();
		System.out.println("□□□□□□□□□□□□□□□");
		// 번호 유효성
		if(input.equals("1")||input.equals("2")||input.equals("3")||input.equals("4")||input.equals("5")||input.equals("6")) {
			// 1번 선택시
			if(input.equals("1")) {
				//관리자 아이디 : admin1234
				//관리자 비밀번호 : 1234
				System.out.print("아이디 : ");
				String id = scan.nextLine(); 
				System.out.print("비밀번호 : ");
				String pw = scan.nextLine();
				//아이디가 틀렸을 경우
				if(!id.equals("admin1234")) {
					System.out.println("일치하는 아이디가 없습니다.");
					restart(scan);
				//비밀번호가 틀렸을 경우
				}else if(!pw.equals("1234")) {
					System.out.println("비밀번호가 틀렸습니다.");
					restart(scan);
				//로그인에 성공했을경우
				}else if(id.equals("admin1234")&&pw.equals("1234")) {
					System.out.println("관리자 로그인에 성공했습니다.");
					//관리자 시스템 이동
					Admin admin = new Admin();
					admin.main();
				}
			// 2번 선택시	
			}else if(input.equals("2")) {
				//강사 아이디 : lect1 ~ lect10
				//강사 비밀번호 : 0000
				System.out.print("아이디 : ");
				String id = scan.nextLine(); 
				System.out.print("비밀번호 : ");
				String pw = scan.nextLine();
				System.out.println();
				int t = 0;
				int p = 0;
				
				for(int i=0; i<listsort1_id.size();i++) {
					if(listsort1_id.get(i).equals(id)) {
					t++;
					for(int j = 0; j<listsort1_pw.size(); j++) {
						if(listsort1_pw.get(i).equals(pw)) {
						p++;
						break;
							}	
						}	
					}
				}
				
				
				//아이디가 틀렸을 경우
				if(t==0) {
					System.out.println("일치하는 아이디가 없습니다.");
					restart(scan);
				//비밀번호가 틀렸을 경우
				}else if(p == 0) {
					System.out.println("비밀번호가 틀렸습니다.");
					restart(scan);
				//로그인에 성공했을경우
				}else if((t==1)&&(p==1)) {
					
					System.out.println("강사 로그인에 성공했습니다.");
					//강사 시스템 이동
//					Teacher_Login teacher = new Teacher_Login();
					//Teacher_Login.teacher();
				}
				//3번 선택시
			}else if(input.equals("3")) {
				//학생 아이디 : stu1 ~ stu300
				//학생 비밀번호 : 0000
				System.out.print("아이디 : ");
				String id = scan.nextLine(); 
				System.out.print("비밀번호 : ");
				String pw = scan.nextLine();
				System.out.println();
				int t = 0;
				int p = 0;
				
				//아이디가 틀렸을 경우
				for(int i=0; i<listsort2_id.size();i++) {
					if(listsort2_id.get(i).equals(id)) {
					t++;
					stdNum = i;
					for(int j = 0; j<listsort2_pw.size();j++) {
						if(listsort2_pw.get(i).equals(pw)) {
						p++;
						break;
							}	
						}
					}	
				}
				
				if(t==0) {
//					System.out.println("일치하는 아이디가 없습니다.");
					System.out.println("아이디 틀립니다.");
					restart(scan);
				
				}
				//비밀번호가 틀렸을 경우
				if(p ==0) {
					System.out.println("일치하는 비밀번호가 없습니다.");
				}

				else if((t==1)&&(p==1)) {
					System.out.println("학생 로그인에 성공했습니다.");
					Student_menu student = new Student_menu();
					student.main();
				}
				
			}else if(input.equals("4")) {
				System.out.println("비회원으로 접속합니다.");
				//기능 구현 안됨
				//구현 여기에 추가
				Guest_Menu guest = new Guest_Menu();
				guest.main();
			} else if (input.equals("5")) {
				New a = new New();
				a.ne();
			} else if(input.equals("6")) {
				System.out.println("종료합니다.");
				System.exit(0);
			}
		// 1, 2, 3, 4가 아닌 다른 값을 입력했을떄
		}else{
			System.out.println("목록에 없는 항목을 입력하셨습니다.");
			restart(scan);
		} 
		}// 반복문 끝
		
	}

	private void restart(Scanner scan) {
		
		System.out.println("계속 하시려면 엔터를 누르세요.");
		System.out.println("□□□□□□□□□□□□□□□");
		String enter = scan.nextLine();
	}
}
