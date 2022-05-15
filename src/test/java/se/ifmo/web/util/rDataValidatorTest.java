package se.ifmo.web.util;

import org.junit.Assert;
import org.junit.Test;

import javax.faces.validator.ValidatorException;

public class rDataValidatorTest {

    private final rDataValidator validator = new rDataValidator();

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

}