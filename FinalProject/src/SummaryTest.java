import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Class representing a Guest
class Guest {
    private String name;
    private int age;
    private int roomId;

    public Guest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}

// Class for File Handling
class FileHandler {
    private static final String GUEST_FILE_PATH = "guests.txt";

    // Methods to read/write guest information from/to the file
    public static void writeGuestToFile(Guest guest) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(GUEST_FILE_PATH, true));
            writer.write(guest.getName() + "," + guest.getAge() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Guest> readGuestsFromFile() {
        List<Guest> guests = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(GUEST_FILE_PATH));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                guests.add(new Guest(name, age));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return guests;
    }
}

// Class for Database Handling (JDBC)
class DatabaseHandler {
    private static final String DB_URL = "jdbc:hsqldb:hsql://localhost/xdb";
    private static final String DB_USER = "SA";
    private static final String DB_PASSWORD = "";

    public static void readDataFromDatabase() {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement statement = conn.createStatement();

            // Execute the query
            ResultSet result = statement.executeQuery("SELECT * FROM HOTEL420");

            // Process the result if any
            while (result.next()) {
                System.out.println("ROOMNO : " + result.getInt(1));
                System.out.println("NAME   : " + result.getString(2));
                System.out.println("AVAILABE: " + result.getString(3));
                System.out.println("-------------");
            }

            result.close();
            statement.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateDatabase(Guest guest) {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Prepare the insert statement
            String insertSql = "INSERT INTO HOTEL420 (ROOMNO, NAME, AVAILABE) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertSql);

            // Set the values for the parameters in the insert statement
            preparedStatement.setInt(1, guest.getRoomId());
            preparedStatement.setString(2, guest.getName());
            preparedStatement.setBoolean(3, true); // Assuming the guest is always available when checking in

            // Execute the insert statement
            preparedStatement.executeUpdate();

            preparedStatement.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

// Class representing the Hotel Management System
class Hotel {
    private List<Guest> guests;
    private int currentRoomNumber;

    public Hotel() {
        guests = new ArrayList<>();
        currentRoomNumber = 1;
    }

    public void checkIn(Guest guest) {
        int roomId = currentRoomNumber++;
        guest.setRoomId(roomId);
        guests.add(guest);
        FileHandler.writeGuestToFile(guest);
    }

    public void checkOut(Guest guest) {
        int roomIdToRemove = guest.getRoomId();
        Iterator<Guest> iterator = guests.iterator();

        while (iterator.hasNext()) {
            Guest guestInList = iterator.next();
            if (guestInList.getRoomId() == roomIdToRemove) {
                iterator.remove();
            }
        }
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void processReservations(List<Guest> guests) {
        List<Thread> threads = new ArrayList<>();

        for (Guest guest : guests) {
            ReservationHandler reservationHandler = new ReservationHandler(guest);

            Thread thread = new Thread(reservationHandler);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ReservationHandler implements Runnable {
        private Guest guest;
        private Hotel hotel;

        public ReservationHandler(Guest guest) {
            this.guest = guest;
        }

        @Override
        public void run() {
            hotel.checkIn(guest);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hotel.checkOut(guest);
        }
    }
}

public class SummaryTest {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        List<Guest> arrivingGuests = new ArrayList<>();
        arrivingGuests.add(new Guest("John Doe", 30));
        arrivingGuests.add(new Guest("Alice Smith", 25));

        hotel.processReservations(arrivingGuests);

        List<Guest> guests = hotel.getGuests();
        for (Guest guest : guests) {
            System.out.println("Guest Name: " + guest.getName());
            System.out.println("Guest Age: " + guest.getAge());
            System.out.println("Guest Room ID: " + guest.getRoomId());
            System.out.println("---------------");
        }

        List<Guest> guestsFromFile = FileHandler.readGuestsFromFile();
        for (Guest guest : guestsFromFile) {
            System.out.println("Guest Name from File: " + guest.getName());
            System.out.println("Guest Age from File: " + guest.getAge());
            System.out.println("Guest Room ID from File: " + guest.getRoomId());
            System.out.println("---------------");
        }

        DatabaseHandler.readDataFromDatabase();
    }
}