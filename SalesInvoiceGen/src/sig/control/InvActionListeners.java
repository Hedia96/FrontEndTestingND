/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sig.control;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
//import java.util.Collection;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import sig.model.InvHeaderTableModel;
import sig.model.InvLineTableModel;
import sig.model.InvoiceHeader;
import static sig.model.InvoiceHeader.df;
import sig.model.InvoiceLine;
import sig.view.NewHeaderDialog;
import sig.view.NewLineDialog;
import sig.view.SigFrame;
/**
 *
 * @author AyetAllah
 */
public class InvActionListeners implements ActionListener{
    private SigFrame frame/* new SigFrame()*/;
    private NewHeaderDialog headerdialog;
    private NewLineDialog linedialog;
    
    
  /* public InvActionListeners(){
        
    };*/
public InvActionListeners(SigFrame frame){
  this.frame=frame;
  //this.headerdialog=frame.getInvdialog();
  linedialog =new NewLineDialog(this.frame);
 
  
};
    @Override
    
    
    public void actionPerformed(ActionEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       switch(e.getActionCommand())
       {
           case"Load File":
           
               // load file invoiceheader in table 
               System.out.print("i am in actio000000000000000000000n load file");
                loadfiles();

           break;
           case "CancelInv":
               NewInvDialogCancel();
               break;
          
           case"CreateInvOK":
                   NewInvDialogOK();
           
               
           break;
           case "Create Invoice":
              // System.out.println("preess on create invoice ");
               createInvoice();
               break;
           case "Delete Invoice":
              deleteInv();
                break;
           case "New Line":
               addNewLine();
               break;
           case "newLineOK":
               NewLineDialogOK();
               break;
           case "newLineCancel":
                NewInvLineCancel();
               break;
           default:
               System.out.println(e.getActionCommand());
          
       }
    }

     public  void loadfiles() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         
    
