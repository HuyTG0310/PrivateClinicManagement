/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author huytr
 */
public class TestType {

    private int testTypeId;
    private String testTypeName;
    private double price;

    public TestType() {
    }

    public TestType(int testTypeId, String testTypeName, double price) {
        this.testTypeId = testTypeId;
        this.testTypeName = testTypeName;
        this.price = price;
    }

    public int getTestTypeId() {
        return testTypeId;
    }

    public void setTestTypeId(int testTypeId) {
        this.testTypeId = testTypeId;
    }

    public String getTestTypeName() {
        return testTypeName;
    }

    public void setTestTypeName(String testTypeName) {
        this.testTypeName = testTypeName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TestType{" + "testTypeId=" + testTypeId + ", testTypeName=" + testTypeName + ", price=" + price + '}';
    }

}
