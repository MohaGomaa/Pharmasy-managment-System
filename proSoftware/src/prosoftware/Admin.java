/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prosoftware;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author CORC
 */
public class Admin extends Pharmsiest {
    File order = new File("order.txt");
    File buyProduct = new File("buyProduct.txt");
    File file = new File("Product.txt");
    File custFile = new File("customer.txt");
    File log = new File("login.txt");
    File idFile = new File("id.txt");
    FileWriter c;
    FileReader read;
    PrintWriter pw;
    Scanner scr;
    product p;
    purchase pur;
    inventory i;
    employee e;
    public String ShowempAttendance(int empID) {
        return "";

    }

    public String delete_product(int Pid) {

         return "";

    }

    public boolean showempSalary(int empid) throws FileNotFoundException {
          File SalaryFile=new File("showSalary.txt");
         GregorianCalendar gcalendar = new GregorianCalendar();
        String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep",
        "Oct", "Nov", "Dec"};
        String date = months[gcalendar.get(Calendar.MONTH)] + gcalendar.get(Calendar.YEAR);
        Scanner sc;
        String empID = Integer.toString(empid);
        String string;
        String []parts;
        sc = new Scanner(idFile);
        boolean flagID=false;
           while (sc.hasNext())
           {
               if(empID.equals(sc.next()))
               {  flagID=true;
                     sc.close();
                   break;
               }
           }
           if(flagID!=true)
           {
               JOptionPane.showMessageDialog(null, "ID IS Not Found ");
               return false;
           }
            sc = new Scanner(SalaryFile);
        while (sc.hasNext()) {
             string = sc.nextLine();
             parts=string.split("-");
            if (empID.equals(parts[0])&&date.equals(parts[2])) 
            {
        JOptionPane.showMessageDialog(null, "the salary is : "+parts[1]+" In "+months[gcalendar.get(Calendar.MONTH)]+" / " + gcalendar.get(Calendar.YEAR) );
                sc.close();
                return true;
            }

        }

