/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prosoftware;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author CORC
 */
public class ProSoftware {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
       
       Admin a = new Admin();
       employee e = new employee();
//       LogIn_Frame log = new LogIn_Frame();
//       log.setVisible(true);
      Scanner sc = new Scanner(System.in);
      int id = sc.nextInt();
      String name = sc.next();
                         double price = sc.nextDouble();
                          int count = sc.nextInt();

            e.AddProduct(id, name, price, count);
      
      
      
////       int Pid=sc.nextInt();String Pname=sc.next(); double price=sc.nextDouble();
////       String expire_date=sc.next(); 
////       String production_date=sc.next();
////       int count=sc.nextInt();
//       
////       
////       a.AddProduct(Pid,Pname,price,expire_date,production_date,count);
//
//
////     ------------------------------------- save data customer -------------------------------  
////String name = sc.next(); 
////long telephone = sc.nextLong();
////double discount=sc.nextDouble();
////        System.out.println(a.SaveDataCust(name, telephone, discount));
//
////------------------------------------------ sign up or login -------------------------------------
//int id = sc.nextInt();
//String pass = sc.next();
//
//
//System.out.println(a.login(id, pass)); 


//////////////////////////////Set attendance/////////////////////////////
//String m = sc.next();
//int y = sc.nextInt();
//employee e=new employee();
//       System.out.println(e.showAttendance(m,y));

//////////////////   Show employee salary//////////
//     int id = sc.nextInt();
//       System.out.println(a.showempSalary(id));

//    int id =sc.nextInt();
//   double s=sc.nextDouble();
//   double p=sc.nextDouble();
//        System.out.println(a.setEmpSalary(id, s, p));

    }
    
}
