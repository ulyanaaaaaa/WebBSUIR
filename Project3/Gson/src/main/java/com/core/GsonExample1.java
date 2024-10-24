package com.core;

import com.domain.Staff;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GsonExample1 {

    public static void main(String[] args) {

        // pretty print
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithModifiers(Modifier.TRANSIENT, Modifier.TRANSIENT)
                .create();

        ArrayList<Staff> staffs = createStaffObject();

        String json = gson.toJson(staffs);

        try (FileWriter writer = new FileWriter("C:\\Users\\Ulyana\\Desktop\\веб\\веб\\Project3\\Gson\\json\\student.json")) {
            gson.toJson(staffs, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Staff> createStaffObject() {

        Staff staff = new Staff();
        Staff staff1 = new Staff();
        Staff staff2 = new Staff();
        ArrayList<Staff> arr = new ArrayList<Staff>();


        staff.setName("Oleg");
        staff.setAge(35);
        staff.setPosition(new String[]{"Founder", "CEO", "coder"});
        Map<String, BigDecimal> salary = new HashMap() {{
            put("2010", new BigDecimal(10000));
            put("2012", new BigDecimal(12000));
            put("2018", new BigDecimal(14000));
        }};
        staff.setSalary(salary);
        staff.setSkills(Arrays.asList("java", "python", "node", "kotlin"));


        staff1.setName("Oleg1");
        staff1.setAge(351);
        staff1.setPosition(new String[]{"Founder1", "CEO1", "coder1"});
        Map<String, BigDecimal> salary1 = new HashMap() {{
            put("2010", new BigDecimal(100001));
            put("2012", new BigDecimal(120001));
            put("2018", new BigDecimal(140001));
        }};
        staff1.setSalary(salary);
        staff1.setSkills(Arrays.asList("java1", "python1", "node1", "kotlin1"));


        staff2.setName("Oleg2");
        staff2.setAge(35);
        staff2.setPosition(new String[]{"Founder2", "CEO2", "coder2"});
        Map<String, BigDecimal> salary2 = new HashMap() {{
            put("2010", new BigDecimal(100002));
            put("2012", new BigDecimal(120002));
            put("2018", new BigDecimal(140002));
        }};
        staff2.setSalary(salary);
        staff2.setSkills(Arrays.asList("java2", "python2", "node2", "kotlin2"));

        arr.add(staff);
        arr.add(staff1);
        arr.add(staff2);

        return arr;

    }

}
