package se.kth.csc.iprog.dinnerplanner.model;

import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class DishListListener implements ListDataListener {
	    public void contentsChanged(ListDataEvent e) {
	        System.out.println("contentsChanged: " + e.getIndex0() +
	                   ", " + e.getIndex1());
	    }
	    public void intervalAdded(ListDataEvent e) {
	    	System.out.println("intervalAdded: " + e.getIndex0() +
	                   ", " + e.getIndex1());
	    }
	    public void intervalRemoved(ListDataEvent e) {
	    	System.out.println("intervalRemoved: " + e.getIndex0() +
	                   ", " + e.getIndex1());
	    }

}