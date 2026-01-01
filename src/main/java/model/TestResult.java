
package model;

import java.io.Serializable;
import java.util.Date;


public class TestResult implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer testResultId;
    
    private String resultValue;
    
    private Date resultDate;
    
    private int testRequestId;

    public TestResult() {
    }

    public TestResult(Integer testResultId) {
        this.testResultId = testResultId;
    }

    public Integer getTestResultId() {
        return testResultId;
    }

    public void setTestResultId(Integer testResultId) {
        this.testResultId = testResultId;
    }

    public String getResultValue() {
        return resultValue;
    }

    public void setResultValue(String resultValue) {
        this.resultValue = resultValue;
    }

    public Date getResultDate() {
        return resultDate;
    }

    public void setResultDate(Date resultDate) {
        this.resultDate = resultDate;
    }

    public int getTestRequestId() {
        return testRequestId;
    }

    public void setTestRequestId(int testRequestId) {
        this.testRequestId = testRequestId;
    }


    @Override
    public String toString() {
        return "model.TestResult[ testResultId=" + testResultId + " ]";
    }

}
