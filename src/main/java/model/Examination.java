
package model;

import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


public class Examination implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer examId;
   
    private String diagnosis;
   
    private Date examDate;
    
    private Prescription prescription;
   
    private int appointmentId;
   
    private Collection<TestRequest> testRequestCollection;

    public Examination() {
    }

    public Examination(Integer examId) {
        this.examId = examId;
    }

    public Examination(Integer examId, Date examDate) {
        this.examId = examId;
        this.examDate = examDate;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }



    @XmlTransient
    public Collection<TestRequest> getTestRequestCollection() {
        return testRequestCollection;
    }

    public void setTestRequestCollection(Collection<TestRequest> testRequestCollection) {
        this.testRequestCollection = testRequestCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (examId != null ? examId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examination)) {
            return false;
        }
        Examination other = (Examination) object;
        if ((this.examId == null && other.examId != null) || (this.examId != null && !this.examId.equals(other.examId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Examination[ examId=" + examId + " ]";
    }
    
}
