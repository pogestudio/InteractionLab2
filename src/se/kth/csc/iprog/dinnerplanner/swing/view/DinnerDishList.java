package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import se.kth.csc.iprog.dinnerplanner.model.Dish;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class DinnerDishList extends JList {

	private static final long serialVersionUID = 1L;
	
	private DinnerModel chosenModel;

	public static class CellRenderer extends JPanel implements ListCellRenderer {
		private static final long serialVersionUID = 1L;

		private JLabel text;
		private JLabel image;
		JButton button;
		ImageIcon icon;
		
		public CellRenderer() {
		    setOpaque(true);

			this.setLayout(new FlowLayout());
			
		    text = new JLabel("errororoeroeroeror", JLabel.CENTER);
		    text.setPreferredSize(new Dimension(100, 60));
		    image = new JLabel("",JLabel.LEFT);
		    image.setPreferredSize(new Dimension(80, 60));
		    image.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		    
		    button = new JButton("X");
		    add(text);
			this.add(image);			
			this.add(text);		
			this.add(button);
		  }
		
		@Override
		public Component getListCellRendererComponent(
				JList list, Object value, int index,
				boolean isSelected, boolean cellHasFocus) {
		
			text.setText(((Dish)value).getName());
			image.setIcon(new ImageIcon("images/"+((Dish)value).getImage()));

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

	public DinnerDishList(ListModel model) {
		super(model);

		setCellRenderer(new CellRenderer());
		setDropMode(DropMode.INSERT);
		setDragEnabled(false);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setTransferHandler(new DishReceiverHandler());
	}
	
	public void setDinnerModel(DinnerModel model)
	{
		this.chosenModel = model;
	}
	
	public DinnerModel getDinnerModel()
	{
		return this.chosenModel;
	}
}
