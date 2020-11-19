package com.tcs.repository;

import com.tcs.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	public Optional<Employee> findById(Long id);
	
	public List<Employee> findByDepartmentID(Long departmentId);
}
