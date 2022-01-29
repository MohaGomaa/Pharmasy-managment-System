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
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author CORC
 */
public class employee extends Pharmsiest {

    private double salary;
    product p;
    purchase pur; 
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
   
   
    inventory i;
    employee e;
    public boolean showAttendance(String Month ,int Years) throws FileNotFoundException {
    File attendance = new File("attendance.txt");
    File LateAttend = new File("LateAttend.txt");
    File Absent = new File("Absent.txt");
    GregorianCalendar gcalendar = new GregorianCalendar();
    String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep",
        "Oct", "Nov", "Dec"};
        Scanner sc ;
         if(Month.length()>3)
         {
             JOptionPane.showMessageDialog(null, "Invalid please enter First three characters");
             return false;
         }
        int counterAttend = 0;
        int counterAbsent = 0;
         String string;
         String []parts;
        if (!Month.equals(months)) {
            char x = Month.charAt(0);
            int i = (int) x - 32;
            Month = Month.replace(Month.charAt(0), (char) i);
        } 
        
           boolean att=false;
            sc = new Scanner(attendance);
        while (sc.hasNext()) {
            string  = sc.nextLine();
            parts=string.split(" ");
            if (Month.equals(parts[0])&&parts[2].equals(Integer.toString(Years))) {
                counterAttend++;
               att=true;
            }

        }
        sc.close();
          sc = new Scanner(Absent);
          while (sc.hasNext()) {
            string  = sc.nextLine();
            parts=string.split(" ");
            if (Month.equals(parts[0])&&parts[2].equals(Integer.toString(Years))) {
                counterAbsent++;
               att=true;
            }

        }
        sc.close();
        if(att!=true)
        {               if (counterAbsent==0)
                      JOptionPane.showMessageDialog(null,"Check the entered data");
                return false;
        }
        JOptionPane.showMessageDialog(null, "you attended: " + counterAttend+"you absent:"+counterAbsent);
        return true;
    }

    public boolean setAttendance() throws IOException {
        
    File attendance = new File("attendance.txt");
    File LateAttend = new File("LateAttend.txt");
    File Absent = new File("Absent.txt");
    GregorianCalendar gcalendar = new GregorianCalendar();
    String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep",
        "Oct", "Nov", "Dec"};
    FileWriter write;
    FileReader read;
    PrintWriter pw;
    Scanner Rsc;
//        write = new FileWriter(attendance.getAbsoluteFile(), true);
//        pw = new PrintWriter(write);
//        Rsc = new Scanner(attendance);
        String date = months[gcalendar.get(Calendar.MONTH)] + " " + gcalendar.get(Calendar.DATE) + " " + gcalendar.get(Calendar.YEAR);
        String time = gcalendar.get(Calendar.HOUR) + ":" + gcalendar.get(Calendar.MINUTE) + ":" + gcalendar.get(Calendar.SECOND);
        int TotalAbsent=0;
        int TotalAttend=0;
        int TotalLate=0;
        int hour = gcalendar.get(Calendar.HOUR);
        int min = gcalendar.get(Calendar.MINUTE);
        boolean flageLate = false;
        
        Rsc=new Scanner(attendance);
         while(Rsc.hasNext())
         {
             Rsc.nextLine();
             TotalAttend++;
         }
         TotalAttend /=2;
         
         Rsc=new Scanner(Absent);
         while(Rsc.hasNext())
         {
             Rsc.nextLine();
             TotalAbsent++;
         }
         TotalAbsent /=2;
         
         Rsc=new Scanner(LateAttend);
         while(Rsc.hasNext())
         {
             Rsc.nextLine();
             TotalLate++;
         }
         
         if (TotalAttend+TotalAbsent==30)
         {
            pw=new PrintWriter("attendance.txt");
            TotalAttend*=2;
              while(TotalAttend>0)
              {
                  pw.println("");
                  TotalAttend--;
              }
              pw.close();
              pw=new PrintWriter("Absent.txt");
              TotalAbsent*=2;
              while(TotalAbsent>0)
              {
                  pw.println("");
                  TotalAbsent--;
              }
               pw.close();
               pw=new PrintWriter("LateAttend.txt");
 
              while( TotalLate>0)
              {
                  pw.println("");
                   TotalLate--;
              }
              pw.close();
              
         }
         
        if((hour >= 11))
        {
            write = new FileWriter(Absent.getAbsoluteFile(), true);
            pw = new PrintWriter(write);
            Rsc=new Scanner(Absent);
            while (Rsc.hasNext()) {
            if (Rsc.nextLine().equals(date)) {
                JOptionPane.showMessageDialog(null, "Attendance IS already SETED  ABSENT");
                return false;
              }
            }
            JOptionPane.showMessageDialog(null, "YOUR ATTENDANCE IS SETED  ABSENT");
            pw.println(date);
            pw.println (time);
            pw.close();
            return false;
        }
        if (hour >9) {
            write = new FileWriter(LateAttend.getAbsoluteFile(), true);
            pw = new PrintWriter(write);
            Rsc=new Scanner(LateAttend);
            while (Rsc.hasNext()) {
            if (Rsc.nextLine().equals(date)) {
                JOptionPane.showMessageDialog(null, "Attendance IS already SETED  LATE");
                return false;
            }
        }
            JOptionPane.showMessageDialog(null, "YOU ARE Late HOUR:" + (hour - 8) + "MINUTE:" + (min - 30) );
            pw.println(date );
            pw.println(time);
            flageLate = true;
            pw.close();
        }
        write = new FileWriter(attendance.getAbsoluteFile(), true);
        pw = new PrintWriter(write);
         Rsc=new Scanner(attendance);
         while (Rsc.hasNext()) {
            if (Rsc.nextLine().equals(date)) {
                JOptionPane.showMessageDialog(null, "Attendance IS already Seted");
                return false;
            }
        }
        pw.println(date);
        pw.println(time);
        pw.close();
        if (flageLate != true) {
            JOptionPane.showMessageDialog(null, "Successful Attend HOUR:" + (hour - 8) + "MINUTE:" + (30 - min) );
        }
        return true;
    }

    public String  showSalary() throws FileNotFoundException {
//         File SalaryFile=new File("showSalary.txt");
//          GregorianCalendar gcalendar = new GregorianCalendar();
//          String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep",
//        "Oct", "Nov", "Dec"};
//           String M = months[gcalendar.get(Calendar.MONTH)] ;
//           
//           int count=0;
//           while(count<=12)
//           {
//               if(M.equals(months[count]))
//               {    count --;
//                   break;
//               }
//               count++;
//           }
//           
//              int year= gcalendar.get(Calendar.YEAR);
//        Scanner sc ;
//          sc=new Scanner(SalaryFile);
//          String string;
//          String []parts;
//          while(sc.hasNext())
//          {
//              string=sc.nextLine();
//              parts=string.split(" ");
//          }
        return "";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            Scanner sc = new Scanner(System.in);

            Scanner sclog = new Scanner(log);
            String passId = Integer.toString(id).concat(password);
            String passIdSearch;

            while (sclog.hasNext()) {
                passIdSearch = sclog.next();
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


}
