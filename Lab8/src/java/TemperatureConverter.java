
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hong Ha
 */
@FacesConverter(value = "TempConverter")
public class TemperatureConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string.equals("")) {
            return null;
        }

        String temptype = string.substring(0, 1);
        String tempvalue = string.substring(1);
        Temperature temp = new Temperature(tempvalue, temptype);
        return temp;

    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Temperature temp = (Temperature) o;

       
            if (temp.getTemptype().equalsIgnoreCase("F")) {
                return temp.getTemp() + " Fahrenheit";
            } else if (temp.getTemptype().equalsIgnoreCase("C")) {
                return temp.getTemp() + " Celcius";
            } else {
                return "0";
            }
       

   }

}
