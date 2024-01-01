package com.kaamDekho.controllers.jobsImpl;

import com.kaamDekho.controllers.jobs.EmployeeController;
import com.kaamDekho.entity.EmployeeEntity;
import com.kaamDekho.models.request.Employee;
import com.kaamDekho.service.jobs.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeControllerImpl implements EmployeeController {

    Logger logger = LoggerFactory.getLogger(EmployeeControllerImpl.class);

    @Autowired
    private EmployeeService employeeService;


    @Override
    public ResponseEntity<EmployeeEntity> saveEmployee(Employee employee) {
        logger.info("REQUEST RECEIVED FOR SAVE EMPLOYEE");
        logger.info("INSIDE CONTROLLER LAYER");
        return ResponseEntity.ok(employeeService.saveEmployeeToDb(employee));
    }
}
