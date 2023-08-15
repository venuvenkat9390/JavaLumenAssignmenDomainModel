package com.jobportal.model;

public class Job {
	
	// jobId , name, region , category , salary
	
	private Integer jobId;// 1 2 3
	private String jobName;// ias scriptWriter
	private String region;// global india 
	private String category;// freelance fulltime government
	private double Salary;
	public Job() {
		super();
	}
	public Job(Integer jobId, String jobName, String region, String category, double salary) {
		super();
		this.jobId = jobId;
		this.jobName = jobName;
		this.region = region;
		this.category = category;
		Salary = salary;
	}
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", jobName=" + jobName + ", region=" + region + ", category=" + category
				+ ", Salary=" + Salary + "]";
	}
	
	
}
