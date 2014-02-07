package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

import external.ScrollablePanel;
import external.ScrollablePanel.ScrollableSizeHint;
import external.WrapLayout;


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
		insideScroll.setLayout(new WrapLayout());
		
		JButton b;
		for(int i = 0; i < 18; ++i) {
			b = new JButton("Food");
			b.setPreferredSize(new Dimension(90, 90));
			insideScroll.add(b);
		}
		
		JScrollPane scroll = new JScrollPane(insideScroll);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneLayout.HORIZONTAL_SCROLLBAR_NEVER);
			
		this.setLayout(new BorderLayout());
		this.add(tabbedPane, BorderLayout.NORTH);
		this.add(scroll, BorderLayout.CENTER);
		
		
	}
	
	
}
