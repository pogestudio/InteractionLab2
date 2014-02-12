package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import se.kth.csc.iprog.dinnerplanner.model.Dish;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class DinnerDishList extends JList {

	private static final long serialVersionUID = 1L;
	
	private DinnerModel chosenModel;

	public static class CellRenderer extends JPanel implements ListCellRenderer {
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
				JList list, Object value, int index,
				boolean isSelected, boolean cellHasFocus) {
		
			text.setText(((Dish)value).getName());
			

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
