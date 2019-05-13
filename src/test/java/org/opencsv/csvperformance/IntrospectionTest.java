package org.opencsv.csvperformance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.opencsv.csvperformance.domain.Simple10;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IntrospectionTest {
    private Simple10 simple10;
    private Class sClass = Simple10.class;

    @BeforeEach
    public void setUp() {
        simple10 = new Simple10();
    }

    @Test
    @DisplayName("Get a list of fields with reflection")
    public void getFieldsReflection() {
        Field[] fields = sClass.getFields();
        Field[] declaredFields = sClass.getDeclaredFields();

        assertEquals(10, declaredFields.length);
        assertEquals(0, fields.length);
    }

    @Test
    @DisplayName("Get a list of fields with introspection")
    public void getFieldsIntrospection() throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Simple10.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        assertNotNull(propertyDescriptors);
        // has one more because it has the class property.
        assertEquals(11, propertyDescriptors.length);
    }

}
