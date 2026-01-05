package model;


import java.util.Date;

public class TestRequest {

    private int testRequestId;
    private int examId;
    private int testTypeId;
    private Date requestDate;

    public TestRequest() {
    }

    public TestRequest(int testRequestId, int examId, int testTypeId, Date requestDate) {
        this.testRequestId = testRequestId;
        this.examId = examId;
        this.testTypeId = testTypeId;
        this.requestDate = requestDate;
    }

    public int getTestRequestId() {
        return testRequestId;
    }

    public void setTestRequestId(int testRequestId) {
        this.testRequestId = testRequestId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getTestTypeId() {
        return testTypeId;
    }

    public void setTestTypeId(int testTypeId) {
        this.testTypeId = testTypeId;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }
}
