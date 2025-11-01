package Challenge;
import java.util.*;

public class LinkedListChallenge {

    // Place class to store town name and distance from Sydney
    static class Place {
        private String name;
        private int distanceFromSydney;

        public Place(String name, int distanceFromSydney) {
            this.name = name;
            this.distanceFromSydney = distanceFromSydney;
        }

        public String getName() {
            return name;
        }

        public int getDistanceFromSydney() {
            return distanceFromSydney;
        }

        @Override
        public String toString() {
            return name + " (" + distanceFromSydney + " km from Sydney)";
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Place place = (Place) obj;
            return Objects.equals(name, place.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public static void main(String[] args) {
        LinkedList<Place> places = new LinkedList<>();

        // Add Sydney as the first element
        places.add(new Place("Sydney", 0));

        // Add other places , they will be inserted in order by distance
        addPlace(places, new Place("Melbourne", 877));
        addPlace(places, new Place("Brisbane", 917));
        addPlace(places, new Place("Adelaide", 1374));
        addPlace(places, new Place("Alice Springs", 2771));
        addPlace(places, new Place("Perth", 3923));
        addPlace(places, new Place("Darwin", 3972));

        // Create iterator and start the interactive program
        ListIterator<Place> iterator = places.listIterator();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true; // Track direction

        printMenu();

        while (!quit) {
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().toUpperCase();

            switch (input) {
                case "F":
                case "FORWARD":
                    if (!forward) {
                        // Changing direction from backward to forward
                        if (iterator.hasNext()) {
                            iterator.next(); // Adjust cursor position
                        }
                        forward = true;
                    }

                    if (iterator.hasNext()) {
                        Place place = iterator.next();
                        System.out.println("Moving FORWARD to: " + place);
                    } else {
                        System.out.println("You've reached the end of the itinerary!");
                        forward = false; // Can only go backward now
                    }
                    break;

                case "B":
                case "BACKWARD":
                    if (forward) {
                        // Changing direction from forward to backward
                        if (iterator.hasPrevious()) {
                            iterator.previous(); // Adjust cursor position
                        }
                        forward = false;
                    }

                    if (iterator.hasPrevious()) {
                        Place place = iterator.previous();
                        System.out.println("Moving BACKWARD to: " + place);
                    } else {
                        System.out.println("You're at the beginning of the itinerary!");
                        forward = true; // Can only go forward now
                    }
                    break;

                case "L":
                case "LIST PLACES":
                    System.out.println("\n=== COMPLETE ITINERARY ===");
                    for (Place place : places) {
                        System.out.println(place);
                    }
                    System.out.println("==========================\n");
                    break;

                case "M":
                case "MENU":
                    printMenu();
                    break;

                case "Q":
                case "QUIT":
                    quit = true;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    // Helper method to add places in sorted order by distance
    private static void addPlace(LinkedList<Place> places, Place newPlace) {
        // Check for duplicates
        if (places.contains(newPlace)) {
            System.out.println("Duplicate place found: " + newPlace.getName());
            return;
        }

        ListIterator<Place> iterator = places.listIterator();
        while (iterator.hasNext()) {
            Place current = iterator.next();
            if (newPlace.getDistanceFromSydney() < current.getDistanceFromSydney()) {
                iterator.previous(); // Go back one position
                iterator.add(newPlace);
                return;
            }
        }

        // If we get here, add at the end
        places.add(newPlace);
    }

    private static void printMenu() {
        System.out.println("\n=== AUSTRALIA ITINERARY MENU ===");
        System.out.println("Available actions (select word or letter):");
        System.out.println("  (F)orward - Move to next destination");
        System.out.println("  (B)ackward - Move to previous destination");
        System.out.println("  (L)ist Places - Show complete itinerary");
        System.out.println("  (M)enu - Show this menu");
        System.out.println("  (Q)uit - Exit the program");
        System.out.println("=================================\n");
    }
}