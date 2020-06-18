package com.project.teacher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Teacher_Information {
	public static void Teacher_Info(String id) {
		
		File file = new File("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\강사.txt");
		Scanner scan = new Scanner(System.in);

		System.out.println("=============================================================");
		System.out.println("                        회원 정보");
		System.out.println("=============================================================");
		System.out.println("[번호]\t[이름]\t[나이]\t[성별]\t[전화번호]\t[주소]");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line=reader.readLine())!=null) {
				String[] item = line.split(",");
				if(item[9].equals(id)) {
				System.out.printf("%d\t%s\t%d\t%s\t%s\t%s\n",Integer.parseInt(item[0]),
						item[1],Integer.parseInt(item[2]),Integer.parseInt(item[6])==1 ? "남":"여",item[5],item[4]);
				}
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pause(scan);
		Teacher_Login.teacher(id);
		
		
	}

	private static void pause(Scanner scan) {
		
		System.out.println();
		System.out.println("완료되었습니다.");
		System.out.println("계속하려면 엔터를 입력하세요.");
		System.out.println("이전 페이지로 돌아갑니다.");
		//Scanner scan = new Scanner(System.in);
		
		scan.nextLine();
		
	}
}
