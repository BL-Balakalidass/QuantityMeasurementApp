package com.app.quantitymeasurement.controller;

import com.app.quantitymeasurement.dto.QuantityInputDTO;
import com.app.quantitymeasurement.dto.QuantityMeasurementDTO;
import com.app.quantitymeasurement.service.QuantityMeasurementService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class QuantityMeasurementControllerTest {

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private QuantityMeasurementService service;

    @InjectMocks
    private QuantityMeasurementController controller;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    public void testCompareEndpoint() throws Exception {

        QuantityMeasurementDTO response =
                new QuantityMeasurementDTO();

        response.setResultString("true");

        Mockito.when(service.compare(any(QuantityInputDTO.class)))
                .thenReturn(response);

        QuantityInputDTO input =
                new QuantityInputDTO();

        mockMvc.perform(
                        post("/api/v1/quantities/compare")
                                .contentType(APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(input))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.resultString").value("true"));
    }

//    // ---------------- TEST: ADD ----------------
//    @Test
//    public void testAdd() throws Exception {
//
//        QuantityMeasurementDTO response = new QuantityMeasurementDTO();
//        response.setResultString("added");
//
//        Mockito.when(service.add(any(QuantityInputDTO.class)))
//                .thenReturn(response);
//
//        mockMvc.perform(post("/api/v1/quantities/add")
//                        .contentType(APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(new QuantityInputDTO())))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.resultString").value("added"));
//    }
//
//    // ---------------- TEST: SUBTRACT ----------------
//    @Test
//    public void testSubtract() throws Exception {
//
//        QuantityMeasurementDTO response = new QuantityMeasurementDTO();
//        response.setResultString("subtracted");
//
//        Mockito.when(service.subtract(any(QuantityInputDTO.class)))
//                .thenReturn(response);
//
//        mockMvc.perform(post("/api/v1/quantities/subtract")
//                        .contentType(APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(new QuantityInputDTO())))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.resultString").value("subtracted"));
//    }
//    // ---------------- TEST: DIVIDE ----------------
//    @Test
//    public void testDivide() throws Exception {
//
//        QuantityMeasurementDTO response = new QuantityMeasurementDTO();
//        response.setResultString("divided");
//
//        Mockito.when(service.divide(any(QuantityInputDTO.class)))
//                .thenReturn(response);
//
//        mockMvc.perform(post("/api/v1/quantities/divide")
//                        .contentType(APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(new QuantityInputDTO())))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.resultString").value("divided"));
//    }




}