/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.AppointmentDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBContext;

/**
 *
 * @author huytr
 */
public class AppointmentDAO extends DBContext {

    public int GetNextQueueNumber(int clinicRoomId) {
        String sql = "  SELECT ISNULL(MAX(queue_number), 0) + 1\n"
                + "            FROM Appointment\n"
                + "            WHERE clinic_room_id = ?\n"
                + "              AND CAST(checkin_time AS DATE) = CAST(GETDATE() AS DATE)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, clinicRoomId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public void CreateAppointment(int patientId, int clinicRoomId, int createdBy) {
        int queueNumber = GetNextQueueNumber(clinicRoomId);

        String sql = "INSERT INTO Appointment (\n"
                + "                queue_number,\n"
                + "                patient_id,\n"
                + "                clinic_room_id,\n"
                + "                created_by\n"
                + "            )\n"
                + "            VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, queueNumber);
            ps.setInt(2, patientId);
            ps.setInt(3, clinicRoomId);
            ps.setInt(4, createdBy);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<AppointmentDTO> GetTodayAppointments() {
        List<AppointmentDTO> list = new ArrayList<>();

        String sql = "SELECT a.appointment_id, a.queue_number, a.checkin_time,\n"
                + "p.name AS patient_name, p.phone AS patient_phone,\n"
                + "c.clinic_room_name AS clinic_room_name\n"
                + "FROM Appointment a JOIN Patient p ON a.patient_id = p.patient_id\n"
                + "JOIN ClinicRoom c ON a.clinic_room_id = c.clinic_room_id\n"
                + "WHERE CAST(a.checkin_time AS DATE) = CAST(GETDATE() AS DATE)\n"
                + "ORDER BY a.appointment_id DESC";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                AppointmentDTO av = new AppointmentDTO();
                av.setAppointmentId(rs.getInt("appointment_id"));
                av.setQueueNumber(rs.getInt("queue_number"));
                av.setCheckinTime(rs.getTimestamp("checkin_time"));
                av.setPatientName(rs.getString("patient_name"));
                av.setPatientPhone(rs.getString("patient_phone"));
                av.setClinicRoomName(rs.getString("clinic_room_name"));
                list.add(av);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<AppointmentDTO> GetWaitingAppointmentsForDoctor(int doctorId) {
        List<AppointmentDTO> list = new ArrayList<>();

        String sql = "SELECT a.appointment_id, a.queue_number, a.checkin_time, \n"
                + "p.name  AS patient_name, p.phone AS patient_phone\n"
                + "FROM Appointment a JOIN Patient p ON a.patient_id = p.patient_id\n"
                + "JOIN ClinicRoom c ON a.clinic_room_id = c.clinic_room_id\n"
                + "JOIN Doctor d ON d.specialty = c.clinic_room_name\n"
                + "WHERE d.doctor_id = ? AND a.status = 'WAITING' AND CAST(a.checkin_time AS DATE) = CAST(GETDATE() AS DATE)\n"
                + "ORDER BY a.queue_number";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, doctorId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AppointmentDTO av = new AppointmentDTO();
                av.setAppointmentId(rs.getInt("appointment_id"));
                av.setQueueNumber(rs.getInt("queue_number"));
                av.setCheckinTime(rs.getTimestamp("checkin_time"));
                av.setPatientName(rs.getString("patient_name"));
                av.setPatientPhone(rs.getString("patient_phone"));
                list.add(av);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<AppointmentDTO> GetInProgressAppointmentsForDoctor(int doctorId) {
        List<AppointmentDTO> list = new ArrayList<>();

        String sql = "SELECT a.appointment_id, a.queue_number, a.checkin_time, \n"
                + "p.name  AS patient_name, p.phone AS patient_phone\n"
                + "FROM Appointment a JOIN Patient p ON a.patient_id = p.patient_id\n"
                + "JOIN ClinicRoom c ON a.clinic_room_id = c.clinic_room_id\n"
                + "JOIN Doctor d ON d.specialty = c.clinic_room_name\n"
                + "WHERE d.doctor_id = ? AND a.status = 'IN_PROGRESS' AND CAST(a.checkin_time AS DATE) = CAST(GETDATE() AS DATE)\n"
                + "ORDER BY a.queue_number";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, doctorId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AppointmentDTO av = new AppointmentDTO();
                av.setAppointmentId(rs.getInt("appointment_id"));
                av.setQueueNumber(rs.getInt("queue_number"));
                av.setCheckinTime(rs.getTimestamp("checkin_time"));
                av.setPatientName(rs.getString("patient_name"));
                av.setPatientPhone(rs.getString("patient_phone"));
                list.add(av);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public int GetQueueNumberByAppointmentId(String id) {
        String sql = "SELECT queue_number FROM Appointment WHERE appointment_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void UpdateStatus(String status, String appointmentId) {
        String sql = "UPDATE Appointment SET Status = ? WHERE appointment_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            ps.setString(2, appointmentId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int GetClinicRoomIdByAppointmentId(String id) {
        String sql = "SELECT clinic_room_id FROM Appointment WHERE appointment_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void main(String[] args) {
        AppointmentDAO dao = new AppointmentDAO();
//        dao.CreateAppointment(1, 2, 3);

//        for (AppointmentDTO a : dao.GetWaitingAppointmentsForDoctor(1)) {
//            System.out.println(a.toString());
//        }
        System.out.println(dao.GetClinicRoomIdByAppointmentId("15"));
//        dao.UpdateStatus("DONE", "1");

    }

}
