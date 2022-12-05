package com.bhavna.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.bhavna.bean.EmployeeLogin;

public class EmployeeOperation {

	Map<String, ArrayList<EmployeeLogin>> SuccessHashMap = new HashMap<>();
	Map<String, ArrayList<EmployeeLogin>> FailureHashMap = new HashMap<String, ArrayList<EmployeeLogin>>();

	public void readFile() {
		Scanner sc = null;
		try {
			File read = new File("C:\\a.txt");
			sc = new Scanner(read);
			while (sc.hasNextLine()) {
				String data = sc.nextLine();
				String[] array = data.split(" ");

				if (array.length > 3) {
					System.out.println("out of bound exception");
					continue;
				}

				EmployeeLogin login = new EmployeeLogin(array[0], array[1], array[2]);
				EmployeeOperation operation = new EmployeeOperation();
				operation.readLoginData(login.getName(), login);
				operation.display();

			}
		} catch (Exception e) {
			System.out.println("Failure");
			e.printStackTrace();
		} finally {

			try {
				sc.close();
			} catch (Exception ignored) {

			}
		}

	}

	public void readLoginData(String name, EmployeeLogin data) {

		if (SuccessHashMap.containsKey(name) || !isValidName(name)) {
			if (FailureHashMap.containsKey(name)) {
				FailureHashMap.get(name).add(data);
			} else {
				FailureHashMap.put(name, new ArrayList<EmployeeLogin>());
				FailureHashMap.get(name).add(data);
			}

		} else {
			SuccessHashMap.put(name, new ArrayList<EmployeeLogin>());
			SuccessHashMap.get(name).add(data);
		}
	}

	public void display() {
		System.out.println("Sucess hashmap: ");
		SuccessHashMap.forEach((key, value) -> System.out.println(key + " : " + value));

		System.out.println("Failure hashmap: ");
		FailureHashMap.forEach((key, value) -> System.out.println(key + " : " + value));
	}

	public static boolean isValidName(String name) {
		for (int i = 0; i < name.length(); ++i) {
			char ch = name.charAt(i);

			
			if (!Character.isLetter(ch) && !Character.isWhitespace(ch)) {
				return false;
			}
		}
		return true;
	}

}
