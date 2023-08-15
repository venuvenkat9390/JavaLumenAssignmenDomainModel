package com.jobportal.service;

import java.util.ArrayList;
import java.util.List;

import com.jobportal.dao.IJobDao;
import com.jobportal.dao.JobDaoImpl;
import com.jobportal.exceptions.JobNotFoundException;
import com.jobportal.model.Job;

public class JobServiceImpl implements IJobService{
	
	IJobDao jobdao= new JobDaoImpl();

	@Override
	public void addJob(Job JOB) {
		// TODO Auto-generated method stub
		jobdao.addJob(JOB);
		
	}

	@Override
	public void updateJob(int jobId, double salary) {
		// TODO Auto-generated method stub
		jobdao.updateJob(jobId, salary);
	}

	@Override
	public void deleteJob(int jobId) {
		// TODO Auto-generated method stub
		jobdao.deleteJob(jobId);
	}

	@Override
	public List<Job> findAllJobs() {
		// TODO Auto-generated method stub
		List<Job> jobs = new ArrayList<>();
		jobs=jobdao.findAllJobs();
		if(jobs.size()==0)throw new JobNotFoundException("No Jobs found for now!!! Please catch up later");
		return jobs;
	}

	@Override
	public List<Job> getJobByWord(String role) throws JobNotFoundException {
		// TODO Auto-generated method stub
		List<Job> jobs = new ArrayList<>();
		jobs=jobdao.getJobByWord(role);
		if(jobs.size()==0)throw new JobNotFoundException("No Jobs found with the role u have entered plss enter the correct role");
		return jobs;
	}

	@Override
	public List<Job> getByCategory(String category) throws JobNotFoundException {
		List<Job> jobs = new ArrayList<>();
		jobs=jobdao.getByCategory(category);
		if(jobs.size()==0)throw new JobNotFoundException("No Jobs found with the given category");
		return jobs;
	}

	@Override
	public List<Job> getBySalaryGreaterThan(double salary) throws JobNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Job> getByRoleContainsAndCategory(String role, String category) throws JobNotFoundException {
		List<Job> jobs = new ArrayList<>();
		jobs=jobdao.getByRegionAndCategory(role,category);
		if(jobs.size()==0)throw new JobNotFoundException("No Jobs found for now!!! with the qualituies u have mentioned");
		return jobs;
	}

	@Override
	public Job getById(int bookId) throws JobNotFoundException {
		Job job = jobdao.getById(bookId);
		if(job==null)throw new JobNotFoundException("Job not found with the given id");
		return job;
	}

}
