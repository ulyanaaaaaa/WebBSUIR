package com.company.dao;

import com.company.model.Subject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDao {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int st; // status

    public int insert(Subject subject) {
        con = ConnectionFactory.getConnection();
        try {
            String query = "insert into subject(name, description, credits, teacher, start_date, end_date) "
                    + "values(?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, subject.getName());
            ps.setString(2, subject.getDescription());
            ps.setInt(3, subject.getCredits());
            ps.setString(4, subject.getTeacher());
            ps.setDate(5, subject.getStartDate());
            ps.setDate(6, subject.getEndDate());
            st = ps.executeUpdate();
            System.out.println("inserted subject " + st);
        } catch (Exception e) {
            st = -2;
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return st;
    }


        public int update(Subject subject) {
        con = ConnectionFactory.getConnection();
        try {
            String query = "update subject set name=?, description=?, credits=?, teacher=?, start_date=?, end_date=? "
                    + "where id=?";
            ps = con.prepareStatement(query);
            ps.setString(1, subject.getName());
            ps.setString(2, subject.getDescription());
            ps.setInt(3, subject.getCredits());
            ps.setString(4, subject.getTeacher());
            ps.setDate(5, subject.getStartDate());
            ps.setDate(6, subject.getEndDate());
            ps.setLong(7, subject.getId());
            st = ps.executeUpdate();
            System.out.println("updated subject " + st);
        } catch (Exception e) {
            st = -2;
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return st;
    }

    public int delete(long id) {
        con = ConnectionFactory.getConnection();
        try {
            String query = "delete from subject where id=?";
            ps = con.prepareStatement(query);
            ps.setLong(1, id);
            st = ps.executeUpdate();
            System.out.println("deleted subject " + st);
        } catch (Exception e) {
            st = -2;
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return st;
    }

    public Subject fetchById(long id) {
        Subject subject = new Subject();
        con = ConnectionFactory.getConnection();
        try {
            String query = "select * from subject where id=?";
            ps = con.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                subject.setId(rs.getLong("id"));
                subject.setName(rs.getString("name"));
                subject.setDescription(rs.getString("description"));
                subject.setCredits(rs.getInt("credits"));
                subject.setTeacher(rs.getString("teacher"));
                subject.setStartDate(rs.getDate("start_date"));
                subject.setEndDate(rs.getDate("end_date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return subject;
    }

    public List<Subject> searchByName(String name) {
        List<Subject> subjectList = new ArrayList<Subject>();
        con = ConnectionFactory.getConnection();
        try {
            String query = "select * from subject where name like ?";
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Subject subject = new Subject();
                subject.setId(rs.getLong("id"));
                subject.setName(rs.getString("name"));
                subject.setDescription(rs.getString("description"));
                subject.setCredits(rs.getInt("credits"));
                subject.setTeacher(rs.getString("teacher"));
                subject.setStartDate(rs.getDate("start_date"));
                subject.setEndDate(rs.getDate("end_date"));
                subjectList.add(subject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return subjectList;
    }

    public List<Subject> fetchByTeacher(String teacher) {
        List<Subject> subjectList = new ArrayList<Subject>();
        con = ConnectionFactory.getConnection();
        try {
            String query = "select * from subject where teacher=?";
            ps = con.prepareStatement(query);
            ps.setString(1, teacher);
            rs = ps.executeQuery();
            while (rs.next()) {
                Subject subject = new Subject();
                subject.setId(rs.getLong("id"));
                subject.setName(rs.getString("name"));
                subject.setDescription(rs.getString("description"));
                subject.setCredits(rs.getInt("credits"));
                subject.setTeacher(rs.getString("teacher"));
                subject.setStartDate(rs.getDate("start_date"));
                subject.setEndDate(rs.getDate("end_date"));
                subjectList.add(subject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return subjectList;
    }

    public List<Subject> fetchByDateRange(Date startDate, Date endDate) {
        List<Subject> subjectList = new ArrayList<Subject>();
        con = ConnectionFactory.getConnection();
        try {
            String query = "select * from subject where startDate between ? and ?";
            ps = con.prepareStatement(query);
            ps.setDate(1, startDate);
            ps.setDate(2, endDate);
            rs = ps.executeQuery();
            while (rs.next()) {
                Subject subject = new Subject();
                subject.setId(rs.getLong("id"));
                subject.setName(rs.getString("name"));
                subject.setDescription(rs.getString("description"));
                subject.setCredits(rs.getInt("credits"));
                subject.setTeacher(rs.getString("teacher"));
                subject.setStartDate(rs.getDate("start_date"));
                subject.setEndDate(rs.getDate("end_date"));
                subjectList.add(subject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return subjectList;
    }

    public List<Subject> fetchAll() {
            List<Subject> subjectList = new ArrayList<Subject>();
            con = ConnectionFactory.getConnection();
            try {
                String query = "select * from subject";
                ps = con.prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Subject subject = new Subject();
                    subject.setId(rs.getLong("id"));
                    subject.setName(rs.getString("name"));
                    subject.setDescription(rs.getString("description"));
                    subject.setCredits(rs.getInt("credits"));
                    subject.setTeacher(rs.getString("teacher"));
                    subject.setStartDate(rs.getDate("start_date"));
                    subject.setEndDate(rs.getDate("end_date"));
                    subjectList.add(subject);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            return subjectList;

        }
}
