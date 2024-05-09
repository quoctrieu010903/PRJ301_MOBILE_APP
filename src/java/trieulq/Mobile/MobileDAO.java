/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieulq.Mobile;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import trieulq.utils.DBUtils;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
public class MobileDAO implements Serializable {

    private final String SEARCHNAME = "SELECT [mobileId],[description],[price] ,[mobileName],[yearOfProduction],[quantity],[notSale] FROM [Workshop2].[dbo].[tbl_Mobile] where mobileName like ? ";
    private final String SEARCHID = "SELECT [mobileId],[description],[price] ,[mobileName],[yearOfProduction],[quantity],[notSale] FROM [Workshop2].[dbo].[tbl_Mobile] where mobileId= ? ";
    private final String SHOWALL = "SELECT  [mobileId],[description],[price],[mobileName],[yearOfProduction],[quantity] ,[notSale] FROM [Workshop2].[dbo].[tbl_Mobile]";
    private final String UPDATEMOBILE = "UPDATE [dbo].[products] SET,[quantity] = ? ,[price] = ?,[describe] = ?,[notsale] = ? WHERE name = ? ";

    public List<MobileDTO> getAllMobileByName(String name) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<MobileDTO> mobileList = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement(SEARCHNAME);

                pst.setString(1, "%" + name + "%");

                rs = pst.executeQuery();
                while (rs.next()) {
                    MobileDTO p = new MobileDTO();
                    p.setName(rs.getString("mobileName"));
                    p.setId(rs.getString("mobileId"));
                    p.setQuantity(rs.getInt("quantity"));
                    p.setPrice(rs.getDouble("price"));
                    p.setReleaseDate(rs.getInt("yearOfProduction"));
                    p.setDescribe(rs.getString("description"));

                    p.setNotSale(rs.getBoolean("notsale"));

                    mobileList.add(p);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
        return mobileList;

    }

    // insert
    public boolean InsertMobile(MobileDTO m) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean isAdded = false;

        List<MobileDTO> mobileList = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO [dbo].[tbl_Mobile]\n"
                        + "			([mobileId]\n"
                        + "           ,[description]\n"
                        + "           ,[price]\n"
                        + "           ,[mobileName]\n"
                        + "           ,[yearOfProduction]\n"
                        + "           ,[quantity]\n"
                        + "           ,[notSale])\n"
                        + "     VALUES (?,?,?,?,?,?,?) ";
                pst = conn.prepareStatement(sql);
                pst.setString(1, m.getId());
                pst.setString(2, m.getDescribe());
                pst.setDouble(3, m.getPrice());
                pst.setString(4, m.getName());
                pst.setInt(5, m.getReleaseDate());
                pst.setInt(6, m.getQuantity());
                pst.setBoolean(7, m.isNotSale());

                int affectedRows = pst.executeUpdate();
                if (affectedRows > 0) {
                    isAdded = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
        return isAdded;
    }

//tìm một cái mobile có cái id
    public MobileDTO getAllMobileByID(String ID) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement(SEARCHID);

                pst.setString(1, ID);

                rs = pst.executeQuery();
                if (rs.next()) {
                    MobileDTO p = new MobileDTO();
                    p.setName(rs.getString("mobileName"));
                    p.setId(rs.getString("mobileId"));
                    p.setQuantity(rs.getInt("quantity"));
                    p.setPrice(rs.getDouble("price"));
                    p.setReleaseDate(rs.getInt("yearOfProduction"));
                    p.setDescribe(rs.getString("description"));

                    p.setNotSale(rs.getBoolean("notsale"));

                    return p;

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
        return null;

    }

    public boolean deleteMobile(String name) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean result = false;
        String sql = "DELETE FROM [dbo].[tbl_Mobile]\n"
                + "      WHERE mobileName = ? ";
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement(sql);
                pst.setString(1, name);

                int effectRow = pst.executeUpdate();
                if (effectRow > 0) {
                    result = true;
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
        return result;
    }

    public boolean UpdateMobile(String description, double price, int quantity, boolean notSale, String mobileId) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean result = false;
        String sql = "UPDATE tbl_Mobile SET description = ?, price = ?, quantity = ?, notSale = ? WHERE mobileId = ? ";
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement(sql);
                pst.setString(1, description);
                pst.setDouble(2, price);
                pst.setInt(3, quantity);
                pst.setBoolean(4, notSale);
                pst.setString(5, mobileId);

                int effectRow = pst.executeUpdate();
                if (effectRow > 0) {
                    result = true;
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
        return result;
    }

    public List<MobileDTO> getAllMobile() throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<MobileDTO> mobileList = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement(SHOWALL);

                rs = pst.executeQuery();
                while (rs.next()) {
                    MobileDTO p = new MobileDTO();
                    p.setName(rs.getString("mobileName"));
                    p.setId(rs.getString("mobileId"));
                    p.setQuantity(rs.getInt("quantity"));
                    p.setPrice(rs.getDouble("price"));
                    p.setReleaseDate(rs.getInt("yearOfProduction"));
                    p.setDescribe(rs.getString("description"));
                    p.setNotSale(rs.getBoolean("notsale"));

                    mobileList.add(p);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
        return mobileList;

    }

    public List<MobileDTO> getMobileByRangePrice(double minPrice, double maxPrice) throws SQLException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<MobileDTO> mobileList = new ArrayList<>();
        try {
            String sql = "SELECT [mobileId],[description],[price],[mobileName],[yearOfProduction],[quantity],[notSale]\n"
                    + "  FROM [Workshop2].[dbo].[tbl_Mobile]\n"
                    + "  where price between ? and ? ";
            conn = DBUtils.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement(sql);

                pst.setDouble(1, minPrice);
                pst.setDouble(2, maxPrice);

                rs = pst.executeQuery();
                while (rs.next()) {
                    MobileDTO p = new MobileDTO();
                    p.setName(rs.getString("mobileName"));
                    p.setId(rs.getString("mobileId"));
                    p.setQuantity(rs.getInt("quantity"));
                    p.setPrice(rs.getDouble("price"));
                    p.setReleaseDate(rs.getInt("yearOfProduction"));
                    p.setDescribe(rs.getString("description"));
                    p.setNotSale(rs.getBoolean("notsale"));

                    mobileList.add(p);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
        return mobileList;
    }

    public int getAvailableQuantity(String productId) throws SQLException {
    int availableQuantity = 0;
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "SELECT quantity FROM tbl_Mobile WHERE mobileId = ? ";

    try {
        conn = DBUtils.getConnection();
        ps = conn.prepareStatement(sql);
        ps.setString(1, productId);
        rs = ps.executeQuery();
        if (rs.next()) {
            availableQuantity = rs.getInt("quantity");
        }
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(MobileDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (rs != null) rs.close();
        if (ps != null) ps.close();
        if (conn != null) conn.close();
    }

    return availableQuantity;
}
}
