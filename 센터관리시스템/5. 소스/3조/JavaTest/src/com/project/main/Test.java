package com.project.main;

import java.io.IOException;

public class Test {
	public static void main(String[] args) throws Exception {
		Login_Main m1 = new Login_Main();
		try {
			m1.login();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
