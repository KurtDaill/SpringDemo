package com.tcs.repository;

import com.tcs.model.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	public List<Department> findByOrganization(Long organizationId);
	
	public Optional<Department> findById(Long id);
}
