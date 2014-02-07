package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.BorderLayout;

import javax.swing.*;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;


public class MainView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	DishListView dishes;
	DinnerModel wholeModel;

	public MainView(DinnerModel instancedModel){
		wholeModel = instancedModel;
		
		dishes = new DishListView();
		
		this.setLayout(new BorderLayout());
		this.add(new JButton("DINNERVIEW"), BorderLayout.EAST);
		this.add(dishes, BorderLayout.CENTER);
	}
	
}
