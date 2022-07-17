package com.company;

import java.util.Scanner;
import java.io.*;

public class Main {
	static Scanner input = new Scanner(System.in);
	static int role, menu;
	static int totalTerisi, totalKosong, totalDibooking;
	static int nomorKamar;
	static String room, singleRoom = "Single", doubleRoom = "Double", suiteRoom = "Suite";
	static int singelRoomPrice = 175000, doubleRoomPrice = 225000, suiteRoomPrice = 300000, hari, totalPembayaran;
	static boolean sudahDibayar;
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
		print("1. Data Kamar");
		print("2. Data Penyewa");
		print("3. Data Transaksi");
		print("4. Logout");
		System.out.print("Pilih menu : ");
		menu = input.nextInt();
		print("===================================\n");
		switch (menu) {
			case 1:
				getKamar();
				break;
			case 2:
				getPenyewa();
				break;
			case 3:
				getTransaksi();
				break;
			case 4:
				portal();
				break;
			default:
				print("Pilihan tidak ada");
				admin();
				break;
		}

	}

	static void getKamar() {
		// read data from file
		try {
			File file = new File(
					"C:\\Users\\vince\\IdeaProjects\\sistem-informasi-perhotelan\\src\\com\\company\\dataKamar.txt");
			Scanner input = new Scanner(file);
			while (input.hasNext()) {
				print(input.nextLine());
			}
			input.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		print("===================================\n");

		admin();
	}

	static void getPenyewa() {
		// read data from file with buffered reader
		try {
			File file = new File(
					"C:\\Users\\vince\\IdeaProjects\\sistem-informasi-perhotelan\\src\\com\\company\\dataPenyewa.txt");
			BufferedReader input = new BufferedReader(new FileReader(file));
			String line;
			while ((line = input.readLine()) != null) {
				print(line);
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		print("===================================\n");
		admin();

	}

	static void getTransaksi() {
		// read data from dataTransaksi.txt
		try {
			File file = new File(
					"C:\\Users\\vince\\IdeaProjects\\sistem-informasi-perhotelan\\src\\com\\company\\dataTransaksi.txt");
			Scanner input = new Scanner(file);
			while (input.hasNext()) {
				print(input.nextLine());
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		print("===================================\n");
		admin();
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
				room = singleRoom;
				print("Anda memilih " + room);
				print("Harga perhari: " + singelRoomPrice);
				break;
			case 2:
				room = doubleRoom;
				print("Anda memilih " + room);
				print("Harga perhari: " + doubleRoomPrice);
				break;
			case 3:
				room = suiteRoom;
				print("Anda memilih " + room);
				print("Harga perhari: " + suiteRoomPrice);
				break;
			default:
				print("Kamar tidak ada");
				sewaKamar();
				break;
		}
		print("\n---------------------------");

		System.out.print("Ingin menginap berapa hari\t: ");
		hari = input.nextInt();

		System.out.print("Masukkan nomor KTP\t\t: ");
		noKtp = input.next();

		System.out.print("Masukkan nama\t\t\t: ");
		nama = input.next();

		System.out.print("Masukkan alamat\t\t\t: ");
		alamat = input.next();

		System.out.print("Masukkan nomor telepon\t\t: ");
		noTelp = input.next();

		// create separator for better readability
		print("===================================\n");

		// print data
		print("========= PEMBAYARAN =========");
		print("Nomor Kamar\t: " + nomorKamar);
		print("Jenis Kamar\t: " + room);
		print("Hari\t\t: " + hari);
		print("Nomor KTP\t: " + noKtp);
		print("Nama\t\t: " + nama);
		print("Alamat\t\t: " + alamat);
		print("Nomor Telepon\t: " + noTelp);
		if (nomorKamar == 1) {
			totalPembayaran = singelRoomPrice * hari;
		} else if (nomorKamar == 2) {
			totalPembayaran = doubleRoomPrice * hari;
		} else if (nomorKamar == 3) {
			totalPembayaran = suiteRoomPrice * hari;
		}
		print("\n--------------------------------\n");
		print("TOTAL TAGIHAN ANDA: " + totalPembayaran + " IDR" + " / " + hari + " hari");
		System.out.print("Bayar sesuai tagihan\t\t: ");
		int bayar = input.nextInt();
		if (bayar != totalPembayaran) {
			print("Uang Anda tidak cukup!");
			sudahDibayar = false;
			sewaKamar();
		} else {
			sudahDibayar = true;
			print("Pembayaran Anda berhasil!");
			print("\n========================================\n");
			print("Terima kasih telah menginap di Hotel kami.");
			print("\n========================================\n");
		}
		print("\n--------------------------------\n");
		print("===============================\n");

		// write data to file
		if (sudahDibayar == true) {
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(
						"C:\\Users\\vince\\IdeaProjects\\sistem-informasi-perhotelan\\src\\com\\company\\dataPenyewa.txt",
						true));
				bw.write("========= PEMBAYARAN =========");
				bw.newLine();
				bw.write("Nomor Kamar\t\t: " + nomorKamar);
				bw.newLine();
				bw.write("Jenis Kamar\t\t: " + room);
				bw.newLine();
				bw.write("Hari\t\t\t: " + hari);
				bw.newLine();
				bw.write("Nomor KTP\t\t: " + noKtp);
				bw.newLine();
				bw.write("Nama\t\t\t: " + nama);
				bw.newLine();
				bw.write("Alamat\t\t\t: " + alamat);
				bw.newLine();
				bw.write("Nomor Telepon\t: " + noTelp);
				bw.newLine();
				if (nomorKamar == 1) {
					totalPembayaran = singelRoomPrice * hari;
				} else if (nomorKamar == 2) {
					totalPembayaran = doubleRoomPrice * hari;
				} else if (nomorKamar == 3) {
					totalPembayaran = suiteRoomPrice * hari;
				}
				bw.write("\n--------------------------------\n");
				bw.write("TOTAL TAGIHAN: " + totalPembayaran + " IDR" + " / " + hari + " hari");
				bw.newLine();
				bw.write("\n--------------------------------\n");
				bw.write("===============================\n");
				bw.newLine();
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

			// write data to dataTransaksi.txt
			BufferedWriter bw2 = null;
			try {
				bw2 = new BufferedWriter(new FileWriter(
						"C:\\Users\\vince\\IdeaProjects\\sistem-informasi-perhotelan\\src\\com\\company\\dataTransaksi.txt",
						true));
				bw2.write("========= TRANSAKSI ===========");
				bw2.newLine();
				bw2.write("Nama\t\t\t: " + nama);
				bw2.newLine();
				bw2.write("Jenis Kamar\t\t: " + room);
				bw2.newLine();
				bw2.write("Hari\t\t\t: " + hari);
				bw2.newLine();
				if (nomorKamar == 1) {
					totalPembayaran = singelRoomPrice * hari;
				} else if (nomorKamar == 2) {
					totalPembayaran = doubleRoomPrice * hari;
				} else if (nomorKamar == 3) {
					totalPembayaran = suiteRoomPrice * hari;
				}
				bw2.write("\n--------------------------------\n");
				bw2.write("TOTAL TAGIHAN: " + totalPembayaran + " IDR" + " / " + hari + " hari");
				bw2.newLine();
				bw2.write("\n--------------------------------\n");
				bw2.write("===============================\n");
				bw2.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (bw2 != null) {
					try {
						bw2.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		}

	}

	public static void main(String[] args) {
		portal();
	}

}
