package src.CalculatorMain;
//import libraries 
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class Calculator extends WindowAdapter implements ActionListener {
	// declaring all objects and variables that will be used
	private JFrame frame;
	private JButton num0, num1, num2, num3, num4, num5, num6, num7, num8, num9, add, sub, mul, div, eq, clr;
	private JRadioButton on, off;
	private JComboBox dropdown;
	private JTextField txtfield;
	private JLabel label;
	private String theme[] = new String[] { "Light", "Dark" };
	private int numA = 0, numB = 0, ans = 0, calculation = 0;

	// Constructor
	public Calculator() {
		//JFrame 
		frame = new JFrame("Simple Calculator"); //create JFrame object with placeholder "Simple Calculator"
		frame.setSize(290, 430); //Set frame sizew
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//By default the program will only close using the JOptionPane
		frame.setResizable(false);// Frame is not resizable
		frame.setLayout(null);//Because there are no layout manager in use
		frame.setLocationRelativeTo(null);//so that the program will be at the center of user screen when it is executed
		
		//using exception handling to catch error
		try {
			// set look and feel to be windows system like
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {// catching error in order to make default frame windows like
			System.err.println(e.getMessage());
		}

		//Jtextfield
		txtfield = new JTextField();// creating Jtextfield object
		txtfield.setBackground(Color.WHITE);//setting textfield background color
		txtfield.setFont(txtfield.getFont().deriveFont(40.0f));//setting textfield font size
		txtfield.setEditable(false); //setting textfield to not be editable
		
		//Jlabel
		label = new JLabel("Theme:");// create Jlabel object

		// Jbutton, creating Jbutton objects and assigning all numbers and symbols
		num0 = new JButton("0");
		num1 = new JButton("1");
		num2 = new JButton("2");
		num3 = new JButton("3");
		num4 = new JButton("4");
		num5 = new JButton("5");
		num6 = new JButton("6");
		num7 = new JButton("7");
		num8 = new JButton("8");
		num9 = new JButton("9");
		add = new JButton("+");
		sub = new JButton("-");
		mul = new JButton("x");
		div = new JButton("/");
		eq = new JButton("=");
		clr = new JButton("Clr");
		
		// JRadioButton
		on = new JRadioButton("ON");
		off = new JRadioButton("OFF");
		// Grouping radio buttons altogether using ButtonGroup
		ButtonGroup G = new ButtonGroup();
		G.add(on);
		G.add(off);
		// initialized radio button value
		off.setSelected(true);
		num0.setEnabled(false);
		num1.setEnabled(false);
		num2.setEnabled(false);
		num3.setEnabled(false);
		num4.setEnabled(false);
		num5.setEnabled(false);
		num6.setEnabled(false);
		num7.setEnabled(false);
		num8.setEnabled(false);
		num9.setEnabled(false);
		add.setEnabled(false);
		sub.setEnabled(false);
		mul.setEnabled(false);
		div.setEnabled(false);
		eq.setEnabled(false);
		clr.setEnabled(false);

		// JComboBox
		dropdown = new JComboBox(theme); //create JComboBox object with placeholder called "theme"
		dropdown.setEnabled(false); //by default after executing the program, dropdown function is disabled
		frame.getContentPane().setBackground(Color.WHITE);//default background or theme is white
		dropdown.addItemListener(new ItemListener() { //event handling for dropdown (JComboBox)

			public void itemStateChanged(ItemEvent item) {//create ItemEvent object named item
				//using getStateChange method to obtain state changes if different options is selected in the dropdown (JComboBox)
				if (item.getStateChange() == ItemEvent.SELECTED) { 
					if (dropdown.getSelectedItem().toString().equals("Light")) {
						frame.getContentPane().setBackground(Color.WHITE);
						
					}
					if (dropdown.getSelectedItem().toString().equals("Dark")) {
						frame.getContentPane().setBackground(Color.DARK_GRAY);
						
					}

				}

			}
		});

		// setting components location
		label.setBounds(210, 135, 50, 70);
		txtfield.setBounds(20, 20, 240, 70);
		dropdown.setBounds(210, 180, 55, 30);
		num0.setBounds(20, 280, 50, 50);
		num1.setBounds(20, 220, 50, 50);
		num2.setBounds(80, 220, 50, 50);
		num3.setBounds(140, 220, 50, 50);
		num4.setBounds(20, 160, 50, 50);
		num5.setBounds(80, 160, 50, 50);
		num6.setBounds(140, 160, 50, 50);
		num7.setBounds(20, 100, 50, 50);
		num8.setBounds(80, 100, 50, 50);
		num9.setBounds(140, 100, 50, 50);
		add.setBounds(80, 280, 50, 50);
		sub.setBounds(140, 280, 50, 50);
		mul.setBounds(210, 280, 50, 50);
		div.setBounds(210, 340, 50, 35);
		eq.setBounds(20, 340, 170, 35);
		on.setBounds(210, 100, 50, 30);
		off.setBounds(210, 122, 50, 30);
		clr.setBounds(210, 220, 50, 50);
		
		//adding action listener to all respective buttons
		num0.addActionListener(this);
		num1.addActionListener(this);
		num2.addActionListener(this);
		num3.addActionListener(this);
		num4.addActionListener(this);
		num5.addActionListener(this);
		num6.addActionListener(this);
		num7.addActionListener(this);
		num8.addActionListener(this);
		num9.addActionListener(this);
		add.addActionListener(this);
		sub.addActionListener(this);
		mul.addActionListener(this);
		div.addActionListener(this);
		eq.addActionListener(this);
		clr.addActionListener(this);
		frame.addWindowListener(this);

		// adding components
		frame.add(txtfield);
		frame.add(num0);
		frame.add(num1);
		frame.add(num2);
		frame.add(num3);
		frame.add(num4);
		frame.add(num5);
		frame.add(num6);
		frame.add(num7);
		frame.add(num8);
		frame.add(num9);
		frame.add(add);
		frame.add(sub);
		frame.add(mul);
		frame.add(div);
		frame.add(eq);
		frame.add(on);
		frame.add(off);
		frame.add(dropdown);
		frame.add(label);
		frame.add(clr);
		frame.add(dropdown);
		//setting frame to be visible
		frame.setVisible(true);

		// radio button actionlistener
		on.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				num0.setEnabled(true);
				num1.setEnabled(true);
				num2.setEnabled(true);
				num3.setEnabled(true);
				num4.setEnabled(true);
				num5.setEnabled(true);
				num6.setEnabled(true);
				num7.setEnabled(true);
				num8.setEnabled(true);
				num9.setEnabled(true);
				add.setEnabled(true);
				sub.setEnabled(true);
				mul.setEnabled(true);
				div.setEnabled(true);
				eq.setEnabled(true);
				clr.setEnabled(true);
				dropdown.setEnabled(true);

			}
		});

		off.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				num0.setEnabled(false);
				num1.setEnabled(false);
				num2.setEnabled(false);
				num3.setEnabled(false);
				num4.setEnabled(false);
				num5.setEnabled(false);
				num6.setEnabled(false);
				num7.setEnabled(false);
				num8.setEnabled(false);
				num9.setEnabled(false);
				add.setEnabled(false);
				sub.setEnabled(false);
				mul.setEnabled(false);
				div.setEnabled(false);
				eq.setEnabled(false);
				clr.setEnabled(false);
				dropdown.setEnabled(false);

			}
		});

	}
	//calculator main event handling (calculation and operations)
	public void operation() {
		switch (calculation) { //using switch case to get either addition or subtraction operation
			case 1://if user press add (+) button, then calculation variable will be assigned with 1
				numB = Integer.parseInt(txtfield.getText());//thus whole process of addition is executed
				ans = numA + numB;
				txtfield.setText(String.valueOf(ans));// convert int to String and display output at textfield 
				break;

			case 2://if user press minus (-) button, then the calculation variable will be assigned with 2
				numB = Integer.parseInt(txtfield.getText());//thus whole process of subtraction is executed
				ans = numA - numB;
				txtfield.setText(String.valueOf(ans));// convert int to String and display output at textfield 
				break;
			
			case 3:
				numB = Integer.parseInt(txtfield.getText());//thus whole process of multiplication is executed
				ans = numA * numB;
				txtfield.setText(String.valueOf(ans));// convert int to String and display output at textfield 
				break;
			
			case 4:
				numB = Integer.parseInt(txtfield.getText());//thus whole process of division is executed
				ans = numA / numB;
				txtfield.setText(String.valueOf(ans));// convert int to String and display output at textfield 
				break;
		}

	}
	//event handling for JOptionPane
	public void windowClosing(WindowEvent e) {
		int a = JOptionPane.showConfirmDialog(frame, "Are you sure?");
		if (a == JOptionPane.YES_OPTION) {
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	//event handling for Jbutton action
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == num0) {
			txtfield.setText(txtfield.getText() + "0");
		}
		if (e.getSource() == num1) {
			txtfield.setText(txtfield.getText() + "1");
		}
		if (e.getSource() == num2) {
			txtfield.setText(txtfield.getText() + "2");
		}
		if (e.getSource() == num3) {
			txtfield.setText(txtfield.getText() + "3");
		}
		if (e.getSource() == num4) {
			txtfield.setText(txtfield.getText() + "4");
		}
		if (e.getSource() == num5) {
			txtfield.setText(txtfield.getText() + "5");
		}
		if (e.getSource() == num6) {
			txtfield.setText(txtfield.getText() + "6");
		}
		if (e.getSource() == num7) {
			txtfield.setText(txtfield.getText() + "7");
		}
		if (e.getSource() == num8) {
			txtfield.setText(txtfield.getText() + "8");
		}
		if (e.getSource() == num9) {
			txtfield.setText(txtfield.getText() + "9");
		}
		if (e.getSource() == add) {
			numA = Integer.parseInt(txtfield.getText());
			calculation = 1;
			txtfield.setText("");
			//txtfield.setText("+");

		}
		if (e.getSource() == sub) {
			numA = Integer.parseInt(txtfield.getText());
			calculation = 2;
			txtfield.setText("");
			// txtfield.setText("-");
		}
		if (e.getSource() == mul) {
			numA = Integer.parseInt(txtfield.getText());
			calculation = 3;
			txtfield.setText("");
			// txtfield.setText("x");
		}
		if (e.getSource() == div) {
			numA = Integer.parseInt(txtfield.getText());
			calculation = 4;
			txtfield.setText("");
			// txtfield.setText("-");
		}
		if (e.getSource() == eq) {
			operation();
			txtfield.setText("" + ans);

		}
		if (e.getSource() == clr) {
			txtfield.setText("");
		}

	}
	//main method for running the program
	public static void main(String[] args) {
		new Calculator();
	}

}