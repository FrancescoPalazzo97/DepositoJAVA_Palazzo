package esercizio_2;

import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<Room> rooms;

    public Hotel(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
    }

    public Hotel(String name, ArrayList<Room> rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Room> getRooms() {
        return this.rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    static public int getRoomsCounter(ArrayList<Room> roomsList) {
        int counter = 0;

        for (Room room : roomsList) {
            if (!(room instanceof Suite)) {
                continue;
            }

            counter++;
        }

        return counter;
    }
}
