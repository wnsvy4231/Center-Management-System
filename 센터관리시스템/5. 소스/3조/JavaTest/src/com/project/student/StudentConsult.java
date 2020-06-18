package com.project.student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class StudentConsult { //수강생 모드 > 5.상담 문의
	
	Scanner scan = new Scanner(System.in);
	HashMap<Integer, Consult> map = new HashMap<Integer, Consult>();
	
	public void studentConsult() throws Exception {
		
		Output.title(Title.STUDENTCONSULT);
		
		boolean loop = true;

		while (loop) {

			Output.studentConsult();

			String sel = scan.nextLine();

			if (sel.equals("1")) {
				//상담 문의하기
				registration();
			} else if (sel.equals("2")) {
				//상담 답변 확인하기
				list();
			} else if(sel.equals("3")) {
				//종료
				loop = false;
			}

		}
		
		Output.pause(scan);
		
	}

	private void list() {
		
		try {
			read();
			} catch (Exception e) {
				e.printStackTrace();
			}

		System.out.println("[번호]\t[구분]\t\t[수강생]\t[문의사항]\t\t\t[문의시간]\t[문의답변]");
		
			Set<Integer> set = map.keySet(); 
			for(Integer key:set) {
				System.out.printf("%3d\t%s\t%s\t\t%-20s\t%s\t%s\n",map.get(key).getSeq(),map.get(key).getState(),
									map.get(key).getStudent(),map.get(key).getContext(),map.get(key).getDate(),
									map.get(key).getAnswer()
								   );
		
			
		} 
		map.clear();
		
		Consult.temp=0;
		
		
	}

	private void read() throws FileNotFoundException, IOException { //상담 데이터 호출
		BufferedReader reader = new BufferedReader(new FileReader("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\consult.txt"));
		File file = new File("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\consult.txt");
		String line = null;
		
		if (file.exists()) { //파일 체크 & 배열에 담기
			
			while ((line = reader.readLine()) != null) {
				
				Consult.temp++;
				String[] temp = line.split(",");
				
				map.put(Consult.temp,new Consult());
				map.get(Consult.temp).setSeq(Integer.parseInt(temp[0]));
				map.get(Consult.temp).setState(temp[1]);
				map.get(Consult.temp).setStudent(temp[2]);
				map.get(Consult.temp).setContext(temp[3]);
				map.get(Consult.temp).setDate(temp[4]);
				map.get(Consult.temp).setAnswer(temp[5]);				
				
			}
			
		}
		reader.close();
	}

	private void registration() {
		
		System.out.println("상담 문의하기");
		
		String path = "C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\consult.txt";
		
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
			e.printStackTrace();
		}
		
		map.clear();
		
		Consult.temp=0;
	
	}

	private void filewrite() {
		
		try {
			read();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		Set<Integer> set = map.keySet(); 
	
		String path = "C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\consult.txt";
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
			e.printStackTrace();
		}
		map.clear();
			
		}

}
