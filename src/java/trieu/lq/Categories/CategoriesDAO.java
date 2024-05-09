/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieu.lq.Categories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import trieulq.utils.DBUtils;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
public class CategoriesDAO {
      private final String SEARCHCategories = "SELECT  [ID],[name] ,[describe] FROM [WorkShop1].[dbo].[Categories] where id= 1SELECT  [ID],[name] ,[describe] FROM [WorkShop1].[dbo].[Categories] where id= ? ";
      private final String SHOWCategories = "SELECT * FROM [WorkShop1].[dbo].[Categories] ";
     public CategoriesDTO getCategoryByCid(int ID) throws SQLException{
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<CategoriesDTO> categoriesList = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement(SEARCHCategories);
                pst.setInt(1,ID );
            
                rs = pst.executeQuery();
                if (rs.next()) {
                    CategoriesDTO c = new CategoriesDTO(rs.getInt("id"), rs.getString("name"), rs.getString("describe"));
                    
                  
                    return c;   
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
     public List<CategoriesDTO> getAllCategories() throws SQLException{
      List<CategoriesDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!= null){
                pst = conn.prepareStatement(SHOWCategories);
                rs = pst.executeQuery();
                while (rs.next()){
                    list.add(new CategoriesDTO(rs.getInt("id"), rs.getString("name"), rs.getString("describe")));
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
        return list;
          
         
         
     }

}
