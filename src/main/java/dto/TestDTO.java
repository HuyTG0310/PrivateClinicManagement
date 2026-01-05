/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Date;

/**
 *
 * @author huytr
 */
public class TestDTO {

    private int testRequestId;
    private String testTypeName;
    private Date requestDate;
    private String status;      // WAITING / DONE
    private String resultValue; // null nếu chưa có

    public int getTestRequestId() {
        return testRequestId;
    }

    public void setTestRequestId(int testRequestId) {
        this.testRequestId = testRequestId;
    }

    public String getTestTypeName() {
        return testTypeName;
    }

    public void setTestTypeName(String testTypeName) {
        this.testTypeName = testTypeName;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResultValue() {
        return resultValue;
    }

    public void setResultValue(String resultValue) {
        this.resultValue = resultValue;
    }

    @Override
    public String toString() {
        return "TestDTO{" + "testRequestId=" + testRequestId + ", testTypeName=" + testTypeName + ", requestDate=" + requestDate + ", status=" + status + ", resultValue=" + resultValue + '}';
    }

    
}
