package movie_project;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Step 1: Parsing the Text File
        // Read the text file containing movie showings
        String filePath = "Database.txt";
        LinkedListNode cinemasList = null; // Linked List for Cinemas
        MovieHashMap movieMap = new MovieHashMap(); // HashMap for Movies

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            // Skip the header line
            if (scanner.hasNextLine()) {
                scanner.nextLine(); // Skip header line
            }

            // Define date and time format
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy,HH:mm", Locale.ENGLISH);

            // Read each line of the file and parse its contents
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                // Assuming each line has format: cinemaName,movieName,date,time
                if (parts.length == 4) {
                    String cinemaName = parts[0].trim();
                    String movieName = parts[1].trim();
                    LocalDateTime dateTime = LocalDateTime.parse(parts[2].trim() + "," + parts[3].trim(), dateFormatter);

                    // Create Cinema and Movie objects if they don't exist in the data structures
                    Cinema cinema = findOrCreateCinema(cinemasList, cinemaName);
                    Movie movie = findOrCreateMovie(movieMap, movieName);

                    // Create Showing object and add it to the BST for the movie
                    Showing showing = new Showing(dateTime, cinema);
                    addShowingToMovieBST(movieMap, movieName, showing);
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
            return;
        }

        // Step 4: Searching for Earliest Showing Time and Date
        // Ask the user for the movie they want to watch
        Scanner userInputScanner = new Scanner(System.in);
        System.out.print("Enter the name of the movie you want to watch: ");
        String movieNameToSearch = userInputScanner.nextLine().trim();

        // Search for the earliest showing time and date
        BinaryTreeNode movieToShowings = movieMap.getMovie(movieNameToSearch);

        // Step 5: Outputting the Result
        if (movieToShowings != null) {
            // Assuming the BST is sorted by date and time, the earliest showing will be the leftmost node
            Showing earliestShowing = findEarliestShowing(movieToShowings);
            System.out.println("Earliest Showing for " + movieNameToSearch + ": " + earliestShowing.getDateTime().toString().replace("T", " ")
                    + " at " + earliestShowing.getCinema().getName());
        } else {
            System.out.println("Movie not found!");
        }
    }

    private static Cinema findOrCreateCinema(LinkedListNode cinemasList, String cinemaName) {
        LinkedListNode current = cinemasList;
        while (current != null) {
            if (current.getCinema().getName().equals(cinemaName)) {
                return current.getCinema();
            }
            current = current.getNext();
        }
        // If cinema not found, create a new one and add it to the linked list
        Cinema newCinema = new Cinema(cinemaName);
        LinkedListNode newNode = new LinkedListNode(newCinema);
        newNode.setNext(cinemasList);
        return newCinema;
    }

    private static Movie findOrCreateMovie(MovieHashMap movieMap, String movieName) {
        BinaryTreeNode movieNode = movieMap.getMovie(movieName);
        if (movieNode != null) {
            return new Movie(movieName); // Return a new Movie object
        } else {
            Movie newMovie = new Movie(movieName);
            movieMap.addMovie(movieName, null); // Add movie to map with null root node for BST
            return newMovie;
        }
    }

    private static void addShowingToMovieBST(MovieHashMap movieMap, String movieName, Showing showing) {
        BinaryTreeNode rootNode = movieMap.getMovie(movieName);
        if (rootNode == null) {
            // If movie not found in BST, create a new root node
            movieMap.addMovie(movieName, new BinaryTreeNode(showing));
        } else {
            // Otherwise, insert showing into the BST
            insertIntoBST(rootNode, showing);
        }
    }

    private static void insertIntoBST(BinaryTreeNode root, Showing showing) {
        if (showing.getDateTime().isBefore(root.getShowing().getDateTime())) {
            if (root.getLeft() == null) {
                root.setLeft(new BinaryTreeNode(showing));
            } else {
                insertIntoBST(root.getLeft(), showing);
            }
        } else {
            if (root.getRight() == null) {
                root.setRight(new BinaryTreeNode(showing));
            } else {
                insertIntoBST(root.getRight(), showing);
            }
        }
    }

    private static Showing findEarliestShowing(BinaryTreeNode rootNode) {
        BinaryTreeNode current = rootNode;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current.getShowing();
    }
}
