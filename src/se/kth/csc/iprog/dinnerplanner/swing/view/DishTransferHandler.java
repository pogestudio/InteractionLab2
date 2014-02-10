package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.activation.ActivationDataFlavor;
import javax.activation.DataHandler;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.TransferHandler;

public class DishTransferHandler extends TransferHandler {
	private static final long serialVersionUID = 1L;
    private final DataFlavor localObjectFlavor;
    private JList<String> source;
    private int[] indices;
    private int addIndex = -1; //Location where items were added
    private int addCount; //Number of items added.
    private boolean remove;
    
    public DishTransferHandler(boolean remove) {
        super();
        localObjectFlavor = new ActivationDataFlavor(Object[].class, DataFlavor.javaJVMLocalObjectMimeType, "Array of items");
        this.remove = remove;
    }
	@Override
	protected Transferable createTransferable(JComponent c) {
        source = (JList)c;
        indices = source.getSelectedIndices();
        @SuppressWarnings("deprecation") Object[] transferedObjects = source.getSelectedValues();
        return new DataHandler(transferedObjects, localObjectFlavor.getMimeType());
	}
	
	@Override
	public boolean importData(TransferSupport info) {
	    if(!canImport(info)) {
            return false;
        }
        JList target = (JList)info.getComponent();
        JList.DropLocation dl = (JList.DropLocation)info.getDropLocation();
        DefaultListModel listModel = (DefaultListModel)target.getModel();
        int index = dl.getIndex();
        //boolean insert = dl.isInsert();
        int max = listModel.getSize();
        if(index<0 || index>max) {
            index = max;
        }
        addIndex = index;

        try{
            Object[] values = (Object[])info.getTransferable().getTransferData(localObjectFlavor);
            for(int i=0;i<values.length;i++) {
                int idx = index++;
                listModel.add(idx, values[i]);
                target.addSelectionInterval(idx, idx);
                if(remove) {
                	
                }
            }
            addCount = target.equals(source) ? values.length : 0;
            return true;
        }catch(UnsupportedFlavorException ufe) {
            ufe.printStackTrace();
        }catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return false;
	}
	
    @Override public int getSourceActions(JComponent c) {
        return MOVE; //TransferHandler.COPY_OR_MOVE;
    }
    
    @Override public boolean canImport(TransferSupport info) {
        return info.isDrop() && info.isDataFlavorSupported(localObjectFlavor);
    }
}
