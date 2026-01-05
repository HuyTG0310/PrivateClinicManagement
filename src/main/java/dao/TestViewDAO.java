/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.TestDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBContext;

/**
 *
 * @author huytr
 */
public class TestViewDAO extends DBContext {

    public List<TestDTO> GetAllByExamId(int examId) {
        List<TestDTO> list = new ArrayList<>();

        String sql = "SELECT \n"
                + "    tr.test_request_id,\n"
                + "    tt.test_type_name,\n"
                + "    tr.request_date,\n"
                + "    CASE \n"
                + "        WHEN r.test_result_id IS NULL THEN 'WAITING'\n"
                + "        ELSE 'DONE'\n"
                + "    END AS status,\n"
                + "    r.result_value\n"
                + "FROM TestRequest tr\n"
                + "JOIN TestType tt\n"
                + "    ON tr.test_type_id = tt.test_type_id\n"
                + "LEFT JOIN TestResult r\n"
                + "    ON tr.test_request_id = r.test_request_id\n"
                + "WHERE tr.exam_id = ?\n"
                + "ORDER BY tr.request_date;";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, examId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TestDTO dto = new TestDTO();
                dto.setTestRequestId(rs.getInt("test_request_id"));
                dto.setTestTypeName(rs.getString("test_type_name"));
                dto.setRequestDate(rs.getTimestamp("request_date"));
                dto.setStatus(rs.getString("status"));
                dto.setResultValue(rs.getString("result_value")); // có thể null
                list.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    public static void main(String[] args) {
        
        TestViewDAO dao = new TestViewDAO();
        
        for (TestDTO t : dao.GetAllByExamId(20)) {
            System.out.println(t.toString());
        }
    }
}
