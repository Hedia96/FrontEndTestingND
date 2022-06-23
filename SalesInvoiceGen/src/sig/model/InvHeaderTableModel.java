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
public class InvHeaderTableModel extends AbstractTableModel{
    private ArrayList<InvoiceHeader> invArr;
    private String[] cols={"No.","Date","Customer","Total"};
    public InvHeaderTableModel(ArrayList<InvoiceHeader> invArr){
        this.invArr=invArr;
    };
    @Override
    public int getRowCount() {
      // System.out.println("wwwwwwwwwwww"+invArr.size()) ;
       return invArr.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
        
        
    }
     @Override
   public String getColumnName(int column){
       return cols[column];
   }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      Object res="";
       InvoiceHeader inv = invArr.get(rowIndex);
       if(columnIndex==0)
       {
           res=inv.getID();
       }else if(columnIndex==1)
       {
           res=inv.getCreatedDate();
       }else if(columnIndex==2)
       {
           res=inv.getCustomer();
       }else 
       {
           res=inv.getInvoiceTotal();
       }
        return res.toString();
       //return "test";
    }
 
   
    
}
