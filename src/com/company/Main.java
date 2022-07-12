package com.company;

import java.util.Scanner;

public class Main {

	// Rooms method

	public static void menus() {
		System.out.println("========= Sistem Informasi Perhotelan =========");
		System.out.println("1. Data Kamar");
		System.out.println("2. Data Penyewa");
		System.out.println("3. Data Transaksi");

		Scanner input = new Scanner(System.in);
		System.out.print("Pilih menu: ");
		int menu = input.nextInt();

		switch (menu) {
			case 1:
				System.out.println("Data Kamar");
				break;
			case 2:
				System.out.println("Data Penyewa");
				break;
			case 3:
				System.out.println("Data Transaksi");
				break;
			default:
				System.out.println("Menu tidak tersedia");
				break;
		}
	}

	public static void main(String[] args) {
		// write your code here
		menus();

	}
}
