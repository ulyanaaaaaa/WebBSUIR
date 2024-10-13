package jaxb.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
public class Employee {
    private String empNo;
    private String empName;
    private String managerNo;

    public Employee() {
    }

    public Employee(String empNo, String empName, String managerNo) {
        this.empNo = empNo;
        this.empName = empName;
        this.managerNo = managerNo;
    }

    @XmlElement
    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    @XmlElement
    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @XmlElement
    public String getManagerNo() {
        return managerNo;
    }

    public void setManager(String managerNo) {
        this.managerNo = managerNo;
    }
}
