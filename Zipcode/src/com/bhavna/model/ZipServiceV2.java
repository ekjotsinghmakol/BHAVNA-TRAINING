package com.bhavna.model;

import java.util.ArrayList;
import java.util.List;

public class ZipServiceV2 extends ZipServiceV1 {

	List<Details> dataList = new ArrayList<Details>();

	public void searchData(long code) {
		Details entry1 = new Details("India", "Delhi", "New Delhi", 110030);
		Details entry2 = new Details("India", "Maharshtra", "Pune", 220020);
		Details entry3 = new Details("India", "Bihar", "Patna", 330010);
		Details entry4 = new Details("India", "Uttarpradesh", "Noida", 440090);
		Details entry5 = new Details("India", "Haryana", "Gurgaon", 120098);
		Details entry6 = new Details("India", "Assam", "Guwahati", 779088);
		Details entry7 = new Details("India", "Uttarpradesh", "Ghaziabad", 889900);

		dataList.add(entry1);
		dataList.add(entry2);
		dataList.add(entry3);
		dataList.add(entry4);
		dataList.add(entry5);
		dataList.add(entry6);
		dataList.add(entry7);

		for (Details dets : dataList) {
			if (dets.getZipCode() == code)
				System.out.println(dets);
		}

	}
	public void allRecords(String records) {
		for (Details displayAll: dataList) {
			System.out.println(displayAll);
		}
	}
	
}