        JFileChooser fc=new JFileChooser();
        ArrayList<InvoiceLine> invlarr=new ArrayList<>();
       int result=fc.showOpenDialog(frame);
       try{
           if(result==JFileChooser.APPROVE_OPTION)
           {
               
               File headerf=fc.getSelectedFile();
               Path headerp=Paths.get(headerf.getAbsolutePath());
               List<String> headerrecords=Files.readAllLines(headerp);
                 ArrayList<InvoiceHeader> invharr=new ArrayList<>();
               for(int i=0;i<headerrecords.size();i++)
               {
                 String[] arr=headerrecords.get(i).split(",");
                 // constructor:int string date
                 InvoiceHeader invh =new InvoiceHeader(Integer.parseInt(arr[0]),arr[2],InvoiceHeader.df.parse(arr[1]));
                 System.out.println(invh.toString());
                 invharr.add(invh);
               }
                  // return the array of headders 
                 // System.out.println("fffffffffffffffffffffffffffffff"+invharr);
                 frame.setHeaders(invharr);
                 result=fc.showOpenDialog(frame);
                 
                 
               if(result==JFileChooser.APPROVE_OPTION)
               {
                    
                    File linef=fc.getSelectedFile();
                    Path linep=Paths.get(linef.getAbsolutePath());
                    List<String> linerecords=Files.readAllLines(linep);
              
               for(int i=0;i<linerecords.size();i++)
               {
                 String[] arr=linerecords.get(i).split(",");
                  int id=Integer.parseInt(arr[0]);
                  // try to get the object itself related to the id
                 InvoiceHeader inv=frame.getObject(id);
                 
                
                 float price= Float.parseFloat(arr[2]);
                 String name= arr[1];
                 int count= Integer.parseInt(arr[3]);
                 //String itemName,float itemPrice,int count,InvoiceHeader header 
                 InvoiceLine invl = new InvoiceLine(id,name,price,count,inv); //2	Mouse	35	1
                
                 inv.getLines().add(invl);
                  System.out.println(invl.toString());
               }
               
               
      
               }
               //System.out.println("Dddddddddddddd"+invharr.size());
               InvHeaderTableModel invhTablemdl= new InvHeaderTableModel(invharr);
               frame.setHtmodel(invhTablemdl);
               frame.getTable_invoices().setModel(invhTablemdl);
               
               InvLineTableModel invlTablemdl=new InvLineTableModel(invlarr) ;
               frame.setLtmodel(invlTablemdl);
               frame.getTable_Invoice_lines().setModel(invlTablemdl);
               
           }
        
           
       }catch(IOException ex)
       {
             JOptionPane.showMessageDialog(frame, ex.getMessage(),"Error io in first file",JOptionPane.ERROR_MESSAGE); 
       } catch (ParseException ex) {
           // Logger.getLogger(InvActionListeners.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(frame, ex.getMessage(),"Error parsing date in first file",JOptionPane.ERROR_MESSAGE); 
        }
              
       
    }
     
     
     void createInvoice()
     {
        headerdialog= new NewHeaderDialog(this.frame);
        Date d= new Date();
        System.out.println("hello from myactionlistenres");
        headerdialog.setVisible(true);
        // get the data from dialog and put it into table model
       // headerdialog.getCustNameField().setText("EnterNameCustomer");
      //  headerdialog.getInvDateField().setText("00-00-0000");
       /* String name=headerdialog.getCustNameField().getText();
        String date= headerdialog.getInvDateField().getText();
        
       
        System.out.println(" d "+d);
        System.out.println(" date "+date);
        try {
            d= InvoiceHeader.df.parse(date);
        } catch (ParseException ex) {
           // Logger.getLogger(SigFrame.class.getName()).log( .SEVERE, null, ex);
           JOptionPane.showMessageDialog(null,"parsing is incorectr","title_message_error",JOptionPane.ERROR_MESSAGE);
        }*/
               
     }
     /********************************************************************************************
      * NewInvDialogOK : this method for created invoice   saving the data from text fields name and date for anew invoice 
      * 
      * 
      * 
      * *******************************************************************************************/
    void NewInvDialogOK()
    {
     // System.out.println("press okkkke ");
      headerdialog.setVisible(false);
     
       String name=headerdialog.getCustNameField().getText();
        String date= headerdialog.getInvDateField().getText();
         Date d= new Date();
         
         
       
        try {
            d= InvoiceHeader.df.parse(date);
        
            
        int id= getMaxInvID(frame.getHeaders());
        id++;
        /*invh.setCustomer(name);
           invh.setCreatedDate(d);*/
        InvoiceHeader invh= new InvoiceHeader(id,name,d);
        frame.getHeaders().add(invh);
       /* for(int i=0;i<frame.getHeaders().size();i++)
        {
             System.out.println(frame.getHeaders().get(i));
        }*/
       // show in the table
       frame.getHtmodel().fireTableDataChanged();
       
      //headerdialog.setVisible(false);
      headerdialog.dispose();
      headerdialog=null; // initalize by null as it will be created again if user press again on newinvoice 
        } catch (ParseException ex) {
           // Logger.getLogger(SigFrame.class.getName()).log( .SEVERE, null, ex);
           JOptionPane.showMessageDialog(null,"parsing is incorrect","title_message_error",JOptionPane.ERROR_MESSAGE);
        }
                  
    
        
    }
   private int getMaxInvID(ArrayList<InvoiceHeader> invs)
    {int max=0;
        //ArrayList<InvoiceHeader> invs;
        for (int i=0;i<invs.size();i++)
        {
            if(max<invs.get(i).getID())
            {
                max=invs.get(i).getID();
            }
        }
        return max;
    }
    void NewInvDialogCancel()
    {
     headerdialog.setVisible(false);
        //headerdialog.setVisible(false);
          System.out.println("press canccel ");
      headerdialog.dispose();
        
    }
    public void deleteInv()
    {
         int indexrow =frame.getTable_invoices().getSelectedRow();
               if(indexrow!=-1)
               {
                    //JOptionPane.YES_NO_CANCEL_OPTION
                   int messageconfirm =JOptionPane.showConfirmDialog(null,"Are U sure to delete ?", "Delete Invoice!!",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
                   //System.out.println(messageconfirm+"ddddddddddddddddddddddddddddddddddddd");
                   // return of confirmation message 1 is no and 0 is yes
                   if (messageconfirm==0)
                   {
                       frame.getHeaders().get(indexrow).setLines(null);
                       // get the id of selected invoice
                       //InvoiceHeader inv= frame.getHeaders().get(indexrow);
                       
                       // then delete the lines has this id
                        // delete the lines too related to that id
                       frame.getLines().clear();
                       frame.getHeaders().remove(indexrow);
                       //frame.getTable_Invoice_lines()
                       frame.getHtmodel().fireTableDataChanged();
                       frame.getLtmodel().fireTableDataChanged();
                       frame.getTable_Invoice_lines().setModel(new InvLineTableModel(frame.getLines()));
                       frame.getLabel_inv_id().setText("");
                        frame.getLabel_inv_date().setText( "");
                        frame.getLabel_cust_name().setText("");
                        frame.getLabel_total_invoice().setText("");
                   }
                  
                  else {    }
          
           
                  
                  
                   // delete the lines too related to that id 
               }
              // System.out.println("delete invoice");
    }
    public void  addNewLine()
    {   int selectedinvindex=frame.getTable_invoices().getSelectedRow();
        // InvoiceHeader inv =frame.getHeaders().get(selectedinvindex);
         
        if(selectedinvindex!=-1)
        {
             // needed to select invoice 
        NewLineDialog lindialog= new NewLineDialog(frame);
        lindialog.setVisible(true);
        
        }
       
        
    }

    private void NewInvLineCancel() {
        
          linedialog.setVisible(false);
        //headerdialog.setVisible(false);
          System.out.println("press canccel for line dailog ");
      linedialog.dispose();
        
    }

    private void NewLineDialogOK() {
         linedialog.setVisible(false);
       try
         {   
     int selectedinvindex=frame.getTable_invoices().getSelectedRow();
     InvoiceHeader h=frame.getObject(selectedinvindex);
     if(selectedinvindex!=-1){
         String itemname=linedialog.getItemNameField().getText();
        String count= linedialog.getItemCountField().getText();
        String price=linedialog.getItemPriceField().getText();
         ArrayList<InvoiceLine> lines= h.getLines();
         int icount=Integer.parseInt(count);
         float fprice=Float.parseFloat(price);
         InvoiceLine l=new InvoiceLine(itemname,fprice,icount,h);
         //int id,String itemName,float itemPrice,int count,InvoiceHeader header
          lines.add(l);
        System.out.println(lines+  "here the new lines after added");
        
             
         }
       
        
         
     }catch(NumberFormatException ex)
     {
          JOptionPane.showMessageDialog(null,"parsing is incorrect","NumberformatException",JOptionPane.ERROR_MESSAGE);
     }
       
        
    linedialog.dispose();
    //linedialog=null;
     
    }



}
