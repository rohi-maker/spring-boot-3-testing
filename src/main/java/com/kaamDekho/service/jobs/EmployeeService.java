package com.kaamDekho.service.jobs;

import com.kaamDekho.entity.EmployeeEntity;
import com.kaamDekho.models.request.Employee;

public interface EmployeeService {

    public EmployeeEntity saveEmployeeToDb(Employee employee);
}
