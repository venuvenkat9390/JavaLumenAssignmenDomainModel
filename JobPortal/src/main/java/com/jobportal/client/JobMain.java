package com.jobportal.client;

import com.jobportal.dao.IJobDao;
import com.jobportal.dao.JobDaoImpl;
import com.jobportal.model.Job;
import com.jobportal.service.IJobService;
import com.jobportal.service.JobServiceImpl;

// jobId , name, region , category , salary


public class JobMain {

	public static void main(String[] args) {
		IJobService jobService = new JobServiceImpl();
		
//		jobdao.createTable();
		
		jobService.addJob(new Job(1,"SDE","Banglore","FullTime",742000));
		
		System.out.println(jobService.findAllJobs().toString());
		
		
		
	}
}
