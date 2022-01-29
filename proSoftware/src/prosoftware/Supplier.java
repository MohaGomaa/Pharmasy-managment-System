/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prosoftware;

/**
 *
 * @author CORC
 */
public class Supplier {
    
   private String companyName ,pname ;

    public String getCompanyName() {
        return companyName;
    }

    public String getPname() {
        return pname;
    }

    public int getPid() {
        return Pid;
    }

    public int getTelephone() {
        return telephone;
    }

    public int getCount() {
        return count;
    }
    private int Pid,telephone,count;

    public Supplier() {
    }
    
    

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setPid(int Pid) {
        this.Pid = Pid;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    
}
