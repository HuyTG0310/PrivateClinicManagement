/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.ExamDetailDTO;
import dto.ExamHistoryDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Examination;
import util.DBContext;

/**
 *
 * @author huytr
 */
public class ExaminationDAO extends DBContext {

    public int Create(String appointId, int doctorId, String diangosis) {
        String sql = "INSERT INTO [dbo].[Examination] ([appointment_id], [doctor_id], [diagnosis])\n"
                + "VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(
                    sql, PreparedStatement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, appointId);
            ps.setInt(2, doctorId);
            ps.setString(3, diangosis);

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

    public int GetExamIdByAppointmentId(String id) {
        String sql = "SELECT * FROM Examination WHERE appointment_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(
                    sql, PreparedStatement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public Examination GetByAppointmentId(String appointmentId) {
        String sql = "SELECT * FROM Examination WHERE appointment_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, appointmentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Examination e = new Examination();
                e.setExamId(rs.getInt("exam_id"));
                e.setDiagnosis(rs.getString("diagnosis"));
                return e;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void UpdateDiagnosis(int examId, String diagnosis) {
        String sql = "UPDATE Examination SET diagnosis = ? WHERE exam_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, diagnosis);
            ps.setInt(2, examId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    List<ExamHistoryDTO> getExamHistoryByDoctor(int doctorId) {
        List<ExamHistoryDTO> list = new ArrayList<>();

        String sql = "SELECT\n"
                + "    e.exam_id,\n"
                + "    a.checkin_time,\n"
                + "    a.queue_number,\n"
                + "    p.name AS patient_name,\n"
                + "    p.phone,\n"
                + "    e.diagnosis\n"
                + "FROM Examination e\n"
                + "JOIN Appointment a ON e.appointment_id = a.appointment_id\n"
                + "JOIN Patient p ON a.patient_id = p.patient_id\n"
                + "WHERE e.doctor_id = ?\n"
                + "ORDER BY a.checkin_time DESC;";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, doctorId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ExamHistoryDTO dto = new ExamHistoryDTO();

                dto.setExamId(rs.getInt("exam_id"));
                dto.setAppointmentId(rs.getInt("appointment_id"));
                dto.setCheckinTime(rs.getDate("checkin_time"));
                dto.setQueueNumber(rs.getInt("queue_number"));
                dto.setPatientName(rs.getString("patient_name"));
                dto.setPatientPhone(rs.getString("phone"));
                dto.setDiagnosis(rs.getString("diagnosis"));

                list.add(dto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ExamDetailDTO getExamDetail(int examId) {

        String sql = "SELECT\n"
                + "			e.exam_id,\n"
                + "            e.diagnosis,\n"
                + "            a.checkin_time,\n"
                + "            a.queue_number,\n"
                + "            p.name AS patient_name,\n"
                + "            p.gender,\n"
                + "            p.dob,\n"
                + "            p.phone,\n"
                + "            d.name AS doctor_name FROM Examination e\n"
                + "        JOIN Appointment a ON e.appointment_id = a.appointment_id\n"
                + "        JOIN Patient p ON a.patient_id = p.patient_id\n"
                + "        JOIN Doctor d ON e.doctor_id = d.doctor_id\n"
                + "        WHERE e\n"
                + "        .exam_id = ? AND  a.status = 'DONE'";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, examId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ExamDetailDTO dto = new ExamDetailDTO();
                dto.setExamId(rs.getInt("exam_id"));
                dto.setDiagnosis(rs.getString("diagnosis"));
                dto.setCheckinTime(rs.getTimestamp("checkin_time"));
                dto.setQueueNumber(rs.getInt("queue_number"));
                dto.setPatientName(rs.getString("patient_name"));
                dto.setGender(rs.getString("gender"));
                dto.setDob(rs.getDate("dob"));
                dto.setPhone(rs.getString("phone"));
                dto.setDoctorName(rs.getString("doctor_name"));
                return dto;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {

        ExaminationDAO dao = new ExaminationDAO();

//        dao.Create("16", 1, "cảm ho");
        dao.UpdateDiagnosis(17, "ho");
    }
}
