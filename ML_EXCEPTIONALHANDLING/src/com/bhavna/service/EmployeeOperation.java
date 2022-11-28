package com.bhavna.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.bhavna.bean.EmployeeLogin;

public class EmployeeOperation {

	 Map<String, ArrayList<EmployeeLogin>> map = new HashMap<>();
	 public void readFile() {
	        Scanner sc = null;
	        try {
	            File read = new File("C:\\a.txt");
	            sc = new Scanner(read);
	            while (sc.hasNextLine()) {
	                String data = sc.nextLine();
	                String[] array = data.split("   ");

	                EmployeeLogin login = new EmployeeLogin(array[0], array[1]);
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

	        if (map.containsKey(name)) {
	            map.get(name).add(data);
	        } else {
	            map.put(name, new ArrayList<>());
	            map.get(name).add(data);
	        }

	    }

	    public void display() {
       
	        map.forEach((key, values) -> System.out.println(key + ":" + values));
	    }


	}

