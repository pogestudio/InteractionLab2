package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.*;

import external.WrapLayout;

import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
public class DishListView extends JPanel{
	private static final long serialVersionUID = 1L;

	public static class CellRenderer extends JPanel implements ListCellRenderer {
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
					DishDetails.OpenWindow(null);
				}
			});
			this.add(button, BorderLayout.CENTER);			
			this.add(text, BorderLayout.SOUTH);
		  }
		
		@Override
		public Component getListCellRendererComponent(
				JList list, Object value, int index,
				boolean isSelected, boolean cellHasFocus) {
		
			text.setText(((Dish)value).getName());
			
			button.setIcon(new ImageIcon("images/" + ((Dish)value).getImage()));
			
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
		
	    ArrayList<Dish> dishList = getDishes(type);
	    
		DefaultListModel model = new DefaultListModel();

		for (Dish dish : dishList) {
			model.addElement(dish);
		}
		JList scroll = new JList(model);
		scroll.setDragEnabled(true);
		scroll.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		scroll.setVisibleRowCount(-1);
		scroll.setCellRenderer(new CellRenderer());
		scroll.setTransferHandler(new DishSenderHandler());
		scroll.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel.add(scroll, BorderLayout.CENTER);
		return panel;
	}
	
	public DishListView() {
		JTabbedPane tabbedPane = new JTabbedPane();
		
		JPanel t1 = createTabPanel(1);
		tabbedPane.add("Starter", t1);
		JPanel t2 = createTabPanel(2);
		tabbedPane.add("Main", t2);
		JPanel t3 = createTabPanel(3);
		tabbedPane.add("Dessert", t3);
			
		this.setLayout(new BorderLayout());
		this.add(tabbedPane, BorderLayout.CENTER);
	}	
	
	private ArrayList<Dish> getDishes(int type){
		DinnerModel model = new DinnerModel();
		Set<se.kth.csc.iprog.dinnerplanner.model.Dish> dishSet = model.getDishesOfType(type);
		ArrayList<Dish> dishNames = new ArrayList<Dish>();
		for (se.kth.csc.iprog.dinnerplanner.model.Dish dish : dishSet){
			dishNames.add(dish);
		}
		return dishNames;
	}
	
}
