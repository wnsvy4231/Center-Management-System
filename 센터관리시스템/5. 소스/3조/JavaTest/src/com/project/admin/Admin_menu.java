package com.project.admin;

import java.util.Scanner;

public class Admin_menu {
	
	private static Scanner scan;
	
	static {
		scan = new Scanner(System.in);		
	}
	
	public void menu() throws Exception {
		
		System.out.println("□□□□□□□□□□□□□□□");
		System.out.println("admin1234님 어서오세요");
		System.out.println("1. 수업관리");
		System.out.println("2. 강사관리");
		System.out.println("3. 수강생 관리");
		System.out.println("4. 기자재 관리");
		System.out.println("5. 1:1 문의");
		System.out.println("6. 로그아웃");
		System.out.println("□□□□□□□□□□□□□□□");
		System.out.print("선택(번호) : ");
	
		String sel = scan.nextLine();
		
		if(sel.equals("1")) {
			//수업
			Admin_Subject sub = new Admin_Subject();
			sub.Subject();
		}else if(sel.equals("2")) {
			//강사
			boolean loop = true;
			
			while(loop) {
			Admin_Lecture lec = new Admin_Lecture();
			lec.menu();
			System.out.print("선택(번호) : ");
			sel = scan.nextLine();
			if (sel.equals("1")) {
				lec.list();
			} else if (sel.equals("2")) {
				lec.add();
			} else if (sel.equals("3")) {
				lec.correct();
			} else if (sel.equals("4")) {
				lec.delete();
			} else if (sel.equals("5")) {
				lec.search();
			} else if (sel.equals("6")) {
				lec.search2();
			} else if (sel.equals("7")) {
				lec.search3();
			} else if (sel.equals("8")) {
				loop = false;
			}else {
				pause(scan);
			}
		}//while
			
		}else if(sel.equals("3")) {
			//수강생
			Admin_Student std = new Admin_Student();
			std.studentData();
		}else if(sel.equals("4")) {
			//기자재
			Itemthis item = new Itemthis();
			item.item();
		}else if(sel.equals("5")) {
			//1:1문의
			Admin_Consult_Test consult = new Admin_Consult_Test();
			consult.consult();
		}else if(sel.equals("6")) {
			// 로그아웃
			Logout();
		} else {
			pause(scan);
		}
			
	}//menu
	
	private static void pause(Scanner scan) {
		
		System.out.println();
		System.out.println("잘못 입력했습니다.");
		System.out.println("계속하실려면 엔터를 입력하세요.");
		
		scan.nextLine();
		
	}//pause
	
	private static void Logout() {
		System.out.println("로그아웃하였습니다.");
	}

}//Admin