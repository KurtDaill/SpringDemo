package com.tcs.model;

public class Department {
	private long id;
	private long organizationId;
	private String name;
	public Department(long id, long organizationId, String name) {
		super();
		this.id = id;
		this.organizationId = organizationId;
		this.name = name;
	}
	public Department() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
