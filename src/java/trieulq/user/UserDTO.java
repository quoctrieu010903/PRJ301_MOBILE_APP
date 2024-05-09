/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieulq.user;

import java.io.Serializable;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
public class UserDTO implements Serializable{
    private String userID;
    private String FullName;
    private String RoleID;
    private String Password;

    public UserDTO() {
    }

    public UserDTO(String userID, String FullName, String RoleID, String Password) {
        this.userID = userID;
        this.FullName = FullName;
        this.RoleID = RoleID;
        this.Password = Password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getRoleID() {
        return RoleID;
    }

    public void setRoleID(String RoleID) {
        this.RoleID = RoleID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
    
}
