/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ClinicRoom;
import util.DBContext;

/**
 *
 * @author huytr
 */
public class ClinicRoomDAO extends DBContext {

    public List<ClinicRoom> GetAll() {
        String sql = "SELECT * FROM ClinicRoom";

        List<ClinicRoom> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ClinicRoom(rs.getInt(1), rs.getString(2)));
            }

            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        ClinicRoomDAO dao = new ClinicRoomDAO();
        for (ClinicRoom c : dao.GetAll()) {
            System.out.println(c.toString());
        }
    }
}
