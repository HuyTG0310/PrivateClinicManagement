/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author huytr
 */
public class AppointmentDTO {

    private int appointmentId;
    private int queueNumber;
    private Timestamp checkinTime;
    private String patientName;
    private String patientPhone;
    private String clinicRoomName;
    private String status;

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getQueueNumber() {
        return queueNumber;
    }

    public void setQueueNumber(int queueNumber) {
        this.queueNumber = queueNumber;
    }

    public Timestamp getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(Timestamp checkinTime) {
        this.checkinTime = checkinTime;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getClinicRoomName() {
        return clinicRoomName;
    }

    public void setClinicRoomName(String clinicRoomName) {
        this.clinicRoomName = clinicRoomName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AppointmentDTO{" + "appointmentId=" + appointmentId + ", queueNumber=" + queueNumber + ", checkinTime=" + checkinTime + ", patientName=" + patientName + ", patientPhone=" + patientPhone + ", clinicRoomName=" + clinicRoomName + '}';
    }

}
