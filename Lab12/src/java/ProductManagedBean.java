/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Hong Ha
 */
@ManagedBean
@SessionScoped
public class ProductManagedBean {

    /**
     * Creates a new instance of ProductManagedBean
     */
    List<Product> listProducts = new ArrayList<>();
    public ProductManagedBean() {
        this.listProducts.add(new Product("A32581", "The winner takes it all", 12.95));
        this.listProducts.add(new Product("A33278", "Yellow submarine", 11.35));
    }
    
    public List<Product> getListProducts() {
        return listProducts;
    }

    public void setListProducts(List<Product> listProducts) {
        this.listProducts = listProducts;
    }
}
