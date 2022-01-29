/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prosoftware;

import java.io.File;
import java.util.Date;


/**
 *
 * @author CORC
 */
public class purchase {
    
     File buyProduct = new File("purshes.txt");
   private Date PURdate;
  private Supplier s ;
 
    public purchase(Date PURdate, String companyName ,String Pname , int pid , int count , int telephone) {
        this.PURdate = PURdate;
        this.s = new Supplier();
        s.setCompanyName(companyName);
        s.setCount(count);
        s.setPid(pid);
        s.setPname(Pname);
        s.setTelephone(telephone);
    }

    
   
   public int ShowPurshuses(Date d, int pid)
   {
       
     
       return s.getCount();
       
   }
    
}
