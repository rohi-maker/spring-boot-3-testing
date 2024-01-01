package com.kaamDekho.controllers.jobs;

import com.kaamDekho.entity.EmployeeEntity;
import com.kaamDekho.models.request.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface EmployeeController {

    @PostMapping("/save")
    ResponseEntity<EmployeeEntity> saveEmployee(@RequestBody Employee employee);

}
