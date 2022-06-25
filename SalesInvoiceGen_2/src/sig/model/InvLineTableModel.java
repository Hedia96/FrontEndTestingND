/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sig.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author AyetAllah
 */
public class InvLineTableModel extends AbstractTableModel {
    
     private ArrayList<InvoiceLine> invlineArr;
    private String[] cols={"No.", "Item Name", "Item Price", "Count", "Item Total"};

    public InvLineTableModel(ArrayList <InvoiceLine> invlineArr)
    {
        this.invlineArr=invlineArr;
    }
    @Override
    public int getRowCount() {
        return invlineArr.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLine  line =invlineArr.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return line.getID();
            case 1:
                return line.getitemName();
            case 2:
                return line.getitemPrice();
            case 3:
                return line.getCount();
            case 4:
                return line.getTotalLine();
        }
         return "";       
    }

    @Override
    public String getColumnName(int column) {
        return cols[column]; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
