package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import external.WrapLayout;


public class DishListView extends JPanel{
	private static final long serialVersionUID = 1L;

	public static class Dish extends JPanel {
		private static final long serialVersionUID = 1L;
	 
		public Dish(String label, String imagePath) {
			this.setLayout(new BorderLayout());
			
			ImageIcon icon = new ImageIcon(imagePath);
			JButton button = new JButton(icon);
			button.setContentAreaFilled(false);
			button.addActionListener(new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent action) {
					//TODO push some kind of data to dish details
					DishDetails.OpenWindow(new HashSet<Ingredient>());
				}
			});
			
			button.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
			this.add(button, BorderLayout.CENTER);
			
			this.add(new JLabel(label, JLabel.CENTER), BorderLayout.SOUTH);
		}
	}
	
	private JPanel insideScroll;
	
	private JPanel createTabPanel(int type){
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		SearchPanel spanel = new SearchPanel();
		JPanel ipanel = new JPanel();
		ipanel.setLayout(new WrapLayout());
		
		JSeparator line = new JSeparator();
		
		JPanel slpanel = new JPanel();
		slpanel.setLayout(new BorderLayout());
		slpanel.add(spanel, BorderLayout.NORTH);
		slpanel.add(line, BorderLayout.SOUTH);
		
		panel.add(slpanel, BorderLayout.NORTH);
		panel.add(ipanel, BorderLayout.CENTER);
		
	    ArrayList<String> dishList = getDishes(type);
		for (String dish : dishList) {
			ipanel.add(new Dish(dish, "images/bakedbrie.jpg"));
		}
		
		return panel;
	}
	
	public DishListView() {
		JTabbedPane tabbedPane = new JTabbedPane();
		
		//TODO: Change JTextField into a custom one for a nicer search box 

		JPanel t1 = createTabPanel(1);
		tabbedPane.add("Starter", t1);
		JPanel t2 = createTabPanel(2);
		tabbedPane.add("Main", t2);
		JPanel t3 = createTabPanel(3);
		tabbedPane.add("Dessert", t3);
		
		insideScroll = new JPanel();
		insideScroll.setLayout(new WrapLayout());
		
		JScrollPane scroll = new JScrollPane(insideScroll);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneLayout.HORIZONTAL_SCROLLBAR_NEVER);
			
		this.setLayout(new BorderLayout());
		this.add(tabbedPane, BorderLayout.CENTER);
	}	
	
	private ArrayList<String> getDishes(int type){
		DinnerModel model = new DinnerModel();
		Set<se.kth.csc.iprog.dinnerplanner.model.Dish> dishSet = model.getDishesOfType(type);
		ArrayList<String> dishNames = new ArrayList<String>();
		for (se.kth.csc.iprog.dinnerplanner.model.Dish dish : dishSet){
			dishNames.add(dish.getName());
		}
		return dishNames;
	}
	
}
