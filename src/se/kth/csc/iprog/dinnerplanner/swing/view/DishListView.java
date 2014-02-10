package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import javax.swing.*;

import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;

public class DishListView extends JPanel{
	private static final long serialVersionUID = 1L;

	public static class CellRenderer extends JPanel implements ListCellRenderer<Dish> {
		private static final long serialVersionUID = 1L;

		private JLabel text;
		JButton button;
		ImageIcon icon;
		
		public CellRenderer() {
		    setOpaque(true);

			this.setLayout(new BorderLayout());
			
			icon = null;
		    text = new JLabel("ASDFGASDFG", JLabel.CENTER);
		    add(text);
			button = new JButton();
			button.setContentAreaFilled(false);
			button.setMargin(new Insets(50, 50, 50, 50));			
			button.addActionListener(new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent action) {
					//TODO push some kind of data to dish details
					DishDetails.OpenWindow(new HashSet<Ingredient>());
				}
			});
			this.add(button, BorderLayout.CENTER);			
			this.add(text, BorderLayout.SOUTH);
		  }
		
		
		
		@Override
		public Component getListCellRendererComponent(
				JList<? extends Dish> list, Dish value, int index,
				boolean isSelected, boolean cellHasFocus) {
		
			text.setText(value.getName());
			
			button.setIcon(new ImageIcon(value.getImage()));
			
			setPreferredSize(new Dimension(150, 150));

		    if (isSelected) {
		      setBackground(list.getSelectionBackground());
		      setForeground(list.getSelectionForeground());
		    } else {
		      setBackground(list.getBackground());
		      setForeground(list.getForeground());
		    }
		    return this;
		}
	}
	
	private JPanel insideScroll;
	
	public DishListView() {

		JTabbedPane tabbedPane = new JTabbedPane();

		//TODO: Change JTextField into a custom one for a nicer search box 
		SearchPanel t1 = new SearchPanel();
		tabbedPane.addTab("Starter", t1);
		SearchPanel t2 = new SearchPanel();
		tabbedPane.addTab("Main", t2);
		SearchPanel t3 = new SearchPanel();
		tabbedPane.addTab("Dessert", t3);
		

		DefaultListModel<Dish> model = new DefaultListModel<Dish>();

		model.addElement(new Dish("food", 0, "images/icecream.jpg", "Nice food"));

		JList<Dish> scroll = new JList<Dish>(model);
		scroll.setDragEnabled(true);
		scroll.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		scroll.setVisibleRowCount(-1);
		scroll.setCellRenderer(new CellRenderer());
		scroll.setTransferHandler(new DishTransferHandler());
		scroll.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setLayout(new BorderLayout());
		this.add(tabbedPane, BorderLayout.NORTH);
		this.add(scroll, BorderLayout.CENTER);
		
		
	}
	
	
}
