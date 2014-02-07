package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;

public class DinnerPrepView extends JPanel {

	private static final long serialVersionUID = 1L;
	public static String frameName = "Dinner Planner - Preparation";
	
	Set<Dish> fullMenu;
	Set<Ingredient> allIngr;
	

	public DinnerPrepView(DinnerModel instancedModel){
		
		fullMenu = instancedModel.getDishes();
		allIngr = instancedModel.getAllIngredients();
		
		
	
		ArrayList<String> starters = getDesc(instancedModel, 1);
		ArrayList<String> main = getDesc(instancedModel, 2);
		ArrayList<String> desert = getDesc(instancedModel, 3);
		
		ArrayList<String> meals = new ArrayList<String>();
		meals.addAll(starters);
		meals.addAll(main);
		meals.addAll(desert);
		
		String desc = "";
		for (String meal : meals)
			desc = desc + "<br>" + meal + "<br>";
		
		System.out.println(desc);
		
		JTextArea textArea;
		if(!desc.equals("")){
			textArea = new JTextArea(5,20);
			textArea.setText("<html>" + desc + "</html>");
	    //    textArea.setLineWrap(true);
	        
	        textArea.setWrapStyleWord(true);
	        textArea.setOpaque(false);
	        textArea.setEditable(false);

		}
		else
			textArea = new JTextArea("No meals to display");
			
		this.add(textArea, BorderLayout.CENTER);
		
	}
	
	private ArrayList<String> getDesc(DinnerModel dm, int type){
		Set<Dish> starters = dm.getDishesOfType(type);
		ArrayList<String> list = new ArrayList<String>();
		for (Dish dish : starters) {
			list.add("Starter: " + dish.getName() + "\n " + dish.getDescription());
		}
		return list;
	}
	
	

	
	public String getPrep(){
		return "Default prep string";
	}
	
}

