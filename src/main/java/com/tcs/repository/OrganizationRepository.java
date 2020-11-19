package com.tcs.repository;




import com.tcs.model.Organization;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrganizationRepository extends JpaRepository <Organization, Long>{
	public List<Organization> findByAddress(String address);
	
	public Optional<Organization> findById(Long id);
}
