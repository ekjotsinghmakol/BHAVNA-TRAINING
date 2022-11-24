package com.bhavna.main;

import java.util.Scanner;


import com.bhavna.model.ZipServiceV2;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		ZipServiceV2 obj=new ZipServiceV2();
		
		System.out.println("Enter the zip code");
		long code=sc.nextLong();
		obj.searchData(code);
		System.out.println("Display all records ? ");
		String records=sc.next();
		obj.allRecords(records);

	}

}
