package com.project.guest;

import java.util.Scanner;

public class Nonmember_Inquiry_Output {
public void menu() {
		
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.println("         비회원 1:1문의");
		System.out.println("1. 문의 등록");
		System.out.println("2. 답변 확인");
		System.out.println("3. 문의 검색(수강생 이름)");
		System.out.println("4. 이전 페이지");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.print("선택(번호): ");
		
		
	}

	public void title(Nonmember_Inquiry_Title type) {
		String title = "";
		if(type == Nonmember_Inquiry_Title.REGISTRATION) {
			title = "문의 등록하기";
		} else if(type == Nonmember_Inquiry_Title.LIST) {
			title="답변 확인하기";
		} else if(type == Nonmember_Inquiry_Title.SEARCH) {
			title="문의 검색(수강생 이름)";
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
