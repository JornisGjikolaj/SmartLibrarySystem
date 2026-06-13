package service;

import model.Book;
import model.Member;
import model.Loan;

import java.util.ArrayList;

/**
 * Library class that manages books, members, and loans.
 */
public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();

    // -------------------
    // ADD BOOK
    // -------------------

    /**
     * Adds a new book to the library.
     *
     * @param book the book to add
     */
    public void addBook(Book book) {
        books.add(book);
    }

    // -------------------
    // SEARCH BOOK
    // -------------------

    /**
     * Searches for a book by title.
     *
     * @param title title of the book
     * @return the book if found, otherwise null
     */
    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // -------------------
    // BORROW BOOK
    // -------------------

    /**
     * Borrows a book for a member.
     *
     * @param book the book to borrow
     * @param member the member borrowing the book
     */
    public void borrowBook(Book book, Member member) {
        if (book != null && book.isAvailable()) {
            book.borrowBook();
            loans.add(new Loan(book, member));
        }
    }

    // -------------------
    // RETURN BOOK
    // -------------------

    /**
     * Returns a borrowed book.
     *
     * @param book the book to return
     */
    public void returnBook(Book book) {
        if (book != null) {
            book.returnBook();
        }
    }

    // -------------------
    // GET ALL BOOKS
    // -------------------

    /**
     * Returns all books in the library.
     *
     * @return list of all books
     */
    public ArrayList<Book> getAllBooks() {
        return books;
    }
}