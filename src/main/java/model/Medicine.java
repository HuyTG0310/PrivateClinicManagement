
package model;

import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;


public class Medicine implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer medicineId;
    
    private String name;
    
    private BigDecimal unitPrice;
    
    private int stockQuantity;
    
    private Collection<PrescriptionDetail> prescriptionDetailCollection;

    public Medicine() {
    }

    public Medicine(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public Medicine(Integer medicineId, String name, BigDecimal unitPrice, int stockQuantity) {
        this.medicineId = medicineId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.stockQuantity = stockQuantity;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
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
        return "model.Medicine[ medicineId=" + medicineId + " ]";
    }
    
}
