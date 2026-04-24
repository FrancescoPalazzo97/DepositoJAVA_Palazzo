package esercizio_2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Hotel hotel1 = new Hotel("La Quercia", new ArrayList<>(List.of(
                new Room(),
                new Suite("Vista mare"),
                new Suite(),
                new Room(),
                new Room(),
                new Suite("Jacuzzi"),
                new Room())));

        for (Room room : hotel1.getRooms()) {
            System.out.println("==========");
            room.printDetails();
        }

        System.out.println(
                "Nel hotel " + hotel1.getName() + " ci sono " + Hotel.getRoomsCounter(hotel1.getRooms()) + " Suite");

    }

}
