import jaxb.model.Department;
import jaxb.model.Employee;
import jaxb.model.Organization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TestExample {

    private static final String XML_FILE = "C:\\Users\\Ulyana\\Desktop\\веб\\веб\\Project3\\JAXB_\\org-info.xml";

    public static void main(String[] args) {

        Employee emp1 = new Employee("E01", "Petya", null);
        Employee emp2 = new Employee("E02", "Tanya", "E01");
        Employee emp3 = new Employee("E03", "Kolya", null);
        Employee emp4 = new Employee("E04", "Lisa", "E02");

        List<Employee> list = new ArrayList<>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        list.add(emp4);

        Department dept1 = new Department("D01", "Dep1", "NEW YORK");
        dept1.setEmployees(list);

        Department dept2 = new Department("D02", "Dep2", "LOS ANGELES");
        List<Employee> list2 = new ArrayList<>();
        list2.add(new Employee("E05", "Anna", "E01"));
        list2.add(new Employee("E06", "Max", "E04"));
        dept2.setEmployees(list2);

        List<Department> departments = new ArrayList<>();
        departments.add(dept1);
        departments.add(dept2);

        Organization org = new Organization("My Organization", departments);

        try {
            JAXBContext context = JAXBContext.newInstance(Organization.class);

            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            m.marshal(org, System.out);

            File outFile = new File(XML_FILE);
            m.marshal(org, outFile);

            System.err.println("Write to file: " + outFile.getAbsolutePath());

            Unmarshaller um = context.createUnmarshaller();

            Organization orgFromFile = (Organization) um.unmarshal(new FileReader(XML_FILE));
            List<Department> depts = orgFromFile.getDepartments();
            for (Department dept : depts) {
                System.out.println("Department: " + dept.getDeptName());
                for (Employee emp : dept.getEmployees()) {
                    System.out.println("  Employee: " + emp.getEmpName());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
