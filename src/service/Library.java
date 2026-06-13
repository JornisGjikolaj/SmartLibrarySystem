package service;

import model.Book;
import model.Member;
import model.Loan;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();
    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String id) {
        books.removeIf(book -> book.getId().equals(id));
    }

    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public ArrayList<Book> getAllBooks() {
        return books;
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void borrowBook(Book book, Member member) {
        if (book != null && book.isAvailable()) {
            book.borrowBook();
            loans.add(new Loan(book, member));
        }
    }

    public void returnBook(Book book) {
        if (book != null) {
            book.returnBook();
        }
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }
}