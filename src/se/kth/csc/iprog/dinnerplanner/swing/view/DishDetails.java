package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Set;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import se.kth.csc.iprog.dinnerplanner.model.Ingredient;
import external.ScrollablePanel;
import external.ScrollablePanel.ScrollableSizeHint;
import external.WrapLayout;


public class DishDetails extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public static void OpenWindow(Set<Ingredient> Ingredients)
	{
		 DishDetails detailsForWindow = new DishDetails(Ingredients);
		
		 JFrame frame = new JFrame("Dish Details"); 
		 //JLabel textLabel = new JLabel("I'm a label in the window",SwingConstants.CENTER);
		 detailsForWindow.setPreferredSize(new Dimension(500, 500));
		 detailsForWindow.setMinimumSize(new Dimension(100, 100));

		 frame.getContentPane().add(detailsForWindow, BorderLayout.CENTER);
		 
		 //Display the window. 
		 frame.setLocationRelativeTo(null); 
		 frame.pack(); 
		 frame.setVisible(true); 

	}

	public DishDetails(Set<Ingredient> Ingredients) {		
		
		
		
		JPanel top = getTopPanel();
		
		JScrollPane left = getLeftPanel();
		JScrollPane right = getRightPanel(Ingredients);
		
		this.setLayout(new BorderLayout());

		
		JSplitPane absoluteBottom = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				left,
				right);
		
		absoluteBottom.setResizeWeight(0.5);
		//absoluteBottom.setDividerLocation(0.5);
		
		JSplitPane masterSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				top,
				absoluteBottom);
		
		masterSplitPane.setResizeWeight(0.3);
		//masterSplitPane.setDividerLocation(0);
		
		
		this.add(masterSplitPane, BorderLayout.CENTER);
		
	}
	
	
	JPanel getTopPanel()
	{
		JPanel top = new JPanel(new BorderLayout());
		top.setMinimumSize(new Dimension(100, 100));
		
		ImageIcon image = new ImageIcon("images/bakedbrie.jpg");
		JLabel imgLabel = new JLabel("", image, JLabel.CENTER);
		top.add(imgLabel, BorderLayout.WEST);
		
		top.add(getTopRightPanel()); 
		
		return top;
	}
	
	JPanel getTopRightPanel()
	{
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
		String completeDishString = "DishTitle";
		String otherInfo = "$12.00 for 9999123123 people";
		JLabel dishInfo = new JLabel(completeDishString, JLabel.LEFT);
		JLabel otherInfoLabel = new JLabel(otherInfo, JLabel.LEFT);
		rightPanel.add(dishInfo);
		rightPanel.add(otherInfoLabel);
		
		
		return rightPanel;
	}
	
	
	JScrollPane getLeftPanel()
	{
		JScrollPane left = new JScrollPane();
		left.setMinimumSize(new Dimension(100, 100));
		
		left.setViewportView(new JLabel("Dish preparattttttion"));
		return left;
	}
	
	JScrollPane getRightPanel(Set<Ingredient> Ingredients)
	{
//		JPanel right = new JPanel();
//		right.setMinimumSize(new Dimension(100, 100));
//		right.add(new JButton("RIGHT SHIIIIIIIT")); 	
//		return right;
		
	    ListIngredients allIngredients = new ListIngredients();
	    
	      return allIngredients.getTableForIngredients(Ingredients);
	}
	
}
