/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Hong Ha
 */
@ManagedBean
@RequestScoped
public class CreditCardInfo implements Serializable{

    private Integer month;
    private Integer year;
    public CreditCardInfo() {
        this.month = 1;
        this.year = 2000;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
    
    public String next(){
        return "Next";
    } 
    
    public String tryAgain(){
        return "index";
    }
    
}
