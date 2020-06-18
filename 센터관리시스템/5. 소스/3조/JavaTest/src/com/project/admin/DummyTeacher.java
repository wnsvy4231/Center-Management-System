package com.project.admin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Random;

public class DummyTeacher {

	public static void main(String[] args) throws Exception {
		
		HashMap<Integer, Teacher> map = new HashMap<Integer, Teacher>();
		
		int length = 10;
		String[] temp1 = { "김", "이", "박", "최", "정", "진","홍" };
		String[] temp2 = { "유", "정", "석", "인", "지", "은", "형", "순", "성", "민" };
		String[] temp3 = { "서울시", "인천시", "부산시", "대전시", "광주시" };
		String[] temp4 = { "강남구", "강서구", "강북구", "강동구" };
		String[] temp5 = { "Java", "Pthyon", "C#", "Android", "Linux", "HTML", "WML", "Javascript"};
		Random rnd = new Random();
		String path = "C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\강사.txt";
		File file = new File(path);
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("C:\\java\\workspaces\\JavaTest\\src\\com\\project\\source\\강사.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		for(int i=0;i<length;i++) {
			Teacher s = new Teacher();
			map.put(i, s);
		}
		
		
		//if문 전에 열어야 돼~
		int cnt=1;
		if (file.exists()) {
			for (int i=0;i<length;i++) {
				
				Teacher.temp++;
				map.get(i).setSeq(Teacher.temp);

				String name = temp1[rnd.nextInt(temp1.length)] + temp2[rnd.nextInt(temp2.length)]
						+ temp2[rnd.nextInt(temp2.length)];

				int age = rnd.nextInt(10) + 20;

				String address = temp3[rnd.nextInt(temp3.length)] + " " + temp4[rnd.nextInt(temp4.length)];
				String tel = "010-" + (rnd.nextInt(9000) + 1000) + "-" + (rnd.nextInt(9000) + 1000);
				map.get(i).setKey(cnt);
				map.get(i).setName(name);
				map.get(i).setAge(age);
				map.get(i).setAddress(address);
				map.get(i).setTel(tel);
				map.get(i).setSubject(temp5[rnd.nextInt(temp5.length)]);
				map.get(i).setGender(rnd.nextInt(2)+1);
				try {
					writer.write(map.get(i).getSeq() + "," + map.get(i).getName() + "," + map.get(i).getAge() + ","
							+ map.get(i).getSubject() + "," +map.get(i).getAddress() +"," + map.get(i).getTel() + "," + map.get(i).getGender() + "," + map.get(i).getKey()
							+ "\r\n");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				cnt++;
			}
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
		
		writer.close();
		
		System.out.println("완료");

	}
	
}//main