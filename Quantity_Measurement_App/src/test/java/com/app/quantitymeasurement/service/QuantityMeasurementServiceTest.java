package com.app.quantitymeasurement.service;

import com.app.quantitymeasurement.dto.QuantityInputDTO;
import com.app.quantitymeasurement.dto.QuantityMeasurementDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class QuantityMeasurementServiceTest {

    @InjectMocks
    private QuantityMeasurementServiceImpl service;

    private QuantityInputDTO input;

    @Before
    public void setUp() {
        input = new QuantityInputDTO();
    }

    // ---------------- TEST: COMPARE ----------------
    @Test
    public void testCompare() {

        QuantityMeasurementDTO result = service.compare(input);

        assertNotNull(result);
        assertNotNull(result.getResultString());
    }

    // ---------------- TEST: CONVERT ----------------
    @Test
    public void testConvert() {

        QuantityMeasurementDTO result = service.convert(input);

        assertNotNull(result);
        assertNotNull(result.getResultString());
    }

    // ---------------- TEST: ADD ----------------
    @Test
    public void testAdd() {

        QuantityMeasurementDTO result = service.add(input);

        assertNotNull(result);
        assertNotNull(result.getResultString());
    }

    // ---------------- TEST: SUBTRACT ----------------
    @Test
    public void testSubtract() {

        QuantityMeasurementDTO result = service.subtract(input);

        assertNotNull(result);
        assertNotNull(result.getResultString());
    }

    // ---------------- TEST: DIVIDE ----------------
    @Test
    public void testDivide() {

        QuantityMeasurementDTO result = service.divide(input);

        assertNotNull(result);
        assertNotNull(result.getResultString());
    }

    // ---------------- TEST: HISTORY BY OPERATION ----------------
    @Test
    public void testGetOperationHistory() {

        assertNotNull(service.getOperationHistory("ADD"));
    }

    // ---------------- TEST: HISTORY BY TYPE ----------------
    @Test
    public void testGetMeasurementTypeHistory() {

        assertNotNull(service.getMeasurementTypeHistory("LENGTH"));
    }

    // ---------------- TEST: ERROR HISTORY ----------------
    @Test
    public void testErroredHistory() {

        assertNotNull(service.getErroredHistory());
    }

    // ---------------- TEST: COUNT ----------------
    @Test
    public void testGetOperationCount() {

        long count = service.getOperationCount("ADD");

        assertTrue(count >= 0);
    }
}