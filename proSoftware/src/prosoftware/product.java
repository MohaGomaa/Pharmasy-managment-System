/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prosoftware;

import java.util.Date;

/**
 *
 * @author CORC
 */
public class product {
   private  String Pname;
   private int Pid; 
   private double price;
   private Date production_date;
   private Date expire_date;
   private int Pcount;

    public product() 
    {
       
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String Pname) {
        this.Pname = Pname;
    }

    public int getPid() {
        return Pid;
    }

    public void setPid(int Pid) {
        this.Pid = Pid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getProduction_date() {
        return production_date;
    }

    public void setProduction_date(Date production_date) {
        this.production_date = production_date;
    }

    public Date getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(Date expire_date) {
        this.expire_date = expire_date;
    }

    public int getPcount() {
        return Pcount;
    }

    public void setPcount(int Pcount) {
        this.Pcount = Pcount;
    }
    
    public String search_Product(Date de ,int id )
    {
        return"";
    }
   
   
}
