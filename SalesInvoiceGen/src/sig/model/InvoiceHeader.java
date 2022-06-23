/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sig.model;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author AyetAllah
 */
public class InvoiceHeader {
    /*  the relation between classes is the Association(has-a) 
    OMR  is pattern of design  */
    
    
    ArrayList<InvoiceLine> lines;
    int ID;
    public static DateFormat df =new  SimpleDateFormat("dd-MM-yyyy");
    Date createdDate; // format of date is DD-MM-YYYY
    String cutomerName;
    // double Total; // total the all lines related to invoice id in invoiceline file
    
    public InvoiceHeader() {
     //initalize the values
    }
    public InvoiceHeader(int num, String customer, Date InvDate)
    {
        ID=num;
        this.cutomerName=customer;
        this.createdDate=InvDate;
    }
    /*public ArrayList<InvoiceLine>GetLines(){
        if(this.lines==null){
            lines=new ArrayList<>();
               }
        return lines;
        
    };*/
  /*public double getTotal()  {
      double res=0.0;
      for(int i=0;i<lines.size();i++)
      {
          res+=lines.get(i).getTotalLine();
      }
      
      return res;
      
  }*/
     public String getCreatedDate() {
         System.out.println("sssssssssssssssssssss"+ createdDate);
         if(createdDate==null){
             createdDate= new Date();
         }
        return df.format(createdDate);
    }

    public void setCreatedDate(Date d) {
        this.createdDate=d;
    }
    
   
    
 
    public int getID() {
        return ID;
    }

    public void setID(int num) {
        this.ID = num;
    }
     public String getCustomer() {
        return cutomerName ;
    }

    public void setCustomer(String customer) {
        this.cutomerName = customer;
    }

     
    public ArrayList<InvoiceLine> getLines() {
        
        if (lines==null){
        lines=new ArrayList<InvoiceLine>();
        }
        return lines;
    }

    public void setLines(ArrayList<InvoiceLine> lines) {
        this.lines = lines;
    }

   public double getInvoiceTotal(){
   
       double total=0.0;
       for(int i=0; i< getLines().size();i++){
       total+= getLines().get(i).getTotalLine();
       }
       return total;
   }

    @Override
    public String toString() {
        return "InvoiceHeader{ num="+ID + ","+" Customer ="+ cutomerName + " Date="+df.format(createdDate)+"}" ;
    }
   
   
    
}

    
    
    

