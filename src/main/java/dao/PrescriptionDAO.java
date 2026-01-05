/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.DBContext;

/**
 *
 * @author huytr
 */
public class PrescriptionDAO extends DBContext {

    public int FindByExamId(int examId) {
        String sql = "SELECT prescription_id FROM Prescription WHERE exam_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, examId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("prescription_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;

    }

    public int Create(int examId) {
        String sql = "INSERT INTO [dbo].[Prescription] (exam_id) VALUES (?)";

        try {
            PreparedStatement ps = conn.prepareStatement(
                    sql, PreparedStatement.RETURN_GENERATED_KEYS
            );
            ps.setInt(1, examId);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
