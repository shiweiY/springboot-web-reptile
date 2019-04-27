package com.reptile.tc58.model;

public class Job {
	private String title;//职位名称
	private String salary;//职位薪资
	private String address;//职位地址
	private String exp;//工作经验
	private String degree;//学历
	private String job_time;//发布时间
	private String job_link;//原网页链接
	private Company company;//公司信息
	
	
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
