package Others;
import java.util.*;

class TrainBookingSystem {
    private static final int TOTAL_SEATS = 8;
    private static final int WAITING_LIST_LIMIT = 2;
    private static int nextPNR = 1;
    
    private static Map<Integer, Booking> bookings = new HashMap<>();
    private static List<WaitingListEntry> waitingList = new ArrayList<>();
    private static boolean[][] seatChart = new boolean[TOTAL_SEATS][5];
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine();
            String[] parts = command.split(",");
            
            if (parts[0].equals("book")) {
                bookTickets(parts[1], parts[2], Integer.parseInt(parts[3]));
            } else if (parts[0].equals("cancel")) {
                cancelTickets(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
            } else if (parts[0].equals("chart")) {
                printChart();
            } else {
                System.out.println("Invalid command!");
            }
           
        }   
        
    }

    // Method to book tickets for given source, destination, and seat count
    private static void bookTickets(String from, String to, int count) {
        int fromIndex = from.charAt(0) - 'A';
        int toIndex = to.charAt(0) - 'A';
        List<Integer> allocatedSeats = new ArrayList<>();
        
        // Check seat availability
        for (int seat = 0; seat < TOTAL_SEATS; seat++) {
            boolean available = true;
            for (int i = fromIndex; i < toIndex; i++) {
                if (seatChart[seat][i]) {
                    available = false;
                    break;
                }
            }
            if (available) {
                allocatedSeats.add(seat);
                if (allocatedSeats.size() == count) break;
            }
        }
        
        // Confirm booking if enough seats are available
        if (allocatedSeats.size() == count) {
            for (int seat : allocatedSeats) {
                for (int i = fromIndex; i < toIndex; i++) {
                    seatChart[seat][i] = true;
                }
            }
            bookings.put(nextPNR, new Booking(nextPNR, from, to, new ArrayList<>(allocatedSeats)));
            System.out.println("PNR " + nextPNR + " booked with seats: " + allocatedSeats);
            nextPNR++;
        } else if (waitingList.size() < WAITING_LIST_LIMIT) {
            // Add to waiting list if no seats are available
            waitingList.add(new WaitingListEntry(nextPNR, from, to, count));
            System.out.println("PNR " + nextPNR + " added to waiting list.");
            nextPNR++;
        } else {
            System.out.println("Booking failed. No seats available.");
        }
    }
    
    // Method to cancel booked tickets
    private static void cancelTickets(int pnr, int count) {
        if (!bookings.containsKey(pnr)) {
            System.out.println("PNR not found.");
            return;
        }
        
        Booking booking = bookings.get(pnr);
        List<Integer> seatsToCancel = booking.seats.subList(0, Math.min(count, booking.seats.size()));
        
        // Free up the seats
        for (int seat : seatsToCancel) {
            for (int i = booking.from.charAt(0) - 'A'; i < booking.to.charAt(0) - 'A'; i++) {
                seatChart[seat][i] = false;
            }
        }
        booking.seats.removeAll(seatsToCancel);
        
        // Remove booking entry if no seats are left
        if (booking.seats.isEmpty()) bookings.remove(pnr);
        
        System.out.println("Cancelled " + count + " seats from PNR " + pnr);
        processWaitingList(); // Check and process waiting list after cancellation
    }
    
    // Method to process the waiting list and allocate newly available seats
    private static void processWaitingList() {
        Iterator<WaitingListEntry> iterator = waitingList.iterator();
        while (iterator.hasNext()) {
            WaitingListEntry entry = iterator.next();
            bookTickets(entry.from, entry.to, entry.count);
            iterator.remove();
        }
    }
    
    // Method to print the current seat booking chart
    private static void printChart() {
        System.out.println("Train Seat Chart:");
        System.out.println("    A  B  C  D  E");
        for (int i = 0; i < TOTAL_SEATS; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 5; j++) {
                System.out.print((seatChart[i][j] ? " * " : " - ") + " ");
            }
            System.out.println();
        }
    }
    
    // Class to represent a confirmed booking
    static class Booking {
        int pnr;
        String from, to;
        List<Integer> seats;
        Booking(int pnr, String from, String to, List<Integer> seats) {
            this.pnr = pnr;
            this.from = from;
            this.to = to;
            this.seats = seats;
        }
    }
    
    // Class to represent a waiting list entry
    static class WaitingListEntry {
        int pnr;
        String from, to;
        int count;
        WaitingListEntry(int pnr, String from, String to, int count) {
            this.pnr = pnr;
            this.from = from;
            this.to = to;
            this.count = count;
        }
    }
}
