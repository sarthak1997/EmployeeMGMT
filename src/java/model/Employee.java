package model;

public class Employee {
    int eid;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }
    String ename=null;
    String edept=null;
    long esalary;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

  

    public String getEdept() {
        return edept;
    }

    public void setEdept(String edept) {
        this.edept = edept;
    }

    public long getEsalary() {
        return esalary;
    }

    public void setEsalary(long esalary) {
        this.esalary = esalary;
    }
    
}
