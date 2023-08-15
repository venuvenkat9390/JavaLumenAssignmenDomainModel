package com.jobportal.dao;

import java.util.List;

import com.jobportal.exceptions.JobNotFoundException;
import com.jobportal.model.Job;

//jobId , name, region , category , salary

public interface IJobDao {
	
	void addJob(Job JOB);
	void updateJob(int jobId,double salary);
	void deleteJob(int jobId);

	
	
	List<Job> findAllJobs();
	List<Job> getJobByWord(String role) throws JobNotFoundException;
	List<Job> getByCategory(String category) throws JobNotFoundException;
	List<Job> getBySalaryGreaterThan(double salary) throws JobNotFoundException;
	List<Job> getByRegionAndCategory(String region,String category) throws JobNotFoundException;
	Job getById(int bookId) throws JobNotFoundException;
	void createTable();

}
