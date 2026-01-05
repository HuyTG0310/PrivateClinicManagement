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
import model.TestRequest;
import util.DBContext;

/**
 *
 * @author huytr
 */
public class TestRequestDAO extends DBContext {

    public void Create(int examId, String testTypeId) {
        String sql = "INSERT INTO TestRequest (exam_id, test_type_id) VALUES (?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, examId);
            ps.setString(2, testTypeId);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<TestRequest> GetByExamId(int id) {
        List<TestRequest> list = new ArrayList<>();
        String sql = "SELECT * FROM TestRequest WHERE exam_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TestRequest tr = new TestRequest();
                tr.setTestRequestId(rs.getInt("test_request_id"));
                tr.setExamId(rs.getInt("exam_id"));
                tr.setTestTypeId(rs.getInt("type_type_id"));
                tr.setRequestDate(rs.getDate("request_date"));
                list.add(tr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    public static void main(String[] args) {
        
        TestRequestDAO dao = new TestRequestDAO();
        
//        for (Object object : dao.GetByExamId(id)) {
//            
//        }

    dao.Create(20, "2");
    }
}
