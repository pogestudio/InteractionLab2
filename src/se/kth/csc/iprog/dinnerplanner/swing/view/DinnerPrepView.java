package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;

public class DinnerPrepView extends JPanel {

	private static final long serialVersionUID = 1L;
	public static String frameName = "Dinner Planner - Preparation";
	private static final String PREP_INTRO = "<h1>Dinner menu preparation </h1><br>";
	
	Set<Dish> fullMenu;
	Set<Ingredient> allIngr;
	

	public DinnerPrepView(DinnerModel instancedModel){
		ArrayList<String> starters = getDesc(instancedModel, 1);	
		ArrayList<String> main = getDesc(instancedModel, 2);
		ArrayList<String> desert = getDesc(instancedModel, 3);
		
		ArrayList<String> meals = new ArrayList<String>();
		meals.addAll(starters);
		meals.addAll(main);
		meals.addAll(desert);
		
		String desc = PREP_INTRO;
		for (String meal : meals)
			desc = desc + meal + "<br> <br>";
		
		this.setLayout(new BorderLayout());
		JTextPane textPane = new JTextPane();
		textPane.setContentType("text/html");
		if(!desc.equals("")){
			
			textPane.setText("<html> <center>" + desc + " </center></html>");
		}
		else
			textPane.setText("No meals to display");

		this.add(textPane, BorderLayout.CENTER);
	}
	
	private ArrayList<String> getDesc(DinnerModel dm, int type){
		Set<Dish> starters = dm.getDishesOfType(type);
		ArrayList<String> list = new ArrayList<String>();
		
		String mealtype = "";
		if(type == 1){
			mealtype = "Starter: ";
		}
		else if(type == 2){
			mealtype = "Main: ";
		}
		else{
			mealtype = "Desert: ";
			
		}
		for (Dish dish : starters) {
			list.add("<b>" + mealtype + dish.getName() + "</b>" + "<br> " + dish.getDescription());
		}
		return list;
	}
}

