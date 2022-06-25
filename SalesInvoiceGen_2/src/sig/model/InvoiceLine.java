/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sig.model;


/**
 *
 * @author AyetAllah
 */
public class InvoiceLine {
    private InvoiceHeader header;
    private int ID;
    private  String itemName;
    private float itemPrice;
    private int count; 
     
    public InvoiceLine(){};
    // String items, double price, int count, InvoiceHeader header) 
   public InvoiceLine(int id,String itemName,float itemPrice,int count,InvoiceHeader header){
        this.ID=id;
    this.count=count;
    this.header=header;
    this.itemName=itemName;
    this.itemPrice=itemPrice;
    }
    public InvoiceLine(String itemName,float itemPrice,int count,InvoiceHeader header )
    {//this.ID=id;
    this.count=count;
    this.header=header;
    this.itemName=itemName;
    this.itemPrice=itemPrice;
        
    }/*
     InvoiceLine(int id,String itemName,float itemPrice,int count,InvoiceHeader header )
    {this.ID=id;
    this.count=count;
    this.header=header;
    this.itemName=itemName;
    this.itemPrice=itemPrice;
        
    }*/
     public  double getTotalLine(){
     return itemPrice*count;
 };
    public InvoiceHeader getHeadder()
    {
        return this.header;
    }
    public void setHeadder(InvoiceHeader invheader)
    {
         this.header=invheader;
    }
    public void setID(int i){
        this.ID=i;
    }
    
 public int getID(){
        return this.ID;
    }
   public void setitemName(String s){
        this.itemName=s;
                
    }
    
 public String getitemName(){
        return this.itemName;
    }
 
 
   public void setitemPrice(float f){
        this.itemPrice=f;
                
    }
    
 public float getitemPrice(){
        return this.itemPrice;
    }
     public void setCount(int i){
        this.count=i;
                
    }
    
 public int getCount(){
        return this.count;
    }
 
 
   @Override
    public String toString(){
        // in file 2	Mouse	35	1
        //Item2Name, Item2Price, Count2
        
return ""+this.getitemName()+" "+this.getitemPrice()+" "+this.getCount();

}
    //2	Mouse	35	1

       public String toString_save_console(){
           
               return this.getID()+","+this.getitemName()+","+this.getitemPrice()+","+this.getCount();
           
        
           
       }
}

