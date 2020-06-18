package com.project.teacher;

import java.util.Scanner;

public class Teacher_Student_Management_Output {
public void menu() {
		
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.println("       수강생 관리");
		System.out.println("1. 수강생 추가");
		System.out.println("2. 수강생 수정");
		System.out.println("3. 수강생 삭제");
		System.out.println("4. 수강생 검색(수강생 이름)");
		System.out.println("5. 수강생 검색(강의실)");
		System.out.println("6. 전체 조회");
		System.out.println("7. 이전페이지");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.print("선택(번호): ");
		
		
	}

	public void title( Teacher_Student_Management_Title type) {
		String title = "";
		if(type ==  Teacher_Student_Management_Title.ADD) {
			title = "수강생 추가하기";
		} else if(type ==  Teacher_Student_Management_Title.CORRECT) {
			title="수강생 수정하기";
		} else if(type ==  Teacher_Student_Management_Title.DELETE) {
			title="수강생 삭제하기";
		} else if(type ==  Teacher_Student_Management_Title.SEARCH) {
			title="수강생 검색하기";
		} else if(type ==  Teacher_Student_Management_Title.LIST) {
			title="수강생 검색하기";
		} 
		
		System.out.println();
		System.out.println("▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨");
		System.out.println(title);
		System.out.println("▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨");
		System.out.println();
	}

	public void pause(Scanner scan) {
		
		System.out.println();
		System.out.println("완료되었습니다.");
		System.out.println("계속하려면 엔터를 입력하세요.");
		
		//Scanner scan = new Scanner(System.in);
		
		scan.nextLine();
		
	}

}
