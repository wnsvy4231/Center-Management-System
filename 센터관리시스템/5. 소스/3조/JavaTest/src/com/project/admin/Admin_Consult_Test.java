package com.project.admin;

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

public class Admin_Consult_Test {
	private static Admin_Consult_Output output;
	private static Scanner scan;
	private static HashMap<Integer, Consult> map;

	static {
		output = new Admin_Consult_Output();
		scan = new Scanner(System.in);
		map = new HashMap<Integer, Consult>();
	}

	public void consult() {
		try {
			String path = "C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source";
			File dir = new File(path);
			boolean loop = false;
			for(File list:dir.listFiles()) {
				if(list.isFile()) {
					loop = true;
				} else {
					loop = false;
				}
			}
			
			if(!loop) {
				dummy();
			} else {
				String path1 = "C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\상담.txt";
				BufferedReader reader = new BufferedReader(new FileReader(path1));
				String line = null;
				while((line=reader.readLine())!=null) {
					Consult.temp++;
					String[] item = line.split(",");
					map.put(Consult.temp,new Consult());
					//System.out.println(Integer.parseInt(item[0]));
					
					map.get(Consult.temp).setSeq(Integer.parseInt(item[0]));
					map.get(Consult.temp).setState(item[1]);
					map.get(Consult.temp).setStudent(item[2]);
					map.get(Consult.temp).setContext(item[3]);
					map.get(Consult.temp).setDate(item[4]);
					map.get(Consult.temp).setAnswer(item[5]);
					
			}
				filewrite();
		}
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		boolean loop = true;

		while (loop) {

			output.menu();

			String sel = scan.nextLine();

			if (sel.equals("1")) {
				list();
			} else if (sel.equals("2")) {
				answer();
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
		output.title(Admin_Consult_Title.SEARCH);

		// 검색?
		// -> list() 작업과 유사
		// 1. list(): 모든 데이터 출력
		// 2. search(): 일부 데이터 출력. 조건부 list()

		System.out.print("검색(수강생): "); // 홍길동 > 길동 검색률을 높임
		String word = scan.nextLine();
//		try {
//			read();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("[번호]\t[구분]\t[수강생]\t[문의사항]\t\t\t[문의시간]\t\t\t[문의답변]");
		Set<Integer> set = map.keySet();
		for (Integer key : set) {

			// if(s.getName().contains(word)) {
			// if(s.getName().toUpperCase().contains(word.toUpperCase())) // 대소문자 구분 없이 한쪽으로
			// 몰아야 돼 그걸 안하면 철저하게 찾는 거임
			if (map.get(key).getStudent().indexOf(word) > -1) {
				System.out.printf("%3d\t%s\t%s\t%-20s\t%s\t\t%s\n",map.get(key).getSeq(),map.get(key).getState(),
						map.get(key).getStudent(),map.get(key).getContext(),map.get(key).getDate(),
						map.get(key).getAnswer()
					   );

			}
		}
		output.pause(scan);
		
	}

	private static void answer() {
		output.title(Admin_Consult_Title.ANSWER);
		list();
		System.out.print("답변할 번호: ");
		int num = scan.nextInt();
		scan.skip("\r\n");
		
		System.out.print("답변: ");
		String answer = scan.nextLine();
		if(num>=1 && num<=map.size()) {
			map.get(num).setAnswer(answer);
			map.get(num).setState("답변 완료");
		}
		
		filewrite();
		
		output.pause(scan);
		
		
	}
	

	private static void filewrite() {	
		
		Set<Integer> set = map.keySet(); 
	
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
	}

	private static void list() {
		output.title(Admin_Consult_Title.LIST);
	
		System.out.println("[번호]\t[구분]\t\t[수강생]\t[문의사항]\t\t\t[문의시간]\t\t[문의답변]");
		
			Set<Integer> set = map.keySet(); 
			for(Integer key:set) {
				System.out.printf("%3d\t%s\t\t%s\t%-20s\t%s\t%s\n",map.get(key).getSeq(),map.get(key).getState(),
									map.get(key).getStudent(),map.get(key).getContext(),map.get(key).getDate(),
									map.get(key).getAnswer()
								   );
			
		} 
			output.pause(scan);
		
	}


	private static void dummy() throws Exception {
		String path = "C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\상담.txt";
	
		File file = new File(path);
		File file1 = new File("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\수강생.txt");
		BufferedReader reader1 = new BufferedReader(new FileReader(file1));
		
		String line = null;
		ArrayList<String> student = new ArrayList<String> ();
		reader1.readLine();
		while((line = reader1.readLine())!=null) {
			String[] item = line.split(",");
			student.add(item[1]);
		}
		
		
		
		int length = 10;
		String[] state = {"답변 미완료","답변 완료"};
		String[] question = {"공휴일은 쉬나요?","점심은 주나요?","수당은 언제 들어오나요?","점심시간은 언제인가요?","화장실은 어디에 있나요?"};
		String[] answer = {"홈페이지 참고바랍니다.","전화로 문의주세요."};
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	
		for (int i = 0; i < length; i++) {
			Random rnd = new Random();
			Consult.temp++;
			//System.out.println(Consult.temp);
			Calendar c = Calendar.getInstance();
			String state1 = state[rnd.nextInt(state.length)];
			String student1 = student.get(rnd.nextInt(student.size()));
			String question1 = question[rnd.nextInt(question.length)];
			String date = String.format("%tF", c);
			String answer1 = answer[rnd.nextInt(answer.length)];
			map.put(Consult.temp,new Consult());
			
			if(state1.equals("답변 미완료")) {
				map.get(Consult.temp).setAnswer("답변 중");
			} else {
				map.get(Consult.temp).setAnswer(answer1);
			}
			writer.write(Consult.temp + "," + state1 + ","
					+ student1 + "," + question1 + ","
					+ date + "," + answer1+ "\r\n");
			
			map.get(Consult.temp).setSeq(Consult.temp);
			map.get(Consult.temp).setContext(question1);
			map.get(Consult.temp).setDate(date);
			map.get(Consult.temp).setState(state1);
			map.get(Consult.temp).setStudent(student1);
			map.get(Consult.temp).setState(state1);
			
		}
		
		writer.close();
		
		
	}


}


	


