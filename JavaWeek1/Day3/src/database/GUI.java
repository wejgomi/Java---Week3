package database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends MySQL{
	
	JTable table = new JTable();
	JTextField textStatement;
	String st = "";
	
	public GUI() throws Exception{
		JFrame frame = new JFrame("Alex Database");
		frame.setSize(800, 500);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new FlowLayout());
		
		//table
		JButton btn = new JButton("Execute");
		btn.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ex){
			try{
				st = textStatement.getText();
				table.setModel(connectToDatabase(st));
			}catch (Exception ex1){
				ex1.printStackTrace();
				
				
			}
		}
			
		});
		frame.getContentPane().add(btn);
		
		//txtField
		textStatement = new JTextField(60);
		frame.getContentPane().add(textStatement);
		
		//our table
		frame.add(new JScrollPane(table));
		frame.setVisible(true);
		

	}

	public static void main(String[] args) throws Exception {
		new GUI();

	}

}
