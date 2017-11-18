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
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import java.awt.Insets;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

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
		
		if(new String(usernameIn.getText()).equalsIgnoreCase("username") & Arrays.equals( "psw".toCharArray(), passwordIn.getPassword() )) {
			frmMainWindow.hide();
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
		frmMainWindow.addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
			}
			public void windowLostFocus(WindowEvent arg0) {
				frmMainWindow.requestFocus();
				//JOptionPane.showMessageDialog(frmMainWindow, "Baby come back!", "Don't Leave Me!", 2);
			}
		});
		frmMainWindow.setResizable(false);
		frmMainWindow.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nhalstead\\Documents\\GitHub\\JavaApplicationTest\\project_icons\\icon-testing-automation.png"));
		frmMainWindow.setTitle("Java Testing App");
		frmMainWindow.setBounds(100, 100, 600, 500);
		frmMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); // Assist for the Next Action
		frmMainWindow.setLocation(dim.width/2-frmMainWindow.getSize().width/2, dim.height/2-frmMainWindow.getSize().height/2);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		passwordIn = new JPasswordField();
		passwordIn.setMargin(new Insets(4, 4, 4, 4));
		passwordIn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					doActionCheck();
		        }
			}
		});
		
		usernameIn = new JTextField();
		usernameIn.setMargin(new Insets(4, 4, 4, 4));
		usernameIn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					passwordIn.grabFocus();
		        }
			}
		});
		usernameIn.setColumns(10);
		
		JLabel lblPasword = new JLabel("Password");
		lblPasword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton checkLogin = new JButton("Login");
		checkLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doActionCheck();
			}
		});
		
		checkLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		checkLogin.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		GroupLayout groupLayout = new GroupLayout(frmMainWindow.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(107)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(usernameIn, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPasword, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(passwordIn, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)))
					.addGap(83))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(249)
					.addComponent(checkLogin, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
					.addGap(224))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(136)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(usernameIn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordIn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPasword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(69)
					.addComponent(checkLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(145))
		);
		frmMainWindow.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frmMainWindow.setJMenuBar(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("File");
		mnNewMenu_1.setMargin(new Insets(2, 2, 2, 2));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setMargin(new Insets(2, 4, 2, 4));
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnNewMenu_1.add(mntmExit);
	}
}

