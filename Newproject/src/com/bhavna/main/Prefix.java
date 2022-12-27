package com.bhavna.main;

public class Prefix {
	public String common(String[] strs) {
		if (strs.length == 0)
			return "";
		
		String a = strs[0];
		
		for(int i=1;i<strs.length;i++) {
			while(strs[i].indexOf(a) !=0) {
				a = a.substring(0, a.length()-1);		
			}
		}
		return a;
	}
}
