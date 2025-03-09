import java.util.Scanner;

public class MovieRatingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Get user's name
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "! Welcome to the Movie Rating System.\n");

        // Step 2: Collect movie names and ratings
        int numberOfMovies = 5;
        String[] movies = new String[numberOfMovies];
        int[] ratings = new int[numberOfMovies];

        for (int i = 0; i < numberOfMovies; i++) {
            // Get movie name
            System.out.print("Enter the name of movie #" + (i + 1) + ": ");
            movies[i] = scanner.nextLine();

            // Get and validate movie rating
            int rating;
            while (true) {
                System.out.print("Rate " + movies[i] + " (1-10): ");
                if (scanner.hasNextInt()) {
                    rating = scanner.nextInt();
                    if (rating >= 1 && rating <= 10) {
                        break; // Valid rating, exit loop
                    } else {
                        System.out.println("Invalid input! Please enter a rating between 1 and 10.");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a number between 1 and 10.");
                    scanner.next(); // Clear invalid input
                }
            }
            ratings[i] = rating;
            scanner.nextLine(); // Consume newline character
        }

        // Step 3: Calculate Average Rating
        int sum = 0;
        for (int rating : ratings) {
            sum += rating;
        }
        double averageRating = (double) sum / numberOfMovies;
        System.out.printf("\nYour average movie rating: %.2f\n", averageRating);

        // Step 4: Classify Movie Taste
        if (averageRating >= 9) {
            System.out.println("You are a movie connoisseur!");
        } else if (averageRating >= 7) {
            System.out.println("You enjoy movies quite alot.");
        } else if (averageRating >= 5) {
            System.out.println("You have complicated feelings about movies.");
        } else {
            System.out.println("You are a tough critic!");
        }

        // Step 5: Check for Favorite or Least Favorite Movies
        boolean foundMasterpiece = false;
        boolean foundBadMovie = false;
        for (int rating : ratings) {
            if (rating == 10) {
                foundMasterpiece = true;
            }
            if (rating < 4) {
                foundBadMovie = true;
            }
        }
        if (foundMasterpiece) {
            System.out.println("Amazing! You found a masterpiece.");
        }
        if (foundBadMovie) {
            System.out.println("That movie was a letdown.");
        }

        // Step 6: Identify Consistent Ratings using Logical Operators
        boolean allHighRatings = true;
        boolean veryLowRating = false;
        for (int rating : ratings) {
            if (rating < 7) {
                allHighRatings = false;
            }
            if (rating < 3) {
                veryLowRating = true;
            }
        }
        if (allHighRatings) {
            System.out.println("You seem to enjoy most kinds of movies.");
        } else if (veryLowRating) {
            System.out.println("You have strong opinions on movies!");
        }

        // Step 7: Ask for Favorite Movie Genre
        System.out.println("\nChoose your favorite movie genre:");
        System.out.println("1. Action\n2. Comedy\n3. Horror\n4. Drama\n5. Sci-Fi");
        System.out.print("Enter the number corresponding to your choice: ");
        
        int genreChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        switch (genreChoice) {
            case 1 -> System.out.println("You love excitement and fights!");
            case 2 -> System.out.println("You love to laugh.");
            case 3 -> System.out.println("You want to be scared!");
            case 4 -> System.out.println("You love the gossip.");
            case 5 -> System.out.println("You love futuristic stuff!");
            default -> System.out.println("Error! But movies are great.");
        }

        // Step 8: Recommend a Movie using Conditional Operator
        String recommendedMovie = (genreChoice == 1) ? "The Gorge" : "The Justice League";
        System.out.println("We recommend you watch: " + recommendedMovie);

        scanner.close();
    }
}
