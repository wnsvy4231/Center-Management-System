package com.project.teacher;

import java.util.Scanner;

public class Teacher_Login {
	
	private static Scanner scan;
	
	static {
		scan = new Scanner(System.in);
	}
	public static void teacher(String id) {
		
		System.out.println("----------------------");
		System.out.println("1. 회원 정보");
		System.out.println("2. 수강생 관리");
		System.out.println("3. 수업 자료 업로드");
		System.out.println("4. 로그아웃");
		System.out.println("----------------------");
		pause(scan);
		
		System.out.print("선택(번호): ");
		int num = scan.nextInt();
		scan.skip("\r\n");
		boolean loop = true;
		
		while(loop)
		switch(num) {
		case 1:
			Teacher_Information.Teacher_Info(id);
			loop = false;
		break;
		case 2:
			Teacher_Student_Management_Test.Teacher_Management(id);
			loop = false;
			break;
		case 3:
			Data_Test.Teacher_Data_Check(id);
			loop = false;
			break;
		case 4:
			pause(scan);
			loop = false;
			System.out.println("메인 페이지로 돌아갑니다.");
			break;
		default: 
			System.out.println("잘못된 숫자를 입력했습니다.");
		
		
		}
		
	}
	
	public static void pause(Scanner scan) {
		
		System.out.println();
		System.out.println("완료되었습니다.");
		System.out.println("계속하려면 엔터를 입력하세요.");
		
		//Scanner scan = new Scanner(System.in);
		
		scan.nextLine();
		
	}	
}
