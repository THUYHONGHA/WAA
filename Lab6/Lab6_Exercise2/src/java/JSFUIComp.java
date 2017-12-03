/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Hong Ha
 */
@ManagedBean
@RequestScoped
public class JSFUIComp {
    
    private String from;
    private String to;
    private String departureDate;
    private String returnDate;
    private String trips;
    private String[] checkOptions; 
    public JSFUIComp() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getTrips() {
        return trips;
    }

    public void setTrips(String trips) {
        this.trips = trips;
    }

    public String[] getCheckOptions() {
        return checkOptions;
    }

    public void setCheckOptions(String[] checkOptions) {
        this.checkOptions = checkOptions;
    }

    private String optionResult="";

    public String getOptionResult() {
        for(int i=0; i< this.checkOptions.length; i++) {
            if(i == this.checkOptions.length-1) {
                optionResult += this.checkOptions[i];
            } else {
                optionResult += this.checkOptions[i] + ", ";
            }
        }
        return optionResult;
    }
    
    
    
}
