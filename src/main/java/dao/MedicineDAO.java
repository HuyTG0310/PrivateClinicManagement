/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Medicine;
import util.DBContext;

/**
 *
 * @author huytr
 */
public class MedicineDAO extends DBContext {

    public List<Medicine> GetAll() {
        List<Medicine> list = new ArrayList<>();

        String sql = "SELECT * FROM Medicine";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Medicine m = new Medicine();
                m.setMedicineId(rs.getInt("medicine_id"));
                m.setName(rs.getString("name"));
                m.setUnit(rs.getString("unit"));
                m.setUnitPrice(rs.getDouble("unit_price"));
                m.setStockQuantity(rs.getInt("stock_quantity"));

                list.add(m);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Medicine GetByName(String name) {
        String sql = "SELECT * FROM Medicine WHERE name = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Medicine m = new Medicine();
                m.setMedicineId(rs.getInt("medicine_id"));
                m.setName(rs.getString("name"));
                m.setUnit(rs.getString("unit"));
                m.setUnitPrice(rs.getDouble("unit_price"));
                m.setStockQuantity(rs.getInt("stock_quantity"));

                return m;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        MedicineDAO dao = new MedicineDAO();

//        for (Medicine medicine : dao.GetAll()) {
//            System.out.println(medicine.toString());
//        }

        System.out.println(dao.GetByName("Siro ho trẻ em"));
    }
}
