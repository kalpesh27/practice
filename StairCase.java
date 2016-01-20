package com;

public class StairCase {

	public static void main(String[] args) {

		String a = " ";
		String b = "#";
		int n = 6;
		for(int i =0; i < n; i ++){
			for(int j=n; j >= i; j--){
				System.out.print(a);
			}
			for (int k=0;k<=i; k++) {
				System.out.print(b);	
			}
			System.out.println();

		}
	}

}
