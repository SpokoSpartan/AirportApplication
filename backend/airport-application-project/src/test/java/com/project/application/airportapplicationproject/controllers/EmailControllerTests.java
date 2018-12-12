package com.project.application.airportapplicationproject.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.application.airportapplicationproject.DTOs.Email;
import com.project.application.airportapplicationproject.controller.EmailController;
import com.project.application.airportapplicationproject.services.EmailService;
import com.project.application.airportapplicationproject.utils.Mappings;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
public class EmailControllerTests {

    private final static String BASE_URL = Mappings.PORT_AUTOTESTS + Mappings.API_VERSION + Mappings.EMAIL;
    private MockMvc mockMvc;
    private static Email email;
    private static ObjectMapper mapper;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private EmailController emailController;

    @BeforeAll
    public static void init() {
        mapper = new ObjectMapper();
        email = new Email();
    }

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(emailController).build();
        email.setSubject("subject");
        email.setMessageContext("message context");
    }

    @Test
    public void whenEmailCreatedThenStatusOk() throws Exception {
        String jsonRequest = mapper.writeValueAsString(email);
        mockMvc.perform(post(BASE_URL + Mappings.CREATE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void whenMessageContextIsBlankThenReturnBadRequest() throws Exception {
        email.setMessageContext("");
        String jsonRequest = mapper.writeValueAsString(email);
        mockMvc.perform(post(BASE_URL + Mappings.CREATE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.success", Matchers.is(false)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.contains("The message can't be empty")));
    }

    @Test
    public void whenSubjectIsBlankThenReturnBadRequest() throws Exception {
        email.setSubject("");
        String jsonRequest = mapper.writeValueAsString(email);
        mockMvc.perform(post(BASE_URL + Mappings.CREATE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.success", Matchers.is(false)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.contains("The subject of the message is required")));
    }
}