package gui;

import constants.CommonConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.*;

public class LoginGUI extends JFrame {
    public LoginGUI() {
        super(CommonConstants.APP_NAME);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(CommonConstants.FRAME_SIZE[0], CommonConstants.FRAME_SIZE[1]);
        setResizable(false);
        setLocationRelativeTo(null);

        addGUIComponents();
    }

    public void addGUIComponents() {
        SpringLayout springLayout = new SpringLayout();
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(springLayout);

        // username
        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        JTextField usernameField = new JTextField(CommonConstants.TEXTFIELD_SIZE);
        usernameField.setFont(new Font("Dialog", Font.PLAIN, 18));

        springLayout.putConstraint(SpringLayout.WEST, usernameLabel, 35, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, usernameLabel, 85, SpringLayout.NORTH, loginPanel);
        springLayout.putConstraint(SpringLayout.WEST, usernameField, 135, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, usernameField, 85, SpringLayout.NORTH, loginPanel);

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);

        // password
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        JPasswordField passwordField = new JPasswordField(CommonConstants.TEXTFIELD_SIZE);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 18));

        springLayout.putConstraint(SpringLayout.WEST, passwordLabel, 35, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, passwordLabel, 135, SpringLayout.NORTH, loginPanel);
        springLayout.putConstraint(SpringLayout.WEST, passwordField, 135, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, passwordField, 135, SpringLayout.NORTH, loginPanel);

        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);

        // login button
        JButton jButton = new JButton("Login");
        jButton.setFont(new Font("Dialog", Font.BOLD, 18));
        jButton.setForeground(new Color(255, 255, 255));
        jButton.setBackground(new Color(0, 0, 0));

        springLayout.putConstraint(SpringLayout.WEST, jButton, 150, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, jButton, 250, SpringLayout.NORTH, loginPanel);
        // posso fazer diferente usando =     jButton.setBounds(0, 0, 150, 150);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String username = usernameField.getText();
                String password = passwordField.getText();

                if (username.equals("username") && password.equals("password")) {
                    System.out.println("LOGIN SUCCESSFUL!");
                    JOptionPane.showMessageDialog(null, "Login Successful!", "Login",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Login Failed!", "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        loginPanel.add(jButton);

        this.getContentPane().add(loginPanel);
    }
}
