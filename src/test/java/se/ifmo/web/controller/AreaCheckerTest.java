package se.ifmo.web.controller;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class AreaCheckerTest {

    @Test
    public void shouldCheckCorrectPointInArea() {
        // given
        // mock other methods to check only circle area


        System.out.println("Testing correct point for circle...");
        Assert.assertTrue(AreaChecker.checkAreas(1, -1, 3));
    }

    @Test
    public void shouldCheckWrongPointInArea() {
        System.out.println("Testing wrong point for circle...");
        Assert.assertFalse(AreaChecker.checkAreas(-2, -4, 3));
    }

    @Test
    public void shouldCheckCorrectPointForTriangle() {
        System.out.println("Testing correct point for triangle...");
        Assert.assertTrue(AreaChecker.checkAreas(-1, -4, 5));
    }

    @Test
    public void shouldCheckCorrectPointForRectangle() {
        System.out.println("Testing correct point for rectangle...");
        Assert.assertTrue(AreaChecker.checkAreas(-1, -2, 5));
    }

    private AreaChecker getMockAreaChecker(String figure) {
        Class testingClass = AreaChecker.class;
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