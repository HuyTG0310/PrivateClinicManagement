package model;

import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

public class Medicine implements Serializable {

    private static final long serialVersionUID = 1L;

    private int medicineId;

    private String name;

    private String unit;

    private double unitPrice;

    private int stockQuantity;

    private Collection<PrescriptionDetail> prescriptionDetailCollection;

    public Medicine() {
    }

    public Medicine(int medicineId) {
        this.medicineId = medicineId;
    }

    public Medicine(int medicineId, String name, double unitPrice, int stockQuantity) {
        this.medicineId = medicineId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.stockQuantity = stockQuantity;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
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
        return "Medicine{" + "medicineId=" + medicineId + ", name=" + name + ", unit=" + unit + ", unitPrice=" + unitPrice + ", stockQuantity=" + stockQuantity + ", prescriptionDetailCollection=" + prescriptionDetailCollection + '}';
    }

}
