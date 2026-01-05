/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.PrescriptionDetailDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBContext;

/**
 *
 * @author huytr
 */
public class PrescriptionDetailDAO extends DBContext {

    public void AddDetail(int prescriptionId, int medicineId, int quantity, String dosage) {
        String sql = "INSERT INTO [dbo].[PrescriptionDetail]\n"
                + "           ([prescription_id]\n"
                + "           ,[medicine_id]\n"
                + "           ,[quantity]\n"
                + "           ,[dosage])\n"
                + "     VALUES\n"
                + "           (?, ?, ?, ?)";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, prescriptionId);
            ps.setInt(2, medicineId);
            ps.setInt(3, quantity);
            ps.setString(4, dosage);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PrescriptionDetailDTO> GetDetailByPrescriptionId(int prescriptionId) {
        List<PrescriptionDetailDTO> list = new ArrayList<>();

        String sql = "SELECT\n"
                + "    m.name AS medicine_name,\n"
                + "    m.unit,\n"
                + "    d.quantity,\n"
                + "    d.dosage\n"
                + "FROM PrescriptionDetail d\n"
                + "JOIN Medicine m\n"
                + "    ON d.medicine_id = m.medicine_id\n"
                + "WHERE d.prescription_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, prescriptionId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PrescriptionDetailDTO dto = new PrescriptionDetailDTO();
                dto.setMedicineName(rs.getString("medicine_name"));
                dto.setUnit(rs.getString("unit"));
                dto.setQuantity(rs.getInt("quantity"));
                dto.setDosage(rs.getString("dosage"));
                list.add(dto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        PrescriptionDetailDAO dao = new PrescriptionDetailDAO();

        for (PrescriptionDetailDTO p : dao.GetDetailByPrescriptionId(9)) {
            System.out.println(p.toString());
        }
    }
}
