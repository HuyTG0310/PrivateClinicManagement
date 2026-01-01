
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
   
    private int invoiceId;
    
    private BigDecimal totalAmount;
   
    private Date createdDate;
   
    private int appointmentId;

    public Invoice() {
    }

    public Invoice(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Invoice(Integer invoiceId, BigDecimal totalAmount, Date createdDate) {
        this.invoiceId = invoiceId;
        this.totalAmount = totalAmount;
        this.createdDate = createdDate;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }


    @Override
    public String toString() {
        return "model.Invoice[ invoiceId=" + invoiceId + " ]";
    }
    
}
