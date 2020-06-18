package com.project.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;

public class Login_Main {
	
		public void login() throws Exception {
		
		Scanner scan = new Scanner(System.in);
		
		New n1 = new New();
		Output output = new Output();
		Login login = new Login();
		
		String text = null;
		
		System.out.println("======================");
		System.out.println("        로그인");		
		System.out.println();	
		System.out.println("1. 로그인 페이지로 이동 ");
		System.out.println("2. 회원가입");	
		System.out.println("======================");		
		System.out.println();
		System.out.println("숫자를 입력하세요..");
		String get = scan.nextLine();
		
		if(get.equals("1")) {		
			login.rogin();	//로그인 페이지로 이동				
		}
		
		if(get.equals("2")) {
			n1.ne();
			login();//회원 가입 페이지로 이동
		}
		
	}
	
	

		
	}

	

