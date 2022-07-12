package com.company;

public class Room {
	public Room(String namaKamar, String statusKamar, String jenisKamar, String hargaKamar) {
	}

	public static Room[] roooms() {
		Room[] rooms = new Room[5];
		rooms[0] = new Room("Room 1", "Room 1 description", "Room 1 image", "Room 1 price");

		rooms[1] = new Room("Room 2", "Room 2 description", "Room 2 image", "Room 2 price");

		rooms[2] = new Room("Room 3", "Room 3 description", "Room 3 image", "Room 3 price");

		rooms[3] = new Room("Room 4", "Room 4 description", "Room 4 image", "Room 4 price");

		rooms[4] = new Room("Room 5", "Room 5 description", "Room 5 image", "Room 5 price");
		return rooms;
	}

	public static void main(String[] args) {
		// call method for rooms data
		Room[] rooms = roooms();
		for (int i = 0; i < rooms.length; i++) {
			// show data rooms
			System.out.println("========= DATA KAMAR =========");
			System.out.println("Nama Kamar: " + rooms[i]);

		}

	}
}

// kodeKamar, namaKamar, statusKamar, jenisKamar;
// int hargaKamar;