package se.kth.csc.iprog.dinnerplanner.model;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;


public class DishListListener implements ListDataListener {
	
	private DinnerModel thaDinnerModel;
	private DefaultListModel dinnerList;

	    public void contentsChanged(ListDataEvent e) {
	        System.out.println("contentsChanged: " + e.getIndex0() +
	                   ", " + e.getIndex1());
	         
	        
	    }
	    public void intervalAdded(ListDataEvent e) {
	    	System.out.println("intervalAdded: " + e.getIndex0() +
	                   ", " + e.getIndex1());
	    	
	    	Dish addedDish = (Dish) dinnerList.getElementAt(e.getIndex0());
	    	thaDinnerModel.selectDish(addedDish);
	    	thaDinnerModel.printAllDishes();
	    	
	    }
	    public void intervalRemoved(ListDataEvent e) {
	    	System.out.println("intervalRemoved: " + e.getIndex0() +
	                   ", " + e.getIndex1());
	    	
	    	Dish deletedDish = (Dish) dinnerList.getElementAt(e.getIndex0());
	    	thaDinnerModel.deleteDish(deletedDish);
	    	thaDinnerModel.printAllDishes();
	    }
		public DinnerModel getThaDinnerModel() {
			return thaDinnerModel;
		}
		public void setThaDinnerModel(DinnerModel thaDinnerModel) {
			this.thaDinnerModel = thaDinnerModel;
		}
		public DefaultListModel getDinnerList() {
			return dinnerList;
		}
		public void setDinnerList(DefaultListModel dinnerList) {
			this.dinnerList = dinnerList;
		}

}