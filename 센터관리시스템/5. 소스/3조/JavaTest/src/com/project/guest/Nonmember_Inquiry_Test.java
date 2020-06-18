package com.project.guest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Nonmember_Inquiry_Test {
	private static Nonmember_Inquiry_Output output;
	private static Scanner scan;
	private static HashMap<Integer, Consult> map;

	static {
		output = new Nonmember_Inquiry_Output();
		scan = new Scanner(System.in);
		map = new HashMap<Integer, Consult>();
	}

	public void non(){
		
		boolean loop = true;

		while (loop) {

			output.menu();

			String sel = scan.nextLine();

			if (sel.equals("1")) {
				registration();
			} else if (sel.equals("2")) {
				list();
			} else if(sel.equals("3")) {
				search();
			}
			else if(sel.equals("4")) {
				System.out.println("이전 페이지로 돌아갑니다.");
				loop = false;
			}

		}

	} // main

	

	private static void search() {
		
		output.title(Nonmember_Inquiry_Title.SEARCH);

		// 검색?
		// -> list() 작업과 유사
		// 1. list(): 모든 데이터 출력
		// 2. search(): 일부 데이터 출력. 조건부 list()

		System.out.print("검색(수강생): "); // 홍길동 > 길동 검색률을 높임
		String word = scan.nextLine();
		try {
			read();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("[번호]\t[구분]\t\t[수강생]\t\t[문의사항]\t\t\t[문의시간]\t\t[문의답변]");
		Set<Integer> set = map.keySet();
		for (Integer key : set) {

			// if(s.getName().contains(word)) {
			// if(s.getName().toUpperCase().contains(word.toUpperCase())) // 대소문자 구분 없이 한쪽으로
			// 몰아야 돼 그걸 안하면 철저하게 찾는 거임
			if (map.get(key).getStudent().indexOf(word) > -1) {
				System.out.printf("%3d\t%s\t\t%s\t\t%-20s\t%s\t%s\n",map.get(key).getSeq(),map.get(key).getState(),
						map.get(key).getStudent(),map.get(key).getContext(),map.get(key).getDate(),
						map.get(key).getAnswer()
					   );

			}
		}
		output.pause(scan);
		
	}



	private static void read() throws Exception {
		String path = "C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\상담.txt";
		//File file = new File(path);
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line = null;
			while((line=reader.readLine())!=null) {
				Consult.temp++;
				String[] item = line.split(",");
				map.put(Consult.temp,new Consult());
				map.get(Consult.temp).setSeq(Integer.parseInt(item[0]));
				map.get(Consult.temp).setState(item[1]);
				map.get(Consult.temp).setStudent(item[2]);
				map.get(Consult.temp).setContext(item[3]);
				map.get(Consult.temp).setDate(item[4]);
				map.get(Consult.temp).setAnswer(item[5]);
			}
		
	}



	private static void registration() {
		output.title(Nonmember_Inquiry_Title.REGISTRATION);
		
		String path = "C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\상담.txt";
		//File file = new File(path);
		try {
			
			
			 filewrite();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(path,true));
			System.out.print("이름: ");
			String name = scan.nextLine();
			System.out.print("문의 내용: ");
			String context = scan.nextLine();
			Consult.temp++;
			map.put(Consult.temp,new Consult());
			map.get(Consult.temp).setSeq(Consult.temp);
			map.get(Consult.temp).setAnswer("답변중~");
			map.get(Consult.temp).setState("답변 미완료");
			Calendar c = Calendar.getInstance();
			map.get(Consult.temp).setDate(String.format("%tF",c));
			map.get(Consult.temp).setStudent(name);
			map.get(Consult.temp).setContext(context);;
			writer.write(map.get(Consult.temp).getSeq()+","+map.get(Consult.temp).getState()+","+map.get(Consult.temp).getStudent()+","
					+ map.get(Consult.temp).getContext()+","+map.get(Consult.temp).getDate() +","+map.get(Consult.temp).getAnswer());
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		map.clear();
		Consult.temp=0;
		output.pause(scan);
		
	}



	private static void filewrite() {	
		
		Set<Integer> set = map.keySet(); 
	
		try {
			read();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String path = "C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\상담.txt";
		File file = new File(path);
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for (Integer key : set) {

				writer.write(map.get(key).getSeq() + "," + map.get(key).getState() + "," + map.get(key).getStudent()
						+ "," + map.get(key).getContext() + "," + map.get(key).getDate() + ","
						+ map.get(key).getAnswer()+"\r\n");

			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.clear();
	}

	private static void list() {
		
		String path = "C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\상담.txt";
		
		try {
			read();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		output.title(Nonmember_Inquiry_Title.LIST);
		System.out.println("[번호]\t[구분]\t\t[수강생]\t\t[문의사항]\t\t\t[문의시간]\t\t[문의답변]");
		
			Set<Integer> set = map.keySet(); 
			for(Integer key:set) {
				System.out.printf("%3d\t%s\t\t%s\t\t%-20s\t%s\t%s\n",map.get(key).getSeq(),map.get(key).getState(),
									map.get(key).getStudent(),map.get(key).getContext(),map.get(key).getDate(),
									map.get(key).getAnswer()
								   );
			
			
		} 
		
		map.clear();
		Consult.temp=0;
		output.pause(scan);
	}




}
