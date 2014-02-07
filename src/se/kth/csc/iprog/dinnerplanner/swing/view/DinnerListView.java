package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

public class DinnerListView extends JPanel{

	private static final long serialVersionUID = 1L;

	private DinnerDishList dishes;
	
	public DinnerListView() {

		this.setLayout(new BorderLayout());

		//Top
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(2,2, 0, 10));
		top.add(new JLabel("Number of people: "));
		top.setBorder(new EmptyBorder(10, 30, 10, 30) );

		SpinnerModel model = new SpinnerNumberModel(2, 1, 100, 1);
		JSpinner numPeople = new JSpinner(model);
		
		top.add(numPeople);
		top.add(new JLabel("Total cost: "));
		top.add(new JLabel("$ 943.00"));
		
		this.add(top, BorderLayout.NORTH);
		
		//Middle - list
		JPanel middle = new JPanel();
		middle.setLayout(new BorderLayout());
		
		dishes = new DinnerDishList();
		JLabel title = new JLabel("Dinner menu", JLabel.CENTER);
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 30));
		middle.add(title, BorderLayout.NORTH);
		
		JScrollPane scroll = new JScrollPane(dishes);
		middle.add(scroll, BorderLayout.CENTER);
		scroll.setBorder(new EmptyBorder(0,0,0,0));

		this.add(middle, BorderLayout.CENTER);
		
		//Bottom - buttons
		JPanel bottom = new JPanel();

		bottom.add(new JButton("Preparation"));
		bottom.add(new JButton("Ingredients"));

		this.add(bottom, BorderLayout.SOUTH);
	}
	
	
}
