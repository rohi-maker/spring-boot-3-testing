package com.kaamDekho.service;

import com.kaamDekho.entity.EmployeeEntity;
import com.kaamDekho.models.request.Employee;
import com.kaamDekho.repository.EmployeeRepository;
import com.kaamDekho.service.jobsImpl.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeServiceImpl employeeService;
    private Employee employee;
    private EmployeeEntity employeeEntity;

    @Before
    public void setupTestData() {

        employee = Employee.builder().employeeName("TEST").department("TEST DEPARTMENT").build();
        employeeEntity = EmployeeEntity.builder().name("TEST").department("TEST DEPARTMENT").build();
    }

    @Test
    @DisplayName("TEST: SHOULD SAVE EMPLOYEE RECORD IN DB")
    public void shouldSaveEmployeeRecordInDb() {
        EmployeeEntity newEmployeeEntity = EmployeeEntity.builder().name("TEST").department("TEST DEPARTMENT").id(1).build();
        given(employeeRepository.save(employeeEntity)).willReturn(newEmployeeEntity);
        EmployeeEntity saved = employeeService.saveEmployeeToDb(employee);
        Assertions.assertNotNull(saved);
        Assertions.assertEquals(1, saved.getId());
    }

    @Test
    @DisplayName("TEST: SHOULD THROW RUNTIME EXCEPTION WHEN EMPLOYEE RECORD IS NOT SAVED")
    public void shouldThrowRunTimeExceptionWhenEmployeeNotSaved(){
        // PRECONDITION OF THE LAYER WHICH WE ARE MOCKING
        given(employeeRepository.save(employeeEntity)).willReturn(null);

        // THE ABOVE PRECONDITIONS WILL BE APPLIED, AND WE WILL ASSERT ITS RESULTS
        assertThrows(RuntimeException.class,()->{employeeService.saveEmployeeToDb(employee);});
    }
}
