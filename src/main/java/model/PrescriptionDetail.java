
package model;

import java.io.Serializable;


public class PrescriptionDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer prescriptionDetailId;
   
    private String dosage;
   
    private int quantity;
    
    private int medicineId;
    
    private Prescription prescriptionId;

    public PrescriptionDetail() {
    }

    public PrescriptionDetail(Integer prescriptionDetailId) {
        this.prescriptionDetailId = prescriptionDetailId;
    }

    public PrescriptionDetail(Integer prescriptionDetailId, String dosage, int quantity) {
        this.prescriptionDetailId = prescriptionDetailId;
        this.dosage = dosage;
        this.quantity = quantity;
    }

    public Integer getPrescriptionDetailId() {
        return prescriptionDetailId;
    }

    public void setPrescriptionDetailId(Integer prescriptionDetailId) {
        this.prescriptionDetailId = prescriptionDetailId;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public Prescription getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Prescription prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    @Override
    public String toString() {
        return "model.PrescriptionDetail[ prescriptionDetailId=" + prescriptionDetailId + " ]";
    }

}
