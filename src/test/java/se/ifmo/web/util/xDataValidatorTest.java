package se.ifmo.web.util;

import org.junit.Assert;
import org.junit.Test;

import javax.faces.validator.ValidatorException;

public class xDataValidatorTest {
    private final xDataValidator validator = new xDataValidator();

    @Test
    public void shouldThrowExceptionOnWrongData() {
        Assert.assertThrows(ValidatorException.class, () -> {
            System.out.println("Trying to throw an error...");
            validator.validate(null, null, "wer");
        });
    }

    @Test
    public void shouldThrowExceptionOnNullData() {
        Assert.assertThrows(ValidatorException.class, () -> {
            System.out.println("Trying to throw an error...");
            validator.validate(null, null, null);
        });
    }

    @Test
    public void shouldValidateCorrectData() {
        String value = "34";
        System.out.printf("Checking value: %s ...\n", value);
        validator.validate(null, null, value);
    }
}