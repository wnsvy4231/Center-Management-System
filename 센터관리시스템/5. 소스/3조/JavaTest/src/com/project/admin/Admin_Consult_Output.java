package com.project.admin;

import java.util.Scanner;

public class Admin_Consult_Output {
	
	public void menu() {
		
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.println("            1:1 문의");
		System.out.println("1. 문의 확인");
		System.out.println("2. 문의 답변");
		System.out.println("3. 문의 검색(수강생 이름)");
		System.out.println("4. 이전 페이지");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.print("선택(번호): ");
		
		
	}

	public void title(Admin_Consult_Title type) {
		String title = "";
		if(type == Admin_Consult_Title.LIST) {
			title = "문의 확인하기";
		} else if(type == Admin_Consult_Title.ANSWER) {
			title="문의 답변하기";
		} else if(type == Admin_Consult_Title.SEARCH) {
			title="문의 검색하기";
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
