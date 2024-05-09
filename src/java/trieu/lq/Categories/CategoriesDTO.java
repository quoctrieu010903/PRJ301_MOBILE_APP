/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieu.lq.Categories;

import java.io.Serializable;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
public class CategoriesDTO implements Serializable{
    private int cid;
    private String cname;
    private String describe;

    public CategoriesDTO() {
    }

    public CategoriesDTO(int cid, String cname, String describe) {
        this.cid = cid;
        this.cname = cname;
        this.describe = describe;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

   

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "CategoriesDTO{" + "cid=" + cid + ", cname=" + cname + ", describe=" + describe + '}';
    }
    
    
}
