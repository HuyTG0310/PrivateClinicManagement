/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.LabTestDTO;
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

    public List<LabTestDTO> getWaitingTests() {

        List<LabTestDTO> list = new ArrayList<>();

        String sql = "SELECT\n"
                + "    tr.test_request_id,\n"
                + "    p.name AS patient_name,\n"
                + "	p.phone AS patient_phone,\n"
                + "    tt.test_type_name,\n"
                + "    tr.request_date\n"
                + "FROM TestRequest tr\n"
                + "JOIN Examination e ON tr.exam_id = e.exam_id\n"
                + "JOIN Appointment a ON e.appointment_id = a.appointment_id\n"
                + "JOIN Patient p ON a.patient_id = p.patient_id\n"
                + "JOIN TestType tt ON tr.test_type_id = tt.test_type_id\n"
                + "LEFT JOIN TestResult r\n"
                + "    ON tr.test_request_id = r.test_request_id\n"
                + "WHERE r.test_result_id IS NULL\n"
                + "ORDER BY tr.request_date;";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                LabTestDTO dto = new LabTestDTO();
                dto.setTestRequestId(rs.getInt("test_request_id"));
                dto.setPatientName(rs.getString("patient_name"));
                dto.setPatientPhone(rs.getString("patient_phone"));
                dto.setTestTypeName(rs.getString("test_type_name"));
                dto.setRequestDate(rs.getTimestamp("request_date"));
                list.add(dto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public LabTestDTO getByTestRequestId(int id) {

        List<LabTestDTO> list = new ArrayList<>();

        String sql = "SELECT\n"
                + "    tr.test_request_id,\n"
                + "    p.name AS patient_name,\n"
                + "	p.phone AS patient_phone,\n"
                + "    tt.test_type_name,\n"
                + "    tr.request_date\n"
                + "FROM TestRequest tr\n"
                + "JOIN Examination e ON tr.exam_id = e.exam_id\n"
                + "JOIN Appointment a ON e.appointment_id = a.appointment_id\n"
                + "JOIN Patient p ON a.patient_id = p.patient_id\n"
                + "JOIN TestType tt ON tr.test_type_id = tt.test_type_id\n"
                + "LEFT JOIN TestResult r\n"
                + "    ON tr.test_request_id = r.test_request_id\n"
                + "WHERE r.test_result_id IS NULL\n"
                + "AND tr.test_request_id = ? ORDER BY tr.request_date;";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                LabTestDTO dto = new LabTestDTO();
                dto.setTestRequestId(rs.getInt("test_request_id"));
                dto.setPatientName(rs.getString("patient_name"));
                dto.setPatientPhone(rs.getString("patient_phone"));
                dto.setTestTypeName(rs.getString("test_type_name"));
                dto.setRequestDate(rs.getTimestamp("request_date"));
                return dto;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {

        TestRequestDAO dao = new TestRequestDAO();

        for (LabTestDTO l : dao.getWaitingTests()) {
            System.out.println(l.toString());
        }
//        System.out.println(dao.getByTestRequestId(10));
    }
}
