package model;

/**
 * Represents a book in the Smart Library System.
 * Each book has an ID, title, and availability status.
 */
public class Book {

    private String id;
    private String title;
    private boolean available = true;

    /**
     * Creates a new Book object.
     *
     * @param id unique identifier of the book
     * @param title title of the book
     */
    public Book(String id, String title) {
        this.id = id;
        this.title = title;
    }

    /**
     * Returns the unique ID of the book.
     *
     * @return book ID
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the title of the book.
     *
     * @return book title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Checks if the book is available for borrowing.
     *
     * @return true if the book is available, false otherwise
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Marks the book as borrowed (not available).
     */
    public void borrowBook() {
        available = false;
    }

    /**
     * Marks the book as returned (available again).
     */
    public void returnBook() {
        available = true;
    }
}