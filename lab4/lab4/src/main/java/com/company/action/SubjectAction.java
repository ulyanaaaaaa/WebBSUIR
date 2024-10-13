package com.company.action;

import com.company.dao.SubjectDao;
import com.company.model.Subject;

import java.sql.Date;
import java.util.List;

public class SubjectAction {
        SubjectDao dao = new SubjectDao();
        int st;

        public void insert(Subject subject) {
        st = dao.insert(subject);
        if (st == 1) {
            System.out.println("Subject Inserted Successfully");
        } else if (st == -1) {
            System.out.println("Subject Already exists");
        } else {
            System.out.println("Unable to Insert Subject");
        }
    }

        public void update(Subject subject) {
        st = dao.update(subject);
        if (st == 1) {
            System.out.println("Subject Updated Successfully");
        } else {
            System.out.println("Unable to update Subject");
        }
    }

        public void delete(Long id) {
        st = dao.delete(id);
        if (st == 1) {
            System.out.println("Subject Deleted Successfully");
        } else {
            System.out.println("No Record Found");
        }
    }

        public void fetchById(Long id) {
        Subject subject = dao.fetchById(id);
        if (subject.getId() == 0) {
            System.out.println("No Record Found");
        } else {
            System.out.println("Subject Details are :");
            System.out.println(subject);
        }
    }

        public void searchByName(String name) {
        List<Subject> subjectList = dao.searchByName(name);
        if (subjectList.isEmpty()) {
            System.out.println("No Record Found");
        } else {
            System.out.println("Subject Details are :");
            for (Subject subject : subjectList) {
                System.out.println(subject);
            }
        }
    }

        public void fetchByTeacher(String teacher) {
        List<Subject> subjectList = dao.fetchByTeacher(teacher);
        if (subjectList.isEmpty()) {
            System.out.println("No Record Found");
        } else {
            System.out.println("Subject Details are :");
            for (Subject subject : subjectList) {
                System.out.println(subject);
            }
        }
    }

        public void fetchByDateRange(Date startDate, Date endDate) {
        List<Subject> subjectList = dao.fetchByDateRange(startDate, endDate);
        if (subjectList.isEmpty()) {
            System.out.println("No Record Found");
        } else {
            System.out.println("Subject Details are :");
            for (Subject subject : subjectList) {
                System.out.println(subject);
            }
        }
    }

        public void fetchAll() {
        List<Subject> subjectList = dao.fetchAll();
        if (subjectList.isEmpty()) {
            System.out.println("No Record Found");
        } else {
            System.out.println("Subject Details are :");
            for (Subject subject : subjectList) {
                System.out.println(subject);
            }
        }

    }
}
