package gui;

import model.Book;
import model.Member;
import service.Library;

import javax.swing.*;
import java.awt.*;

public class LibraryGUI extends JFrame {

    private Library library = new Library();

    private JTextField titleField;
    private JButton addButton;
    private JButton searchButton;
    private JButton borrowButton;
    private JButton returnButton;
    private JTextArea outputArea;

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

        outputArea = new JTextArea(15, 35);
        outputArea.setEditable(false);

        panel.add(titleLabel);
        panel.add(titleField);
        panel.add(addButton);
        panel.add(searchButton);
        panel.add(borrowButton);
        panel.add(returnButton);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        setVisible(true);

        // Borrow
        borrowButton.addActionListener(e -> {
            String title = titleField.getText();

            Book book = library.searchBook(title);

            if (book != null && book.isAvailable()) {

                Member dummyMember = new Member("M001", "Test User", "test@mail.com");

                library.borrowBook(book, dummyMember);

                outputArea.append("Borrowed: " + book.getTitle() + "\n");

            } else {
                outputArea.append("Book not available\n");
            }
        });

        // Return
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
    }
}