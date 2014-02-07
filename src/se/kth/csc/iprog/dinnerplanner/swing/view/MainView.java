package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;


public class MainView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	DishListView dishes;
	DishDetails dishDetails;
	DinnerModel wholeModel;
	JSplitPane split;
	DinnerListView dinnerListView;
	
	public MainView(DinnerModel instancedModel){
		wholeModel = instancedModel;
		
		DishDetails.OpenWindow();
		

		dishes = new DishListView();
		dishes.setMinimumSize(new Dimension(500,50));
		dinnerListView = new DinnerListView(); 
				
		split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				dishes,
				dinnerListView);
		
		//this.add(dishDetails, BorderLayout.CENTER);
	}
	
}
