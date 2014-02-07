package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;


public class DishListView extends JPanel{
	private static final long serialVersionUID = 1L;

	public DishListView() {

		JTabbedPane tabbedPane = new JTabbedPane();

		//TODO: Change JTextField into a custom one for a nicer search box 
		JTextField t1 = new JTextField();
		tabbedPane.addTab("Starter", t1);
		JTextField t2 = new JTextField();
		tabbedPane.addTab("Main", t2);
		JTextField t3 = new JTextField();
		tabbedPane.addTab("Dessert", t3);
		
		
		JPanel insideScroll = new JPanel();
		JScrollPane scroll = new JScrollPane(insideScroll);
		JButton b;
		for(int i = 0; i < 8; ++i) {
			b = new JButton("Food");
			b.setSize(50, 50);
			scroll.add(b);
		}
		
		this.setLayout(new BorderLayout());
		this.add(tabbedPane, BorderLayout.NORTH);
		this.add(scroll, BorderLayout.CENTER);
		
		
	}
	
	
}
