package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class DinnerListView extends JPanel{

	private static final long serialVersionUID = 1L;

	private DinnerDishList dishes;
	
	public DinnerListView() {

		this.setLayout(new BorderLayout());

		//Top
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(2,2));
		top.add(new JLabel("test 1"));

		SpinnerModel model = new SpinnerNumberModel(2, 1, 100, 1);
		JSpinner numPeople = new JSpinner(model);
		
		top.add(numPeople);
		top.add(new JLabel("test 3"));
		top.add(new JLabel("test 4"));
		
		this.add(top, BorderLayout.NORTH);
		
		//Middle - list
		JPanel middle = new JPanel();
		middle.setLayout(new BorderLayout());
		
		dishes = new DinnerDishList();
		middle.add(new JLabel("Dinner menu"), BorderLayout.NORTH);
		
		JScrollPane scroll = new JScrollPane(dishes);
		middle.add(scroll, BorderLayout.CENTER);

		this.add(middle, BorderLayout.CENTER);
		
		//Bottom - buttons
		JPanel bottom = new JPanel();

		bottom.add(new JButton("Preparation"));
		bottom.add(new JButton("Ingredients"));

		this.add(bottom, BorderLayout.SOUTH);
	}
	
	
}
