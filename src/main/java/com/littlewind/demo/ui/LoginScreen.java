package com.littlewind.demo.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.littlewind.demo.entity.Employee;
import com.littlewind.demo.service.EmployeeService;

@ComponentScan(basePackages = { "com.littlewind.demo" })
public class LoginScreen extends JFrame {
	@Autowired
	EmployeeService employeeService;
	
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField passwordField;

	public LoginScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720); // w: 454, h: 311
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setSize(new Dimension(1280,720));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(50, 248, 78, 23);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(50, 320, 78, 23);
		contentPane.add(lblPassword);
		
		username = new JTextField();
		username.setBounds(50, 284, 259, 23);
		contentPane.add(username);
		username.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(50, 356, 259, 22);
		contentPane.add(passwordField);
		
		// Add login button
		JButton btnLogin = new JButton("SIGN IN");
		btnLogin.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.setBackground(new Color(30, 144, 255));
		btnLogin.addActionListener(new ActionListener() {
			private Component frame;

			public void actionPerformed(ActionEvent arg0) {
				
				String uName = username.getText();
				String pass = new String(passwordField.getPassword());
				
				System.out.println(uName);
				System.out.println(pass);
				
				Employee employee = employeeService.finByUserName(uName);
				
				if (employee!=null && pass.equals(employee.getPassword())) {
					System.out.println(employee.toString());
					JOptionPane.showMessageDialog(frame, "Login successful");
				} else {
					JOptionPane.showMessageDialog(frame, "Invalid username or password");
				}
			}
		});
		btnLogin.setBounds(50, 391, 97, 25);
		contentPane.add(btnLogin);
		
		// Add label login
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblLogin.setBounds(50, 170, 247, 75);
		contentPane.add(lblLogin);
		
		
	}
}
