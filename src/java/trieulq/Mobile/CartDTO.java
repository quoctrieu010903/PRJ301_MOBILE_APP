/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieulq.Mobile;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
public class CartDTO implements Serializable {

    private Map<String, MobileDTO> cart;

    public CartDTO() {
    }

    public CartDTO(Map<String, MobileDTO> cart) {
        this.cart = cart;
    }

    public Map<String, MobileDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, MobileDTO> cart) {
        this.cart = cart;
    }

    public boolean add(MobileDTO mobile) {
        boolean check = false;
        try {
            if (this.cart == null) {
                this.cart = new HashMap<>();
            }
            if (this.cart.containsKey(mobile.getId())) {
                int currentQuantity = this.cart.get(mobile.getId()).getQuantity();
                mobile.setQuantity(currentQuantity + mobile.getQuantity());
            }
            this.cart.put(mobile.getId(), mobile);
            check = true;
        } catch (Exception e) {
        }
        return check;
    }

    public boolean change(String id, MobileDTO mobile) {
        boolean check = false;
        try {
            if (this.cart != null) {
                if (this.cart.containsKey(id)) {
                    this.cart.replace(id, mobile);
                    check = true;
                }
            }
        } catch (Exception e) {
        }
        return check;
    }

    public boolean remove(String id) {
        boolean check = false;
        try {
            if (this.cart != null) {
                if (this.cart.containsKey(id)) {
                    this.cart.remove(id);
                    check = true;
                }
            }
        } catch (Exception e) {
        }
        return check;
    }
    public boolean change(String id, int newQuantity) {
    if (this.cart != null && this.cart.containsKey(id)) {
       MobileDTO p = this.cart.get(id);
        if (p != null && newQuantity > 0) {
            p.setQuantity(newQuantity);
            return true;
        }
    }
    return false;
}
}
