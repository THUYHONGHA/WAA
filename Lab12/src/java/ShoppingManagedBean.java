/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Hong Ha
 */
@ManagedBean
@SessionScoped
public class ShoppingManagedBean {

    /**
     * Creates a new instance of ShoppingManagedBean
     */
    private List<CartItem> cartList;
    private Double totalPrice;
    private Integer totalQuantity;
    private Double sumTotalPrice;

    public ShoppingManagedBean() {
        cartList = new ArrayList<>();
    }

    public Double getSumTotalPrice() {
        this.sumTotalPrice = 0.0;
        this.sumTotalPrice = cartList.stream()
                .map((p) -> p.getProduct().getProductPrice()* p.getQuantity())
                .reduce(this.sumTotalPrice, (a, i) -> a + i);
        return this.sumTotalPrice;

    }

    public void setSumTotalPrice(Double sumTotalPrice) {
        this.sumTotalPrice = sumTotalPrice;
    }

    public Integer getTotalQuantity() {
        this.totalQuantity = 0;
        totalQuantity = cartList.stream()
                .map((i) -> i.getQuantity())
                .reduce(totalQuantity, Integer::sum);
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<CartItem> getCartList() {
        return cartList;
    }

    public void setCartList(List<CartItem> cartList) {
        this.cartList = cartList;
    }

    public String addToCart() {

        Map<String, String> params = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap();

        String productId = params.get("productId");
        String productName = params.get("productName");
        Double productPrice = Double.parseDouble(params.get("productPrice"));
        Product product = new Product(productId, productName, productPrice);

        for (CartItem c : cartList) {
            if (c.getProduct().getProductId().equals(product.getProductId())) {
                c.setQuantity(c.getQuantity() + 1);
                return "";
            }
        }

        CartItem item = new CartItem();
        item.setQuantity(1);
        item.setProduct(product);
        this.cartList.add(item);
        return "";
    }

    public String removeFromCart() {
        Map<String, String> params = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap();

        String productId = params.get("productId");
        this.cartList.remove(this.cartList.stream()
                .filter(p -> p.getProduct().getProductId().equals(productId))
                .collect(Collectors.toList()).get(0));
        return "";
    }

    public String showItem() {
        String str = "";
        for (CartItem c : cartList) {
            str += c.getProduct().getProductId();
        }
        return str;
    }
}
