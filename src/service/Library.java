package service;

import model.Book;
import model.Member;
import model.Loan;
import model.Book;
import model.Member;
import service.Library;
import java.util.ArrayList;

/**
 * Library class that manages books, members, and loans.
 */
public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();

    /**
     * Adds a new book to the library.
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Searches for a book by title.
     */
    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    /**
     * Borrows a book for a member.
     */
    public void borrowBook(Book book, Member member) {
        if (book != null && book.isAvailable()) {
            book.borrowBook();
            loans.add(new Loan(book, member));
        }
    }

    /**
     * Returns a borrowed book.
     */
    public void returnBook(Book book) {
        if (book != null) {
            book.returnBook();
        }
    }

    /**
     * Returns all books in the library.
     */
    public ArrayList<Book> getAllBooks() {
        return books;
    }
}