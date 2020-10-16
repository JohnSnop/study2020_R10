package com.wf.demo.test;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wf
 * @create 2020-09-26 21:40
 * @desc
 **/
public class ReflectTest {
    @Test
    public void test1() {
        Class<Student> studentClass = Student.class;
        Constructor<?>[] constructors = studentClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println();
        Method[] declaredMethods = studentClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        System.out.println();
        Method[] methods = studentClass.getMethods();
        for (Method declaredMethod : methods) {
            System.out.println(declaredMethod);
        }
        System.out.println();
        Field[] fields = studentClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println();
        Field[] declaredFields = studentClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }
    }

    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        Method main = reflectTestClass.getMethod("main", String[].class);

        String[] args = {"a", "b", "c"};
        main.invoke(null, (Object)args);
        main.invoke(null, new Object[]{args});

    }

    public static void main(String[] args) {
        System.out.println(args[0]);
    }
}
