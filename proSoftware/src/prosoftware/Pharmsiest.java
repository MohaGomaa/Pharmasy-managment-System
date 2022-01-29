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
public abstract class Pharmsiest {
    
    private  String name;
   private int id ;
    private String password;
    
    public abstract  void AddProduct(int Pid, String Pname, double price, int count);
    public abstract void AddProduct(int Pid );
    public abstract String SellProduct (int id , int count);
    public abstract boolean SaveDataCust(String name , long telephon , double discountRate);
    public abstract String buyProduct(int id, String name, double price, int count);
    public abstract boolean login(int id , String password);
    
    
}
