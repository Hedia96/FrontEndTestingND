/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sig.control;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import sig.model.InvLineTableModel;
import sig.model.InvoiceHeader;
import sig.view.SigFrame;
import sig.model.InvoiceLine;

/**
 *
 * @author AyetAllah
 */
public class SelectListeners implements ListSelectionListener {
    private SigFrame frame;
    public SelectListeners(SigFrame f){
    frame=f;   
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
       ArrayList<InvoiceLine> invlines =new ArrayList();
       // to avoid reduent selection 
        int index_invselected=frame.getTable_invoices().getSelectedRow();
        if(index_invselected != -1){
            InvoiceHeader invh =frame.getHeaders().get(index_invselected);
            
       invlines= invh.getLines();
    System.out.println("selected invoice is  "+frame.getHeaders().get(index_invselected).toString());
   /* for(int i=0;i<invlines.size();i++)
    {
        System.out.println("invoice line "+  i +invlines.get(i).toString());
    }*/
    InvLineTableModel invltab=new InvLineTableModel(invlines);
    frame.setLines(invlines);
    frame.getTable_Invoice_lines().setModel(invltab);
    // effeect on labels
    
    frame.getLabel_inv_id().setText(""+ invh.getID());
    frame.getLabel_inv_date().setText( invh.getCreatedDate());
    frame.getLabel_cust_name().setText( invh.getCustomer());
    frame.getLabel_total_invoice().setText(""+invh.getInvoiceTotal());
    
            
        }

    
    }
    
}
