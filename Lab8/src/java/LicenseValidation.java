
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.faces.application.FacesMessage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hong Ha
 */
@FacesValidator(value="licenseValidation")
public class LicenseValidation implements Validator{

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        if(o==null)
            return;
        String license = o.toString();
        if(license.matches("[A-Z]{2,2}-[0-9]{2,2}-[A-Z]{2,2}"))
            return;
        FacesMessage mess = new FacesMessage("License plate is not valid.");
        throw new ValidatorException(mess);
    }
    
}
