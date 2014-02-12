package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private static JButton testbutton;
	private static JPanel testpanel;
	
	
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
		    testbutton = button;
		    testpanel = this;
		    add(text);
			this.add(image);			
			this.add(text);		
			this.add(button);
			
			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					System.out.println("ASDASDF");
				}
			});
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
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				clickButton(event.getPoint());
			}
		});
	}
	
	public void setDinnerModel(DinnerModel model)
	{
		this.chosenModel = model;
	}
	
	public DinnerModel getDinnerModel()
	{
		return this.chosenModel;
	}
	
	private void clickButton(Point point) {
	    int index = locationToIndex(point);
		
		Object o = getModel().getElementAt(index);
	
		point.y -= testpanel.getBounds().height * index;
		
		index = 32;		
		System.out.println(point.x + ", " + point.y + " : " + index);

		System.out.println(testpanel.getHeight());
		System.out.println(testpanel.getPreferredSize().height);
		System.out.println(testbutton.getBounds());
	}
}
