package org.opencsv.csvperformance.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.opencsv.csvperformance.domain.Simple10;

import java.beans.IntrospectionException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RandomDataSetterTest {
    private Simple10 simple10;

    @BeforeEach
    public void setUp() {
        simple10 = new Simple10();
    }

    @Test
    @DisplayName("set random values in object")
    public void setRandomValues() throws IntrospectionException {
        RandomDataSetter.setRandomValues(simple10);
        assertNotNull(simple10.getText1());
    }
}
