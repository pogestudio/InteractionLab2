package se.kth.csc.iprog.dinnerplanner.swing.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import external.WrapLayout;

public class DinnerDishList extends JPanel {

	private static final long serialVersionUID = 1L;

	public static class Element extends JPanel{
		private static final long serialVersionUID = 1L;

		//TODO real data
		public Element(String data) {
			JPanel panel = new JPanel();

			panel.add(new JButton("img"));
			panel.add(new JLabel(data));
			panel.add(new JButton("del"));
			
			this.add(panel);
		}
	}

	public DinnerDishList() {
		this.setLayout(new WrapLayout());
		
		this.add(new Element("Fish"));
		this.add(new Element("And"));
		this.add(new Element("Stuff"));
	}
}
