package com.halstead.projects.javaAppTest;

import java.awt.EventQueue;
import org.json.JSONObject;
import org.json.JSONArray;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JLabel;

public class MainWindow {

	private JFrame frmMainWindow;
	private JTextField usernameIn;
	private JPasswordField passwordIn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmMainWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}
	
	public void doActionCheck() {
		
		//JSONObject obj = new JSONObject(arg0);
		//JOptionPane.showMessageDialog(null, obj.toString());
		
		frmMainWindow.hide();
		if(new String(usernameIn.getText()).equalsIgnoreCase("username") & Arrays.equals( "psw".toCharArray(), passwordIn.getPassword() )) {
			JOptionPane.showConfirmDialog(frmMainWindow, "Would you Like to Login?", "Confirm Login?", 0);
		}
		else if(usernameIn.getText().equals("") & Arrays.equals("".toCharArray(), passwordIn.getPassword()) ) {
			JOptionPane.showMessageDialog(frmMainWindow, "OYYY, OYY, OYYY\nI NEED A LOGIN!");
		}
		else {
			JOptionPane.showMessageDialog(frmMainWindow, "Username or Password does not match what is Registered with the System!", "No Login", 3);	
		}
		
		usernameIn.setText("");
		passwordIn.setText("");
		frmMainWindow.show();
		usernameIn.grabFocus();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainWindow = new JFrame();
		frmMainWindow.setResizable(false);
		frmMainWindow.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nhalstead\\Documents\\GitHub\\JavaApplicationTest\\project_icons\\icon-testing-automation.png"));
		frmMainWindow.setTitle("Java Testing App");
		frmMainWindow.setBounds(100, 100, 500, 400);
		frmMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); // Assist for the Next Action
		frmMainWindow.setLocation(dim.width/2-frmMainWindow.getSize().width/2, dim.height/2-frmMainWindow.getSize().height/2); // Center the Window on the Screen
		
		usernameIn = new JTextField();
		usernameIn.setBounds(139, 113, 330, 35);
		usernameIn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					passwordIn.grabFocus();
		        }
			}
		});
		usernameIn.setColumns(10);
		
		JButton checkLogin = new JButton("Login");
		checkLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkLogin.setBounds(163, 260, 131, 29);
		checkLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doActionCheck();
			}
		});
		
		checkLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		checkLogin.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		
		passwordIn = new JPasswordField();
		passwordIn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					doActionCheck();
		        }
			}
		});
		passwordIn.setBounds(139, 159, 330, 35);
		frmMainWindow.getContentPane().setLayout(null);
		frmMainWindow.getContentPane().add(checkLogin);
		frmMainWindow.getContentPane().add(passwordIn);
		frmMainWindow.getContentPane().add(usernameIn);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername.setBounds(54, 122, 75, 14);
		frmMainWindow.getContentPane().add(lblUsername);
		
		JLabel lblPasword = new JLabel("Password");
		lblPasword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPasword.setBounds(54, 169, 75, 14);
		frmMainWindow.getContentPane().add(lblPasword);
	}
}