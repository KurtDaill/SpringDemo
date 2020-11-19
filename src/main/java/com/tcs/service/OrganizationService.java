package com.tcs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.model.Organization;
import com.tcs.repository.OrganizationRepository;

@Service
public class OrganizationService {
	@Autowired
	OrganizationRepository organizationRepository;
	
	public String CreateEmployee(Organization org) {
		// TODO Auto-generated method stub
		Organization tempOrg = null;
		try {
			tempOrg = organizationRepository.save(org);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}
	
	public List<Organization> findByDepartmentId(String address){
		return organizationRepository.findByAddress(address);
	}
	
	public Optional<Organization> findById(Long id){
		return organizationRepository.findById(id);
	}
}
