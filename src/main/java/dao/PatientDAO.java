/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import model.Patient;
import util.DBContext;

/**
 *
 * @author huytr
 */
public class PatientDAO extends DBContext {

    public int Create(Patient p) {
        String sql = "INSERT INTO Patient (name, gender, dob, phone, address) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, p.getName());
            ps.setString(2, p.getGender());
            ps.setDate(3, new java.sql.Date(p.getDob().getTime()));
            ps.setString(4, p.getPhone());
            ps.setString(5, p.getAddress());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public Patient SearchByPhone(String phone) {

        String sql = "SELECT * FROM Patient WHERE phone = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, phone);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Patient p = new Patient();

                p.setPatientId(rs.getInt("patient_id"));
                p.setName(rs.getString("name"));
                p.setGender(rs.getString("gender"));
                p.setDob(rs.getDate("dob"));
                p.setPhone(rs.getString("phone"));
                p.setAddress(rs.getString("address"));

                return p;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    
    public Patient GetById(int id) {

        String sql = "SELECT * FROM Patient WHERE patient_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Patient p = new Patient();

                p.setPatientId(rs.getInt("patient_id"));
                p.setName(rs.getString("name"));
                p.setGender(rs.getString("gender"));
                p.setDob(rs.getDate("dob"));
                p.setPhone(rs.getString("phone"));
                p.setAddress(rs.getString("address"));

                return p;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    } 

    public static void main(String[] args) {
        PatientDAO dao = new PatientDAO();
//        Patient p = new Patient();
//
//        p.setName("Peter");
//        p.setGender("male");
//        p.setDob(new Date(2000, 1, 1));
//        p.setPhone("0989888999");
//        p.setAddress("");
//
//        int id = dao.Create(p);
//        System.out.println(id);

        System.out.println(dao.GetById(1).toString());

    }

}
