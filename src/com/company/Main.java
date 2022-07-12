package com.company;

import java.util.Scanner;

public class Main {

	// create data array
	static String[] kamar = { "Room 1", "Room 2", "Room 3", "Room 4", "Room 5" };
	static String[] penyewa = { "sincan", "aldi", "bahtiar" };
	static Integer[] hargaPenyewa = { 100000, 200000, 300000, 400000, 500000 };

	public static void penyewa() {
		for (int i = 0; i < penyewa.length; i++) {
			System.out.println("Nama Penyewa: " + penyewa[i]);
		}
	}

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
				rooms();
				break;
			case 2:
				penyewa();
				break;
			case 3:
				System.out.println("Data Transaksi");
				break;
			default:
				System.out.println("Menu tidak tersedia");
				break;
		}
	}

	// create method for rooms data
	public static void rooms() {
		System.out.println("");
		System.out.println("========= DATA KAMAR =========");
		// call array kamar
		for (int i = 0; i < kamar.length; i++) {
			// show data rooms
			System.out.println(kamar[i]);
		}

	}

	public static void main(String[] args) {
		// write your code here
		menus();

	}
}
