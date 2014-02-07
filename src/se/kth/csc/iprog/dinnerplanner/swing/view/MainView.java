package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.BorderLayout;

import javax.swing.*;


public class MainView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	JLabel label;
	DishListView dishes;
	
	public MainView(){
		
		dishes = new DishListView();
		
		this.setLayout(new BorderLayout());
		this.add(new JButton("DINNERVIEW"), BorderLayout.EAST);
		this.add(dishes, BorderLayout.CENTER);
	}
	
}
