package com.company;

import java.util.Scanner;
import java.io.*;

public class Main {

	// create data array
	static String[] penyewa = { "sincan", "aldi", "bahtiar" };

	// getData method
	public static void getData() {
		String fileName = "C:\\Users\\vince\\IdeaProjects\\sistem-informasi-perhotelan\\src\\com\\company\\data.txt";

		try {
			// membaca file
			File myFile = new File(fileName);
			try (Scanner fileReader = new Scanner(myFile)) {
				// cetak isi file
				while (fileReader.hasNextLine()) {
					String data = fileReader.nextLine();
					System.out.println(data);
				}
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Terjadi kesalahan: " + ex.getMessage());
			ex.printStackTrace();
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
				// call array penyewa
				for (int i = 0; i < penyewa.length; i++) {
					System.out.println("Nama Penyewa: " + penyewa[i]);
				}
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
		getData();

	}

	public static void main(String[] args) {
		// write your code here
		menus();

	}
}
