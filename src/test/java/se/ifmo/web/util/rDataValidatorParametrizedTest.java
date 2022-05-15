package se.ifmo.web.util;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class rDataValidatorParametrizedTest {

    private rDataValidator validator;
    private final String value;

    public rDataValidatorParametrizedTest(String value) {
        this.value = value;
    }

    @Parameters
    public static List<String> arguments() {
        return Arrays.asList("1", "2", "3", "2.5");
    }

    @Before
    public void setup() {
        validator = new rDataValidator();
    }

    @Test
    public void shouldNotThrowExceptionOnExecution() {
        System.out.printf("Checking value: %s ...\n", this.value);
        validator.validate(null, null, this.value);
    }

}