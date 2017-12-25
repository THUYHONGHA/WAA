/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hong Ha
 */
import java.io.Serializable;

public class Temperature implements Serializable {

    private String temp;
    private String temptype;

    public Temperature(String temp, String temptype) {
        this.temp = temp;
        this.temptype = temptype;
    }

    public void setTemptype(String temptype) {
        this.temptype = temptype;
    }

    public String getTemptype() {
        return temptype;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getTemp() {
        return temp;
    }

}
