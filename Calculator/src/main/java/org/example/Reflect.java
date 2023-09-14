package org.example;

import java.lang.reflect.Method;

public class Reflect {

    public static String executeFunction(String operation, String values, String cl) throws Exception {
        Class<?> c = Class.forName("java.lang.Math");
        Method m = c.getMethod(operation, double.class);

        return m.invoke(null, Double.valueOf(values)).toString();
    }

}
