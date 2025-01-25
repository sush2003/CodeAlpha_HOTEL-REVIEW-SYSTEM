import java.util.*;

class HotelReviewSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Hotel> hotels = new ArrayList<>();
        List<Review> reviews = new ArrayList<>();

        // Sample hotels (replace with actual data)
        hotels.add(new Hotel("Hotel A", "City Center", 4.5));
        hotels.add(new Hotel("Hotel B", "Suburb", 3.8));
        hotels.add(new Hotel("Hotel C", "Beachfront", 4.2));

        // Sample reviews (replace with actual data)
        reviews.add(new Review("User1", "Hotel A", "Excellent service!", 5));
        reviews.add(new Review("User2", "Hotel B", "Clean rooms but noisy.", 3));
        reviews.add(new Review("User3", "Hotel C", "Beautiful location!", 4));

        int choice;
        do {
            System.out.println("\nHotel Review System Menu:");
            System.out.println("1. View Hotels");
            System.out.println("2. View Reviews");
            System.out.println("3. Add Review");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewHotels(hotels);
                    break;
                case 2:
                    viewReviews(reviews);
                    break;
                case 3:
                    addReview(hotels, reviews, scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    // View hotels
    public static void viewHotels(List<Hotel> hotels) {
        System.out.println("\nAvailable Hotels:");
        for (Hotel hotel : hotels) {
            System.out.println("Hotel Name: " + hotel.getName());
            System.out.println("Location: " + hotel.getLocation());
            System.out.println("Rating: " + hotel.getRating());
            System.out.println("--------------------");
        }
    }

    // View reviews
    public static void viewReviews(List<Review> reviews) {
        System.out.println("\nHotel Reviews:");
        for (Review review : reviews) {
            System.out.println("User: " + review.getUser());
            System.out.println("Hotel: " + review.getHotelName());
            System.out.println("Review: " + review.getReviewText());
            System.out.println("Rating: " + review.getRating());
            System.out.println("--------------------");
        }
    }

    // Add a new review
    public static void addReview(List<Hotel> hotels, List<Review> reviews, Scanner scanner) {
        System.out.print("Enter your name: ");
        String userName = scanner.next();
        System.out.print("Enter hotel name: ");
        String hotelName = scanner.next();
        System.out.print("Enter your review: ");
        scanner.nextLine(); // Consume newline character
        String reviewText = scanner.nextLine();
        System.out.print("Enter your rating (1-5): ");
        int rating = scanner.nextInt();

        // Find the hotel (replace with actual hotel search logic)
        Hotel hotel = findHotelByName(hotels, hotelName);
        if (hotel != null) {
            reviews.add(new Review(userName, hotelName, reviewText, rating));
            System.out.println("Review added successfully!");
        } else {
            System.out.println("Hotel not found.");
        }
    }

    // Helper method to find a hotel by name
    public static Hotel findHotelByName(List<Hotel> hotels, String hotelName) {
        for (Hotel hotel : hotels) {
            if (hotel.getName().equals(hotelName)) {
                return hotel;
            }
        }
        return null;
    }
}

class Hotel {
    private String name;
    private String location;
    private double rating;

    public Hotel(String name, String location, double rating) {
        this.name = name;
        this.location = location;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public double getRating() {
        return rating;
    }
}

class Review {
    private String user;
    private String hotelName;
    private String reviewText;
    private int rating;

    public Review(String user, String hotelName, String reviewText, int rating) {
        this.user = user;
        this.hotelName = hotelName;
        this.reviewText = reviewText;
        this.rating = rating;
    }

    public String getUser() {
        return user;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getReviewText() {
        return reviewText;
    }

    public int getRating() {
        return rating;
    }
}