/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieulq.user;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trieulq.utils.DBUtils;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
public class UserDAO implements Serializable {

    private static final String GetAccount = "SELECT [userId] ,[password],[fullName],[role] FROM [WorkShop2].[dbo].[tbl_Users] where userId = ? and password = ? ";


    public UserDTO checkLogin(String UserID, String Password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                psm = conn.prepareStatement(GetAccount);
                psm.setString(1, UserID);
                psm.setString(2, Password);
                rs = psm.executeQuery();
                if (rs.next()) {
                    String fullname = rs.getString("fullName");
                    String RoleID = rs.getString("role");
                    user = new UserDTO(UserID, fullname, RoleID, Password);
                }

            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (psm != null) {
                psm.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
        return user;
    }

  
}
