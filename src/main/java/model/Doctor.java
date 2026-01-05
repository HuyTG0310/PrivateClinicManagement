
package model;

import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;


public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int doctorId;
    
    private String name;
   
    private String specialty;
    
    private String phone;
    
    private Collection<Appointment> appointmentCollection;

    public Doctor() {
    }

    public Doctor(int doctorId) {
        this.doctorId = doctorId;
    }

    public Doctor(int doctorId, String name) {
        this.doctorId = doctorId;
        this.name = name;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @XmlTransient
    public Collection<Appointment> getAppointmentCollection() {
        return appointmentCollection;
    }

    public void setAppointmentCollection(Collection<Appointment> appointmentCollection) {
        this.appointmentCollection = appointmentCollection;
    }


    @Override
    public String toString() {
        return "model.Doctor[ doctorId=" + doctorId + " ]";
    }
    
}
