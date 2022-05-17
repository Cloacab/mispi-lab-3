package se.ifmo.web.util;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class yDataValidatorParametrizedTest {
    private yDataValidator validator;
    private final String value;

    public yDataValidatorParametrizedTest(String value) {
        this.value = value;
    }

    @Parameterized.Parameters
    public static List<String> arguments() {
        return Arrays.asList("1", "2", "-1", "2.5", "-4");
    }

    @Before
    public void setup() {
        validator = new yDataValidator();
    }

    @Test
    public void shouldNotThrowExceptionOnExecution() {
        System.out.printf("Checking value: %s ...\n", this.value);
        validator.validate(null, null, this.value);
    }
}