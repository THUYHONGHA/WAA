
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hong Ha
 */
@FacesValidator(value = "priceValidation")
public class PriceValidation implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        if (o == null) {
            return;
        }
        double price = Double.valueOf(o.toString());
        FacesMessage mess = new FacesMessage();
        if (price < 1) {
            mess.setDetail("The value \"" + price + "\" is smaller than the minimum value of 1.");
            throw new ValidatorException(mess);
        } else if (price > 100000) {
            mess.setDetail("The value \"" + price + "\" is larger than the maximum value of 100000.");
            throw new ValidatorException(mess);
        }

    }

}
