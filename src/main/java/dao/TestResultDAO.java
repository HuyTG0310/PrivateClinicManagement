/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.DBContext;

/**
 *
 * @author huytr
 */
public class TestResultDAO extends DBContext {

    public void Create(int testRequestId, String resultValue) {
        String sql = "INSERT INTO TestResult (test_request_id, result_value) VALUES (?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, testRequestId);
            ps.setString(2, resultValue);
            
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
