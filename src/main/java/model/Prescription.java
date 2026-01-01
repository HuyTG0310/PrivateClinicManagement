
package model;

import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


public class Prescription implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer prescriptionId;
    
    private Date createdDate;
   
    private int examId;
    
    private Collection<PrescriptionDetail> prescriptionDetailCollection;

    public Prescription() {
    }

    public Prescription(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Prescription(Integer prescriptionId, Date createdDate) {
        this.prescriptionId = prescriptionId;
        this.createdDate = createdDate;
    }

    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    

    @XmlTransient
    public Collection<PrescriptionDetail> getPrescriptionDetailCollection() {
        return prescriptionDetailCollection;
    }

    public void setPrescriptionDetailCollection(Collection<PrescriptionDetail> prescriptionDetailCollection) {
        this.prescriptionDetailCollection = prescriptionDetailCollection;
    }


    @Override
    public String toString() {
        return "model.Prescription[ prescriptionId=" + prescriptionId + " ]";
    }
    
}
