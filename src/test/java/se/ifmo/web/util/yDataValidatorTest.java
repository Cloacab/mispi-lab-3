package se.ifmo.web.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.faces.validator.ValidatorException;

public class yDataValidatorTest {
    private final yDataValidator validator = new yDataValidator();

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
        String value = "2";
        System.out.printf("Checking value: %s ...\n", value);
        validator.validate(null, null, value);
    }
}