/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.ExamHistoryDTO;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import util.DBContext;

/**
 *
 * @author huytr
 */
public class ExamHistoryDAO extends DBContext {

    public List<ExamHistoryDTO> getExamHistoryByDoctor(int doctorId) {
        List<ExamHistoryDTO> list = new ArrayList<>();

        String sql = "SELECT\n"
                + "    e.exam_id,\n"
                + "    a.appointment_id,\n"
                + "    a.checkin_time,\n"
                + "    a.queue_number,\n"
                + "    p.name AS patient_name,\n"
                + "    p.phone AS patient_phone,\n"
                + "    e.diagnosis\n"
                + "FROM Examination e\n"
                + "JOIN Appointment a\n"
                + "    ON e.appointment_id = a.appointment_id\n"
                + "JOIN Patient p\n"
                + "    ON a.patient_id = p.patient_id\n"
                + "WHERE e.doctor_id = ?\n"
                + "  AND a.status = 'DONE'\n"
                + "ORDER BY a.checkin_time DESC;";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, doctorId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ExamHistoryDTO dto = new ExamHistoryDTO();

                dto.setExamId(rs.getInt("exam_id"));
                dto.setCheckinTime(rs.getDate("checkin_time"));
                dto.setQueueNumber(rs.getInt("queue_number"));
                dto.setPatientName(rs.getString("patient_name"));
                dto.setPatientPhone(rs.getString("patient_phone"));
                dto.setDiagnosis(rs.getString("diagnosis"));

                list.add(dto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<ExamHistoryDTO> getExamHistoryByDoctor(
            int doctorId, Date from, Date to) {

        List<ExamHistoryDTO> list = new ArrayList<>();

        String sql = "SELECT\n"
                + "            e.exam_id,\n"
                + "            a.appointment_id,\n"
                + "            a.checkin_time,\n"
                + "            a.queue_number,\n"
                + "            p.name AS patient_name,\n"
                + "            p.phone AS patient_phone,\n"
                + "            e.diagnosis\n"
                + "        FROM Examination e\n"
                + "        JOIN Appointment a ON e.appointment_id = a.appointment_id\n"
                + "        JOIN Patient p ON a.patient_id = p.patient_id\n"
                + "        WHERE e.doctor_id = ?\n"
                + "          AND a.checkin_time BETWEEN ? AND ?\n"
                + "        ORDER BY a.checkin_time DESC";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, doctorId);
            ps.setTimestamp(2, new Timestamp(from.getTime()));
            ps.setTimestamp(3, new Timestamp(to.getTime()));

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ExamHistoryDTO dto = new ExamHistoryDTO();
                dto.setExamId(rs.getInt("exam_id"));
                dto.setAppointmentId(rs.getInt("appointment_id"));
                dto.setCheckinTime(rs.getDate("checkin_time"));
                dto.setQueueNumber(rs.getInt("queue_number"));
                dto.setPatientName(rs.getString("patient_name"));
                dto.setPatientPhone(rs.getString("patient_phone"));
                dto.setDiagnosis(rs.getString("diagnosis"));
                list.add(dto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void main(String[] args) {

        ExamHistoryDAO d = new ExamHistoryDAO();

        for (ExamHistoryDTO e : d.getExamHistoryByDoctor(1)) {
            System.out.println(e.toString());
        }
    }
}
