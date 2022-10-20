package com.nestdigital.employee.Dao;

import com.nestdigital.employee.Model.EmployeeModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDao extends CrudRepository<EmployeeModel,Integer> {

    @Modifying
    @Query(value = "DELETE FROM `employees` WHERE `id`=:id",nativeQuery = true)
    void deleteEmployeeById(Integer id);

    @Query(value = "SELECT `id`, `company`, `designation`, `dob`, `doj`, `email`, `empcode`, `name`, `phone`, `salary` FROM `employees` WHERE `name`=:name",nativeQuery = true)
    List<EmployeeModel> searchemployee(String name);
}
