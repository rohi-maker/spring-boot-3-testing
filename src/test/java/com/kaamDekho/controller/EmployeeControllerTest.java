package com.kaamDekho.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaamDekho.controllers.jobsImpl.EmployeeControllerImpl;
import com.kaamDekho.entity.EmployeeEntity;
import com.kaamDekho.models.request.Employee;
import com.kaamDekho.service.jobsImpl.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(EmployeeControllerImpl.class)
@RunWith(SpringRunner.class)

public class EmployeeControllerTest {

    @MockBean
    EmployeeServiceImpl employeeService;

    @Autowired
    MockMvc mockMvc;

    Employee employee;
    EmployeeEntity employeeEntity;

    ObjectMapper objectMapper = new ObjectMapper();


    @Before
    public void setupTestData() {

        employee = Employee.builder().employeeName("TEST").department("TEST DEPARTMENT").build();
        employeeEntity = EmployeeEntity.builder().name("TEST").department("TEST DEPARTMENT").id(1).build();
    }

    @Test
    @DisplayName("TEST: Should return the employee entity after saving employee")
    public void shouldReturnEmployeeAfterSavingTest() throws Exception {
        given(employeeService.saveEmployeeToDb(employee)).willReturn(employeeEntity);
        var result =this.mockMvc.perform(post("/save").
                        contentType(MediaType.APPLICATION_JSON).
                        content(objectMapper.writeValueAsString(employee))).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(employeeEntity.getName()));
    }


}
