package jaxb.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement(name = "Organization")
@XmlType(propOrder = {"name", "departments"})
public class Organization {
    private String name;
    private List<Department> departments;

    public Organization() {
    }

    public Organization(String name, List<Department> departments) {
        this.name = name;
        this.departments = departments;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElementWrapper(name = "departments")
    @XmlElement(name = "department")
    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}

