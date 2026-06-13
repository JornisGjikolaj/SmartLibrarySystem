package model;

/**
 * Represents a loan transaction in the Smart Library System.
 * A loan connects a Book with a Member who borrowed it.
 */
public class Loan {

    private Book book;
    private Member member;

    /**
     * Creates a new Loan object linking a book and a member.
     *
     * @param book the borrowed book
     * @param member the member who borrowed the book
     */
    public Loan(Book book, Member member) {
        this.book = book;
        this.member = member;
    }

    /**
     * Returns the borrowed book.
     *
     * @return the book in this loan
     */
    public Book getBook() {
        return book;
    }

    /**
     * Returns the member who borrowed the book.
     *
     * @return the member in this loan
     */
    public Member getMember() {
        return member;
    }

    /**
     * Returns a readable representation of the loan.
     *
     * @return formatted loan information
     */
    @Override
    public String toString() {
        return "Loan{" +
                "book=" + book.getTitle() +
                ", member=" + member.getName() +
                '}';
    }
}