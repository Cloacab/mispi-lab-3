package se.ifmo.web.util;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Validates x coordinate
 */
@FacesValidator("xDataValidator")
public class xDataValidator implements Validator {

    /**
     * Validates something
     * @param context context
     * @param component component
     * @param value x coordinate
     * @throws ValidatorException if x coordinate is in the wrong format
     */
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        FacesMessage message = new FacesMessage();
        if (value == null) {
            message.setSummary("Требуется ввести значение");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
        if (!(value.toString().matches("[-+]?[0-9]*[.,]?[0-9]+(?:[eE][-+]?[0-9]+)?"))) {
            message.setSummary("Неверный формат данных");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
}
