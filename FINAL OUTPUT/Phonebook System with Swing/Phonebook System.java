import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhonebookSystem extends JFrame implements ActionListener {
    private JTextField nameField, phoneField;
    private JTextArea contactArea;
    private JButton addButton, deleteButton, searchButton, updateButton, displayButton;
    private final File contactFile = new File("phonebook.txt");

    public PhonebookSystem() {
        // Initialize UI components
        setTitle("Phonebook System");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(240, 248, 255)); // Light blue background

        // Input Panel
        JPanel inputPanel = createInputPanel();
        JPanel buttonPanel = createButtonPanel();
        JPanel textAreaPanel = createTextAreaPanel();

        // Add panels to the main panel
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(textAreaPanel, BorderLayout.SOUTH);

        add(mainPanel);
        loadContacts();
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        inputPanel.setBackground(new Color(173, 216, 230)); // Light blue
        inputPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(70, 130, 180)), 
                "Add or Search Contact",
                0, 0, 
                new Font("Verdana", Font.BOLD, 14), 
                new Color(25, 25, 112)
        )); // Navy blue title

        nameField = new JTextField(15);
        phoneField = new JTextField(15);
        JLabel nameLabel = new JLabel("Name:");
        JLabel phoneLabel = new JLabel("Phone:");

        nameLabel.setFont(new Font("Verdana", Font.BOLD, 14));
        nameLabel.setForeground(new Color(25, 25, 112)); // Navy blue
        phoneLabel.setFont(new Font("Verdana", Font.BOLD, 14));
        phoneLabel.setForeground(new Color(25, 25, 112)); // Navy blue

        phoneField.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                String text = ((JTextField) input).getText();
                if (!text.matches("\\d*")) {
                    JOptionPane.showMessageDialog(PhonebookSystem.this,
                            "Phone number must contain only digits!",
                            "Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                return true;
            }
        });

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(phoneLabel);
        inputPanel.add(phoneField);
        return inputPanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        buttonPanel.setBackground(new Color(240, 248, 255)); // Light blue
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        addButton = createStyledButton("Add");
        deleteButton = createStyledButton("Delete");
        searchButton = createStyledButton("Search");
        updateButton = createStyledButton("Update");
        displayButton = createStyledButton("Display");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(displayButton);

        return buttonPanel;
    }

    private JPanel createTextAreaPanel() {
        JPanel textAreaPanel = new JPanel(new BorderLayout());
        textAreaPanel.setBackground(new Color(173, 216, 230)); // Light blue
        textAreaPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(70, 130, 180)), 
                "Contacts",
                0, 0, 
                new Font("Verdana", Font.BOLD, 14), 
                new Color(25, 25, 112)
        )); // Navy blue title

        contactArea = new JTextArea(12, 20);
        contactArea.setEditable(false);
        contactArea.setFont(new Font("Courier New", Font.PLAIN, 14)); // Monospaced font
        contactArea.setBackground(new Color(240, 250, 255)); // Lightest blue
        contactArea.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        JScrollPane scrollPane = new JScrollPane(contactArea);
        textAreaPanel.add(scrollPane, BorderLayout.CENTER);

        return textAreaPanel;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(90, 30));
        button.setFont(new Font("Verdana", Font.BOLD, 12));
        button.setBackground(new Color(70, 130, 180)); // Steel blue
        button.setForeground(Color.WHITE); // White text
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(25, 25, 112))); // Navy blue border
        button.addActionListener(this);
        return button;
    }

    // All other methods remain the same (addContact, deleteContact, etc.)

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            addContact();
        } else if (e.getSource() == deleteButton) {
            deleteContact();
        } else if (e.getSource() == searchButton) {
            searchContact();
        } else if (e.getSource() == updateButton) {
            updateContact();
        } else if (e.getSource() == displayButton) {
            loadContacts();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PhonebookSystem().setVisible(true));
    }
}
