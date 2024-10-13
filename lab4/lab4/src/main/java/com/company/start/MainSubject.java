package com.company.start;

import com.company.action.SubjectAction;
import com.company.model.Subject;

import java.sql.Date;
import java.util.Scanner;

public class MainSubject {
        SubjectAction action = new SubjectAction();

        public static void main(String[] args) {
        String DbOperation = "EXIT(0), ADD(1), UPDATE(2), DELETE(3), FETCHBYID(4), SEARCHBYNAME(5), FETCHBYTEACHER(6), FETCHBYDATERANGE(7), FETCHALL(8)";
        MainSubject mainclass = new MainSubject();
        int value = 0;
        do {
            System.out.println("valid operations are");
            System.out.println(DbOperation);
            System.out.println("Enter valid operation number 0-8");
            Scanner scanner = new Scanner(System.in);
            value = scanner.nextInt();
            switch (value) {
                case 1:
                    mainclass.addSubject();
                    break;
                case 2:
                    mainclass.updateSubject();
                    mainclass.fetchAllSubjects();
                    break;
                case 3:
                    mainclass.deleteSubject();
                    break;
                case 4:
                    mainclass.fetchSubjectById();
                    break;
                case 5:
                    mainclass.searchSubjectByName();
                    break;
                case 6:
                    mainclass.fetchSubjectByTeacher();
                    break;
                case 7:
                    mainclass.fetchSubjectByDateRange();
                    break;
                case 8:
                    mainclass.fetchAllSubjects();
                    break;
                case 0:
                    System.out.println("Exiting code");
                    break;
                default:
                    System.out.println("Not a valid entry");
            }
        } while (value != 0);
    }

        public void addSubject() {
        Subject subject = new Subject();
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Name");
        subject.setName(insert.next());
        System.out.println("Enter Description");
        subject.setDescription(insert.next());
        System.out.println("Enter Credits");
        subject.setCredits(insert.nextInt());
        System.out.println("Enter Teacher");
        subject.setTeacher(insert.next());
        System.out.println("Enter Start Date (yyyy-mm-dd)");
        subject.setStartDate(Date.valueOf(insert.next()));
        System.out.println("Enter End Date (yyyy-mm-dd)");
        subject.setEndDate(Date.valueOf(insert.next()));
        action.insert(subject);
    }

        public void updateSubject() {
        Subject subject = new Subject();
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Subject Id");
        subject.setId(insert.nextLong());
        System.out.println("Enter Name");
        subject.setName(insert.next());
        System.out.println("Enter Description");
        subject.setDescription(insert.next());
        System.out.println("Enter Credits");
        subject.setCredits(insert.nextInt());
        System.out.println("Enter Teacher");
        subject.setTeacher(insert.next());
        System.out.println("Enter Start Date (yyyy-mm-dd)");
        subject.setStartDate(Date.valueOf(insert.next()));
        System.out.println("Enter End Date (yyyy-mm-dd)");
        subject.setEndDate(Date.valueOf(insert.next()));
        action.update(subject);
    }

        public void deleteSubject() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Subject Id");
        long id = insert.nextLong();
        action.delete(id);
    }

        public void fetchSubjectById() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Subject Id");
        long id = insert.nextLong();
        action.fetchById(id);
    }

        public void searchSubjectByName() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Subject Name");
        String name = insert.next();
        action.searchByName(name);
    }

        public void fetchSubjectByTeacher() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Teacher Name");
        String teacher = insert.next();
        action.fetchByTeacher(teacher);
    }

        public void fetchSubjectByDateRange() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Start Date (yyyy-mm-dd)");
        String startDate = insert.next();
        System.out.println("Enter End Date (yyyy-mm-dd)");
        String endDate = insert.next();
        action.fetchByDateRange(Date.valueOf(startDate), Date.valueOf(endDate));
    }

        public void fetchAllSubjects() {
        action.fetchAll();
    }
}