        JOptionPane.showMessageDialog(null, "no salary found");
        return false;
    }

    public boolean setEmpSalary(int empID, double empSalary,double penalty) throws FileNotFoundException, IOException {
         File attendfile=new File("attendance.txt");
         File latefile=new File("LateAttend.txt");
         File Absentfile=new File("Absent.txt");
           File SalaryFile=new File("showSalary.txt");
          GregorianCalendar gcalendar = new GregorianCalendar();
        String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep",
        "Oct", "Nov", "Dec"};
         String date = months[gcalendar.get(Calendar.MONTH)]+gcalendar.get(Calendar.YEAR);
         Scanner Rsc;
         int TotalLate=0;
         int TotalAbsent=0;
         int TotalAttend=0;
         double absent_rate;
         double late_rate;
         if(empSalary <1500 ||empSalary >5000)
         {
           JOptionPane.showMessageDialog(null,"The Amount of Salary Is out of range from 1500 to 5000");
                return false;
         }
         if( penalty<0 ||penalty >10)
         {
           JOptionPane.showMessageDialog(null,"The Amount of penalty Is out of range from 0% to 10%");
               return false;
         }
         
             c=new FileWriter(idFile.getAbsoluteFile(), true);
              pw=new PrintWriter(c);
              Rsc=new Scanner(idFile);
              boolean idExist =false;
              while(Rsc.hasNext())
              {
                  if(Rsc.next().equals(Integer.toString(empID)))
                  {
                        idExist=true;
                        break;
                 }  
              }
         if(idExist== true)
        {
         
         Rsc=new Scanner(latefile);
         while(Rsc.hasNext())
         {
             Rsc.nextLine();
             TotalLate++;
         }
         TotalLate /=2;
         Rsc=new Scanner(Absentfile);
         while(Rsc.hasNext())
         {
             Rsc.nextLine();
             TotalAbsent++;
         }
         TotalAbsent /=2;
         Rsc=new Scanner(attendfile);
         while(Rsc.hasNext())
         {
             Rsc.nextLine();
             TotalAttend++;
         }
         TotalAttend /=2;
         String string;
         String []salaryInfo;
         String IDnFile;
         String SAnFile;
         String DatFile;
         if(TotalAttend+TotalAbsent==30)
         {
              late_rate=empSalary*(TotalLate*(penalty/100)); // minus -0.5%(0.005)
              absent_rate=empSalary*(TotalAbsent*((penalty/100)+0.0283));   // minus -3.3%(latePen+0.0283)
              empSalary=empSalary-(late_rate+absent_rate);
             Rsc=new Scanner(SalaryFile);
          while(Rsc.hasNext())
         {
                
             string=Rsc.nextLine();
             salaryInfo=string.split("-");
             IDnFile=salaryInfo[0];
             SAnFile=salaryInfo[1];
             DatFile=salaryInfo[2];
              if(DatFile.equals(date)&&IDnFile.equals(Integer.toString(empID)))
              {
                
                JOptionPane.showMessageDialog(null,"Salary is aready added");
                return false;
              }
                
         }
            
                  c=new FileWriter(SalaryFile.getAbsoluteFile(), true);
                  pw=new PrintWriter(c);
                  pw.println(empID+"-"+empSalary+"-"+date);
                  pw.close();
               JOptionPane.showMessageDialog(null,"Salary is added");
                  
              }
         else{   
             JOptionPane.showMessageDialog(null,"Employee Has ID"+empID+"Dont complete 30 DAY Work");
                return false;
              }
         }
         else{   
             JOptionPane.showMessageDialog(null,"Employee Has ID"+empID+"IS NOT FOUND");
                return false;
              }
         return true;
    }    

    @Override
     public void AddProduct(int Pid, String Pname, double price, int count) {

        try {

            c = new FileWriter(file.getAbsoluteFile(), true);
            pw = new PrintWriter(c);
            Scanner sc = new Scanner(file);
            String idserch = Integer.toString(Pid);
            boolean flag = true;
            while (sc.hasNext()) {
                if (sc.next().equals(idserch)) {

                    JOptionPane.showMessageDialog(null, "this product is aleady exists");
                    flag = false;
                    break;
                }

            }
            if (flag == true) {
                pw.println(Pid + " " + Pname + " " + price + " " + count);
                JOptionPane.showMessageDialog(null,"product is added ");
                pw.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void AddProduct(int Pid) {

    }

    @Override
    public String SellProduct(int id, int count) {
           
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter s ;
        double totalPrice = 0;
        c = null;
          if(count<=0)
          {
              JOptionPane.showMessageDialog(null,"Invalid Count at least 1 to Sell");
             return "Not Done";
          }
        try {
            reader = new BufferedReader(new FileReader(file));

         

            String oldLine = "";

            String newstring = "";
            Scanner sc = new Scanner(file);
            String string;
            String[] part;
            String partCount;
            String idfile = Integer.toString(id);
            int counterFile = 0;
             boolean IDnExist=false;
             
            while (sc.hasNext()) {

                oldLine = sc.nextLine();
                part = oldLine.split(" ");
                if (idfile.equals(part[0])) {
                    IDnExist=true;
                    String price = part[2];
                    String counter = part[3];
                    counterFile = Integer.parseInt(counter) - count;
                    if(counterFile<=0)
                    {
                        JOptionPane.showMessageDialog(null,"The count of this product is littel than order");
                             return "false";
                    }
                    newstring = id + " " + part[1] + " " + part[2] + " " + counterFile;
                    double pricePerPro= Double.parseDouble(price);
                    totalPrice = count * pricePerPro;//parse price to integer
                     s = new FileWriter(order.getAbsoluteFile(), true);
                    pw = new PrintWriter(s);
                    pw.println(id + " " + count + " " + totalPrice);
                    JOptionPane.showMessageDialog(null, part[1] + " " + count + " total price :" + totalPrice);
                    pw.close();
                    s.close();
                    
                    break;

                }
                
            }
            if(IDnExist!=true){
            JOptionPane.showMessageDialog(null,"Product IS Not Exist");
             return "false";
            }
            
            
            
            
            //reading all lines of input text file into oldContent 
            String line = reader.readLine();
            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();

            }
            // replacing old string with newString in the OldContent

            String newContent = oldContent.replaceAll(oldLine, newstring);
            // rewriting the input text file with the newContent
            c = new FileWriter(file);
            c.write(newContent);

           

        } catch (IOException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
                c.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return Double.toString(totalPrice);

    }

    @Override
    public boolean SaveDataCust(String name, long telephon, double discountRate) {
        try {
            Scanner ss = new Scanner(System.in);
            while (Long.toString(telephon).length() < 9 || Long.toString(telephon).length() > 10) {

                JOptionPane.showMessageDialog(null, "Invalid Telephon Number,ReEnter the telephone number");
                telephon = ss.nextLong();
            }
            c = new FileWriter(custFile.getAbsoluteFile(), true);

            pw = new PrintWriter(c);
            String line;
            //    read = new FileReader(custFile.getAbsoluteFile(),true);
            scr = new Scanner(custFile);
            boolean flage = false;

            while (scr.hasNext()) {
                line = scr.next();
                if (line.equals("+20" + Long.toString(telephon))) {
                    flage = true;
                    JOptionPane.showMessageDialog(null, "The customer is already exist");
                    return false;

                }
            }
            scr.close();
            if (flage == false) {
                pw.println("+20" + telephon);
                pw.println(name);
                pw.println(discountRate);
                JOptionPane.showMessageDialog(null, "data is saved ");

            }
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
        public String buyProduct(int id, String name, double price, int count) {
        int counterFile;
        

        String oldContent = "";
        BufferedReader reader = null;
        c = null;

        try {

            reader = new BufferedReader(new FileReader(file));

            c = new FileWriter(file.getAbsoluteFile(), true);
            pw = new PrintWriter(c);

            Scanner sc = new Scanner(file);
            String idfile = Integer.toString(id);

            String string;
            String[] part;
            String partCount;

            String oldLine = "";

            String newstring = "";
            boolean flag = false;

            while (sc.hasNext()) {

                oldLine = sc.nextLine();
                part = oldLine.split(" ");
                if (idfile.equals(part[0])) {
                    flag = true;

                    String counter = part[3];
                    counterFile = Integer.parseInt(counter) + count;
                    newstring = id + " " + name + " " + price + " " + counterFile;

                    break;

                }

            }
            if(flag != true)
            {
                JOptionPane.showMessageDialog(null, "the product does not exist");
                return"not done";
            }
            
            
            
            
            //reading all lines of input text file into oldContent 
            String line = reader.readLine();
            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();

            }
            // replacing old string with newString in the OldContent

            String newContent = oldContent.replaceAll(oldLine, newstring);
            // rewriting the input text file with the newContent
            c = new FileWriter(file);
            c.write(newContent);

            pw.close();

        } catch (IOException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
                c.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        JOptionPane.showMessageDialog(null, "Done");
        return "done";
    }

    @Override
    public boolean login(int id, String password) {

        try {      
             File loginAdmin = new File("loginAdmin.txt");

             scr = new Scanner(loginAdmin);
            String passId = Integer.toString(id).concat(password);
            String passIdSearch;

            while (scr.hasNext()) {
                passIdSearch = scr.next();
                if (passIdSearch.equals(passId)) {
                    return true;
                }
            }
            JOptionPane.showMessageDialog(null, "invalid input");
            return false;

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    public boolean addEmployee(int id, String password) throws IOException {
        Scanner sc = new Scanner(System.in);
        FileWriter sysId = new FileWriter(idFile.getAbsoluteFile(), true);
        PrintWriter pwId = new PrintWriter(sysId);
        Scanner scId = new Scanner(idFile);
        boolean flagId = false;

        c = new FileWriter(log.getAbsoluteFile(), true);
        pw = new PrintWriter(c);

        String idSearch;
        while (id > 1000 || id <= 0) {
            JOptionPane.showMessageDialog(null, "please enter an id between 1 and 1000");
            id = sc.nextInt();
        }

        while (scId.hasNext()) {
            idSearch = scId.next();
            if (idSearch.equals(Integer.toString(id))) {

                JOptionPane.showMessageDialog(null, "This ID is already exsits");
                return false;

            }

        }

        if (password.length() != 8) {
            JOptionPane.showMessageDialog(null, " password is only 8 characters  ");
            return false;
        }
        pwId.println(id);    //print in id file

        String passId = Integer.toString(id).concat(password);
        pw.println(passId);
        pwId.close();
        pw.close();
       JOptionPane.showMessageDialog(null, "The New Employee is Added");
        return true;
    }

}
