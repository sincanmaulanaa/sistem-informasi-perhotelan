package com.company;

import java.util.Scanner;
import java.io.*;

public class Main {
	static Scanner input = new Scanner(System.in);
	static int role, menu;
	static int nomorKamar;
	static String singleRoom = "Single", doubleRoom = "Double", suiteRoom = "Suite";
	static int singelRoomPrice = 175000, doubleRoomPrice = 225000, suiteRoomPrice = 300000, hari, totalPembayaran;
	static String noKtp, nama, alamat, noTelp;

	static void print(String s) {
		System.out.println(s);
	}

	static void print(int s) {
		System.out.println(s);
	}

	static void print(double s) {
		System.out.println(s);
	}

	static void portal() {
		print("====== SELAMAT DATANG ======");
		print("==== SILAHKAN PILIH ROLE ===");
		print("1. Admin");
		print("2. Penyewa");

		System.out.print("Pilih role : ");
		role = input.nextInt();

		// create separator for better readability
		print("===================================\n");

		switch (role) {
			case 1:
				admin();
				break;
			case 2:
				penyewa();
				break;
			default:
				print("Pilihan tidak ada");
				portal();
				break;
		}

	}

	static void admin() {
		print("====== SELAMAT DATANG! ADMIN ======");
		print("======= SILAHKAN PILIH MENU =======");
	}

	static void penyewa() {
		print("====== SELAMAT DATANG! PENYEWA ======");
		print("======= SILAHKAN PILIH MENU =======");
		print("1. Sewa Kamar");
		print("2. Logout");
		System.out.print("Pilih menu : ");
		menu = input.nextInt();

		print("===================================\n");

		switch (menu) {
			case 1:
				sewaKamar();
				break;
			case 2:
				portal();
				break;
			default:
				print("Pilihan tidak ada");
				penyewa();
				break;
		}
	}

	static void sewaKamar() {
		// read file with buffer reader
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(
					"C:\\Users\\vince\\IdeaProjects\\sistem-informasi-perhotelan\\src\\com\\company\\dataKamar.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				print(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.print("Masukkan nomor kamar: ");
		nomorKamar = input.nextInt();
		print("\n---------------------------\n");
		switch (nomorKamar) {
			case 1:
				print("Anda memilih " + singleRoom);
				print("Harga perhari: " + singelRoomPrice);
				break;
			case 2:
				print("Kamar " + nomorKamar + " " + doubleRoom);
				print("Harga perhari: " + doubleRoomPrice);
				break;
			case 3:
				print("Kamar " + nomorKamar + " " + suiteRoom);
				print("Harga perhari: " + suiteRoomPrice);
				break;
			default:
				print("Kamar tidak ada");
				sewaKamar();
				break;
		}
		print("\n---------------------------");

		System.out.print("Ingin menginap berapa hari: ");
		hari = input.nextInt();

		System.out.print("Masukkan nomor KTP: ");
		noKtp = input.next();

		System.out.print("Masukkan nama: ");
		nama = input.next();

		System.out.print("Masukkan alamat: ");
		alamat = input.next();

		System.out.print("Masukkan nomor telepon: ");
		noTelp = input.next();

		// create separator for better readability
		print("===================================\n");

		// print data
		print("========= PEMBAYARAN =========");
		print("Nomor Kamar: " + nomorKamar);
		print("Hari: " + hari);
		print("Nomor KTP: " + noKtp);
		print("Nama: " + nama);
		print("Alamat: " + alamat);
		print("Nomor Telepon: " + noTelp);
		if (nomorKamar == 1) {
			totalPembayaran = singelRoomPrice * hari;
		} else if (nomorKamar == 2) {
			totalPembayaran = doubleRoomPrice * hari;
		} else if (nomorKamar == 3) {
			totalPembayaran = suiteRoomPrice * hari;
		}
		print("\n--------------------------------\n");
		print("TOTAL TAGIHAN ANDA: " + totalPembayaran + " IDR" + " / " + hari + " hari");
		print("\n--------------------------------\n");
		print("===============================\n");

		// write data to file
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(
					"C:\\Users\\vince\\IdeaProjects\\sistem-informasi-perhotelan\\src\\com\\company\\dataPembayaran.txt",
					true));
			bw.write("========= PEMBAYARAN =========");
			bw.newLine();
			bw.write("Nomor Kamar: " + nomorKamar);
			bw.newLine();
			bw.write("Hari: " + hari);
			bw.newLine();
			bw.write("Nomor KTP: " + noKtp);
			bw.newLine();
			bw.write("Nama: " + nama);
			bw.newLine();
			bw.write("Alamat: " + alamat);
			bw.newLine();
			bw.write("Nomor Telepon: " + noTelp);
			bw.newLine();
			if (nomorKamar == 1) {
				totalPembayaran = singelRoomPrice * hari;
			} else if (nomorKamar == 2) {
				totalPembayaran = doubleRoomPrice * hari;
			} else if (nomorKamar == 3) {
				totalPembayaran = suiteRoomPrice * hari;
			}
			bw.write("\n--------------------------------\n");
			bw.write("TOTAL TAGIHAN ANDA: " + totalPembayaran + " IDR" + " / " + hari + " hari");
			bw.newLine();
			bw.write("\n--------------------------------\n");
			bw.write("===============================\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		portal();
	}

}
