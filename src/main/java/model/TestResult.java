package model;

import java.util.Date;

public class TestResult {

    private int testResultId;
    private int testRequestId;
    private String resultValue;
    private Date resultDate;

    public TestResult() {
    }

    public TestResult(int testResultId, int testRequestId, String resultValue, Date resultDate) {
        this.testResultId = testResultId;
        this.testRequestId = testRequestId;
        this.resultValue = resultValue;
        this.resultDate = resultDate;
    }

    public int getTestResultId() {
        return testResultId;
    }

    public void setTestResultId(int testResultId) {
        this.testResultId = testResultId;
    }

    public int getTestRequestId() {
        return testRequestId;
    }

    public void setTestRequestId(int testRequestId) {
        this.testRequestId = testRequestId;
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
}
