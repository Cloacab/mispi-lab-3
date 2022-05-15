package se.ifmo.web.controller;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.Arrays;

public class AreaCheckerTest {

    Class testingClass = AreaChecker.class;

    AreaChecker mockedCircle = getMockAreaChecker("Circle");

    AreaChecker mockedTriangle = getMockAreaChecker("Triangle");

    AreaChecker mockedRectangle = getMockAreaChecker("Rectangle");
    double xCircle = 1;

    double yCircle = -1;
    double radiusCircle = 3;
    @Test
    public void shouldCheckCorrectPointInArea() {
        // given
        // mock other methods to check only circle area


        System.out.println("Testing correct point for circle...");
        Assert.assertTrue(AreaChecker.checkAreas(xCircle, yCircle, radiusCircle));
    }

    @Test
    public void shouldCheckWrongPointInArea() {
        System.out.println("Testing wrong point for circle...");
    }

    @Test
    public void shouldMockAllFigures() {
        AreaChecker circle = getMockAreaChecker("Circle");
        System.out.println(Arrays.toString(circle.getClass().getMethods()));
    }

    private AreaChecker getMockAreaChecker(String figure) {
        return (AreaChecker) Proxy.newProxyInstance(
                testingClass.getClassLoader(),
                testingClass.getInterfaces(),
                (t, method, args) -> {
                    if (!method.getName().endsWith(figure)) {
                        return false;
                    }
                    return method.invoke(t, args);
                });
    }
}