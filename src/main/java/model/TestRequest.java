
package model;

import java.io.Serializable;
import java.util.Date;


public class TestRequest implements Serializable {

    private static final long serialVersionUID = 1L;
   
    private Integer testRequestId;
    
    private String testType;
    
    private Date requestDate;
    
    private TestResult testResult;
   
    private int examId;

    public TestRequest() {
    }

    public TestRequest(Integer testRequestId) {
        this.testRequestId = testRequestId;
    }

    public TestRequest(Integer testRequestId, String testType, Date requestDate) {
        this.testRequestId = testRequestId;
        this.testType = testType;
        this.requestDate = requestDate;
    }

    public Integer getTestRequestId() {
        return testRequestId;
    }

    public void setTestRequestId(Integer testRequestId) {
        this.testRequestId = testRequestId;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public TestResult getTestResult() {
        return testResult;
    }

    public void setTestResult(TestResult testResult) {
        this.testResult = testResult;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }


    @Override
    public String toString() {
        return "model.TestRequest[ testRequestId=" + testRequestId + " ]";
    }

}
