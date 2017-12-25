
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.faces.application.FacesMessage;
import javax.faces.validator.FacesValidator;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hong Ha
 */
@FacesValidator(value="brandValidation")
public class BrandValidation implements Validator{

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
       if(o==null){
           return ;
       }
       String brand = o.toString();
       if(brand.equalsIgnoreCase("Mercedes")||brand.equalsIgnoreCase("BMW"))
           return;
       FacesMessage mess = new FacesMessage("Invalid Brand");
       throw new ValidatorException(mess);
    }
    
}
