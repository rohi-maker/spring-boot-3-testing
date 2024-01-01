package com.kaamDekho.repository;

import com.kaamDekho.entity.EmployeeEntity;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class EmployeeRepositoryTests {

    @Autowired
    EmployeeRepository employeeRepository;


    private EmployeeEntity employee;

    @Before
    public void setupTestData() {
        // Given : Setup object or precondition
        employee = EmployeeEntity.builder()
                .name("MOHOSIN")
                .department("MIAH")
                .build();
    }

    @Test
    @DisplayName("TEST : Save Employee Entity To DB")
    public void shouldSaveEmployee() {
        EmployeeEntity savedResponse = employeeRepository.save(employee);
        Assertions.assertThat(savedResponse).isNotNull();
    }

    @Test
    @DisplayName("TEST: Should throw exception when entity to be saved is null")
    public void shouldThrowIllegalArgumentExceptionWhenEntityIsNullTest() {
        assertThrows(InvalidDataAccessApiUsageException.class, () -> {
            employeeRepository.save(null);
        });
    }

}
