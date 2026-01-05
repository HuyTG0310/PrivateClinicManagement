/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.TestType;
import util.DBContext;

/**
 *
 * @author huytr
 */
public class TestTypeDAO extends DBContext {

    public List<TestType> GetAllByClinicRoom(int clinicRoomId) {
        List<TestType> list = new ArrayList<>();

        String sql = "SELECT TestType.test_type_id, TestType.test_type_name, TestType.price\n"
                + "FROM ClinicRoom_TestType INNER JOIN TestType ON ClinicRoom_TestType.test_type_id = TestType.test_type_id \n"
                + "WHERE ClinicRoom_TestType.clinic_room_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, clinicRoomId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TestType t = new TestType();
                t.setTestTypeId(rs.getInt("test_type_id"));
                t.setTestTypeName(rs.getString("test_type_name"));
                t.setPrice(rs.getDouble("price"));
                list.add(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public String getTestTypeByTestId(String id) {
        String sql = "SELECT test_type_name FROM TestType WHERE test_type_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        TestTypeDAO dao = new TestTypeDAO();

        for (TestType t : dao.GetAllByClinicRoom(2)) {
            System.out.println(t.toString());
        }
    }
}
