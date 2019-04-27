package com.reptile.lagou.model;

public class Job {
	private String title;
	private String salary;
	private String address;
	private String exp;
	private String degree;
	private String job_time;
	private String job_link;
	private Company company;
	
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getJob_time() {
		return job_time;
	}

	public void setJob_time(String job_time) {
		this.job_time = job_time;
	}

	public String getJob_link() {
		return job_link;
	}

	public void setJob_link(String job_link) {
		this.job_link = job_link;
	}
	
	
	public Job() {
		super();
	}

	public Job(String title, String salary, String address, String exp, String degree, String job_time, String job_link,
			Company company) {
		super();
		this.title = title;
		this.salary = salary;
		this.address = address;
		this.exp = exp;
		this.degree = degree;
		this.job_time = job_time;
		this.job_link = job_link;
		this.company = company;
	}
	
}
