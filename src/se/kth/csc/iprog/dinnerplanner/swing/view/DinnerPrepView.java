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
	private static final String PREP_INTRO = "Dinner menu preparation \n";
	
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
			desc = desc + meal + "\n";
		
		JTextArea textArea;
		this.setLayout(new BorderLayout());
		if(!desc.equals("")){
			textArea = new JTextArea(desc);
			
			textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        textArea.setOpaque(false);
	        textArea.setEditable(false);

		}
		else{
			textArea = new JTextArea("No meals to display");
		}
		
		JScrollPane scrollPane = new JScrollPane(textArea);
			
		this.add(scrollPane, BorderLayout.CENTER);
		
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
			list.add(mealtype + dish.getName() + "\n " + dish.getDescription());
		}
		return list;
	}
	
	

	
	public String getPrep(){
		return "Default prep string";
	}
	
}

