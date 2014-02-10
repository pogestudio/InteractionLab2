package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;

import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;
import se.kth.csc.iprog.dinnerplanner.swing.view.DishListView.CellRenderer;

import external.WrapLayout;

public class DinnerDishList extends JList<Dish> {

	private static final long serialVersionUID = 1L;

	public static class CellRenderer extends JPanel implements ListCellRenderer<Dish> {
		private static final long serialVersionUID = 1L;

		private JLabel text;
		JButton button;
		ImageIcon icon;
		
		public CellRenderer() {
		    setOpaque(true);

			this.setLayout(new FlowLayout());
			
		    text = new JLabel("errororoeroeroeror", JLabel.CENTER);
		    add(text);
			this.add(new JButton("asdf"));			
			this.add(text);		
			this.add(new JButton("delete"));
		  }
		
		@Override
		public Component getListCellRendererComponent(
				JList<? extends Dish> list, Dish value, int index,
				boolean isSelected, boolean cellHasFocus) {
		
			text.setText(value.getName());
			

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

	public DinnerDishList(ListModel<Dish> model) {
		super(model);

		setCellRenderer(new CellRenderer());
		setDropMode(DropMode.INSERT);
		setDragEnabled(true);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setTransferHandler(new DishTransferHandler());
	}
}
