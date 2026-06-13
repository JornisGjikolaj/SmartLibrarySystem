package gui;

import model.Book;
import model.Member;
import service.Library;

import javax.swing.*;
import java.awt.*;

/**
 * Graphical User Interface for the Smart Library System.
 * Allows users to add, search, borrow, return, and display books.
 */
public class LibraryGUI extends JFrame {

    private Library library = new Library();

    private JTextField titleField;
    private JButton addButton;
    private JButton searchButton;
    private JButton borrowButton;
    private JButton returnButton;
    private JButton showAllButton;
    private JTextArea outputArea;

    /**
     * Creates and initializes the Library GUI.
     */
    public LibraryGUI() {

        setTitle("Smart Library System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel titleLabel = new JLabel("Book Title:");
        titleField = new JTextField(20);

        addButton = new JButton("Add Book");
        searchButton = new JButton("Search Book");
        borrowButton = new JButton("Borrow Book");
        returnButton = new JButton("Return Book");
        showAllButton = new JButton("Show All Books");

        outputArea = new JTextArea(15, 35);
        outputArea.setEditable(false);

        // Add components
        panel.add(titleLabel);
        panel.add(titleField);
        panel.add(addButton);
        panel.add(searchButton);
        panel.add(borrowButton);
        panel.add(returnButton);
        panel.add(showAllButton);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        setVisible(true);

        // ---------------------------
        // ADD BOOK
        // ---------------------------
        addButton.addActionListener(e -> {
            String title = titleField.getText();

            Book book = new Book(
                    String.valueOf(System.currentTimeMillis()),
                    title
            );

            library.addBook(book);

            outputArea.append("Added: " + title + "\n");
        });

        // ---------------------------
        // SEARCH BOOK
        // ---------------------------
        searchButton.addActionListener(e -> {
            String title = titleField.getText();

            Book book = library.searchBook(title);

            if (book != null) {
                outputArea.append("FOUND: " + book.getTitle() + "\n");
            } else {
                outputArea.append("Book not found\n");
            }
        });

        // ---------------------------
        // BORROW BOOK
        // ---------------------------
        borrowButton.addActionListener(e -> {
            String title = titleField.getText();

            Book book = library.searchBook(title);

            if (book != null && book.isAvailable()) {

                Member dummyMember = new Member("M001", "Test User");

                library.borrowBook(book, dummyMember);

                outputArea.append("Borrowed: " + book.getTitle() + "\n");

            } else {
                outputArea.append("Book not available\n");
            }
        });

        // ---------------------------
        // RETURN BOOK
        // ---------------------------
        returnButton.addActionListener(e -> {
            String title = titleField.getText();

            Book book = library.searchBook(title);

            if (book != null) {

                library.returnBook(book);

                outputArea.append("Returned: " + book.getTitle() + "\n");

            } else {
                outputArea.append("Book not found\n");
            }
        });

        // ---------------------------
        // SHOW ALL BOOKS
        // ---------------------------
        showAllButton.addActionListener(e -> {
            outputArea.setText("");

            for (Book book : library.getAllBooks()) {
                outputArea.append(book.getTitle() + "\n");
            }
        });
    }
}