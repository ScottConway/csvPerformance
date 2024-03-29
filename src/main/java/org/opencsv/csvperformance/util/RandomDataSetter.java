package org.opencsv.csvperformance.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.joda.time.DateTime;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

public class RandomDataSetter {
    public static void setRandomValues(Object o) {
        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(o.getClass());
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        for (PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors()) {
            try {
                setRandomValue(o, descriptor);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void setRandomValue(Object o, PropertyDescriptor descriptor) throws InvocationTargetException, IllegalAccessException {
        switch (descriptor.getPropertyType().getTypeName()) {
            case "char":
            case "java.lang.Character":
                descriptor.getWriteMethod().invoke(o, RandomStringUtils.randomAlphabetic(1).charAt(0));
                break;
            case "byte":
            case "java.lang.Byte":
                descriptor.getWriteMethod().invoke(o, RandomUtils.nextBytes(1)[0]);
                break;
            case "java.lang.String":
                descriptor.getWriteMethod().invoke(o, RandomStringUtils.randomPrint(128, 65000));
                break;
            case "int":
            case "java.lang.Integer":
                descriptor.getWriteMethod().invoke(o, RandomUtils.nextInt());
                break;
            case "double":
            case "java.lang.Double":
                descriptor.getWriteMethod().invoke(o, RandomUtils.nextDouble());
                break;
            case "long":
            case "java.lang.Long":
                descriptor.getWriteMethod().invoke(o, RandomUtils.nextLong());
                break;
            case "org.joda.time.DateTime":
                DateTime dateTime = DateTime.now().minusDays(RandomUtils.nextInt(1, 60));
                descriptor.getWriteMethod().invoke(o, dateTime);
                break;
        }
    }
}
