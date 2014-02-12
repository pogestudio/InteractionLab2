package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import se.kth.csc.iprog.dinnerplanner.model.Dish;

import external.WrapLayout;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;

public class DinnerListView extends JPanel implements ChangeListener{

	private static final long serialVersionUID = 1L;

	private DinnerDishList dishes;
	private DinnerModel thaDinnerModel;
	private JLabel totalCostLabel;
	
	public DinnerListView () {
		
		thaDinnerModel = new DinnerModel();

		this.setLayout(new BorderLayout());

		//Top
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(2,2, 0, 10));
		top.add(new JLabel("Number of people: "));
		top.setBorder(new EmptyBorder(10, 30, 10, 30) );

		SpinnerModel model = new SpinnerNumberModel(2, 1, 100, 1);
		JSpinner numPeople = new JSpinner(model);
		
        numPeople.addChangeListener(this);
		
		top.add(numPeople);
		top.add(new JLabel("Total cost: "));
		
		totalCostLabel = new JLabel("$94300");
		top.add(totalCostLabel);
		
		this.add(top, BorderLayout.NORTH);
		
		//Middle - list
		JPanel middle = new JPanel();
		middle.setLayout(new BorderLayout());
		
		
		
		DefaultListModel lmodel = new DefaultListModel();
		for(Dish d : thaDinnerModel.getDishes()) {
			lmodel.addElement(d);
		}
		
		dishes = new DinnerDishList(lmodel);
		dishes.setLayout(new WrapLayout());
		JLabel title = new JLabel("Dinner menu", JLabel.CENTER);
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 30));
		middle.add(title, BorderLayout.NORTH);
		
		JScrollPane scroll = new JScrollPane(dishes);
		middle.add(scroll, BorderLayout.CENTER);
		scroll.setBorder(new EmptyBorder(0,0,0,0));
	
		
		this.add(middle, BorderLayout.CENTER);
		
		//Bottom - buttons
		JPanel bottom = new JPanel();

		JButton preparation =new JButton("Preparation"); 
		bottom.add(preparation);
		JButton ingredients =new JButton("Ingredients"); 
		bottom.add(ingredients);
		
		preparation.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent evt) {
			   System.out.println("want to POPPRESENTATION");
			   
			   DinnerModel dinnerModel = new DinnerModel();
			   if(dinnerModel != null){
				   DinnerPrepView.OpenWindow(thaDinnerModel);
			   }
			  }
			});
		ingredients.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent evt) {
				  
				  DinnerModel dinnerModel = new DinnerModel();
				  if(dinnerModel != null)
				  {
					  dinnerModel.tempSeedOfChoice();
					  
					  Set<Ingredient> allIngredients = dinnerModel.getAllIngredients();
					   ListIngredients.OpenWindow(allIngredients);

				  }
			   System.out.println("want to Ingredients");
			  }
			});

		this.add(bottom, BorderLayout.SOUTH);
	}
	
	public void stateChanged(ChangeEvent e)
	{
		JSpinner origSpinner = (JSpinner) e.getSource();
		int value = (Integer) origSpinner.getValue();
		thaDinnerModel.setNumberOfGuests(value);
		updateCostLabel();
	}
	
	public void updateCostLabel() {
		float newCost = thaDinnerModel.getTotalMenuPrice();
		totalCostLabel.setText("$" + String.valueOf(newCost));
	}
	
}
