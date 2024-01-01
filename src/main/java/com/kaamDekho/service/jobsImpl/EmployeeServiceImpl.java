package com.kaamDekho.service.jobsImpl;

import com.kaamDekho.controllers.jobsImpl.EmployeeControllerImpl;
import com.kaamDekho.entity.EmployeeEntity;
import com.kaamDekho.models.request.Employee;
import com.kaamDekho.repository.EmployeeRepository;
import com.kaamDekho.service.jobs.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Logger logger = LoggerFactory.getLogger(EmployeeControllerImpl.class);


    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeEntity saveEmployeeToDb(Employee employee) {
        logger.info("REQUEST RECEIVED TO SAVE EMPLOYEE IN SERVICE LAYER");
        logger.info("INSIDE THE SERVICE LAYER");
        EmployeeEntity employeeEntity = EmployeeEntity.builder().name(employee.getEmployeeName()).department(employee.getDepartment()).build();
        EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);
        if (Objects.isNull(savedEmployee)) {
            logger.error("ERROR WHILE SAVING EMPLOYEE RECORD TO DB");
            throw new RuntimeException("Error while saving Employee entity");
        }
        return savedEmployee;
    }
}
