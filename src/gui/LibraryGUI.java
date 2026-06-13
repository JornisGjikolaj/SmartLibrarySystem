package gui;

import javax.swing.*;
import java.awt.*;

public class LibraryGUI extends JFrame {

    private JTextField titleField;
    private JButton addButton;
    private JButton searchButton;
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

        outputArea = new JTextArea(15, 35);
        outputArea.setEditable(false);

        panel.add(titleLabel);
        panel.add(titleField);
        panel.add(addButton);
        panel.add(searchButton);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        setVisible(true);
    }
}