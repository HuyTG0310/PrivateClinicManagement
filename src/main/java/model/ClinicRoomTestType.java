/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author huytr
 */
public class ClinicRoomTestType {

    private int clinicRoomId;
    private int testTypeId;

    public ClinicRoomTestType() {
    }

    public ClinicRoomTestType(int clinicRoomId, int testTypeId) {
        this.clinicRoomId = clinicRoomId;
        this.testTypeId = testTypeId;
    }

    public int getClinicRoomId() {
        return clinicRoomId;
    }

    public void setClinicRoomId(int clinicRoomId) {
        this.clinicRoomId = clinicRoomId;
    }

    public int getTestTypeId() {
        return testTypeId;
    }

    public void setTestTypeId(int testTypeId) {
        this.testTypeId = testTypeId;
    }

    @Override
    public String toString() {
        return "ClinicRoomTestType{" + "clinicRoomId=" + clinicRoomId + ", testTypeId=" + testTypeId + '}';
    }
    
    
}
