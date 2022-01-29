/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prosoftware;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author CORC
 */
public class inventory {

    
    
    private product d;
    public inventory() {
    
    
    }
    public inventory( String Pname,int Pid, double price, Date production_date, Date expire_date, int Pcount )
    {
        this.d=new product();
         
        
        
    }


    
    public String showProduct(int pID)
    {
        return "";
    }
    
}
