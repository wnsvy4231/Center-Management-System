package com.project.teacher;


import java.util.Scanner;

public class Data_Output {

	public void menu() {
		
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.println("            수업자료");
		System.out.println("1. 업로드");
		System.out.println("2. 조회");
		System.out.println("3. 삭제");
		System.out.println("4. 수정");
		System.out.println("5. 검색(이름)");
		System.out.println("6. 검색(년)");
		System.out.println("7. 이전페이지");

		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.print("선택(번호): ");
		
		
	}

	public void title(Data_Title type) {
		String title = "";
		if(type == Data_Title.UPLOAD) {
			title = "수업자료 업로드하기";
		} else if(type == Data_Title.LIST) {
			title="수업자료 목록보기";
		} else if(type == Data_Title.DELETE) {
			title="수업자료 삭제하기";
		} else if(type == Data_Title.SEARCH) {
			title="수업자료 검색하기";
		} else if(type == Data_Title.CORRECT)	{
			title="수업자료 수정하기";
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
