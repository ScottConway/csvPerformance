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
    public static void setRandomValues(Object o) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(o.getClass());
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
            case "java.lang.String":
                descriptor.getWriteMethod().invoke(o, RandomStringUtils.randomAlphanumeric(8, 32));
                break;
            case "int":
                descriptor.getWriteMethod().invoke(o, RandomUtils.nextInt());
                break;
            case "double":
                descriptor.getWriteMethod().invoke(o, RandomUtils.nextDouble());
                break;
            case "org.joda.time.DateTime":
                DateTime dateTime = DateTime.now().minusDays(RandomUtils.nextInt(1, 60));
                descriptor.getWriteMethod().invoke(o, dateTime);
                break;
        }
    }
}
