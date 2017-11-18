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

public class MainWindow {

	private JFrame frmMainWindow;
	private JTextField commandIn;

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
		if(new String(commandIn.getText()).equalsIgnoreCase("shutdown")) {
			JOptionPane.showConfirmDialog(null, "Would you Like to Shutdown?", "Shutdown?", 0);
		}
		else if(new String(commandIn.getText()).equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "OYYY, OYY, OYYY\nI NEED A COMMAND!");
		}
		else {
			JOptionPane.showMessageDialog(null, new String(commandIn.getText()));
		}
		
		commandIn.setText("");
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
		
		commandIn = new JTextField();
		commandIn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					doActionCheck();
		        }
			}
		});
		commandIn.setColumns(10);
		
		JButton btnClickMe = new JButton("Check System");
		btnClickMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doActionCheck();
			}
		});
		
		btnClickMe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClickMe.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		GroupLayout groupLayout = new GroupLayout(frmMainWindow.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(70, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(commandIn, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)
							.addGap(39))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnClickMe, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addGap(151))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(110)
					.addComponent(commandIn, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(btnClickMe, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(105, Short.MAX_VALUE))
		);
		frmMainWindow.getContentPane().setLayout(groupLayout);
	}
}