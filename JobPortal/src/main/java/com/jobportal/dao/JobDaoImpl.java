package com.jobportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jobportal.exceptions.JobNotFoundException;
import com.jobportal.model.Job;

public class JobDaoImpl implements IJobDao {
	Connection connection = null;
	// jobId , name, region , category , salary
	@Override
	public void addJob(Job job) {
		// TODO Auto-generated method stub
		
		try {
				 connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.insertQuery);
				
			
			statement.setInt(1, job.getJobId());
			statement.setString(2,job.getJobName());
			statement.setString(3,job.getRegion());
			statement.setString(4,job.getCategory());
			statement.setDouble(5,job.getSalary());
			statement.execute();
			
		}catch(Exception e) {
			
		}finally {
			try {
				if(connection!=null)connection.close();
			}catch(Exception e) {e.printStackTrace();}
		}
		
	}

	@Override
	public void updateJob(int jobId, double salary) {
		Connection connection = null;
		
		try {
			connection =DbConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.updateQuery);
			
			statement.setInt(1, jobId);
			statement.setDouble(2, salary);
			statement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(connection!=null)
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	@Override
	public void deleteJob(int jobId) {
		Connection connection = null;
		
		try {
			
			connection = DbConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.deleteQuery);
			
			statement.setInt(1,jobId);
			statement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			if(connection!=null) {
				try {
					connection.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public List<Job> findAllJobs() {
		Connection connection = null;

		List<Job> jobs = new ArrayList<>();
		try {
			connection = DbConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.query);
			
			ResultSet rs=statement.executeQuery();
				//booklist=new ArrayList<>();
			// jobId , name, region , category , salary

				while(rs.next()) {
					String name=rs.getString("name");
					String region=rs.getString("region");
					String category=rs.getString("category");
					int jobId=rs.getInt("jobId");
					double salary=rs.getDouble("salary");
					Job job=new Job(jobId , name, region , category , salary);
					jobs.add(job);
				}
		}catch(Exception e) {
			
		}finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return jobs;
	}

	@Override
	public List<Job> getJobByWord(String role) throws JobNotFoundException {
		List<Job> jobs = new ArrayList<>();
		
		try {
			connection = DbConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.querybyrole);
			statement.setString(1,role);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				String name=rs.getString("name");
				String region=rs.getString("region");
				String category=rs.getString("category");
				int jobId=rs.getInt("jobId");
				double salary=rs.getDouble("salary");
				Job job=new Job(jobId , name, region , category , salary);
				jobs.add(job);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return jobs;
	}

	@Override
	public List<Job> getByCategory(String category) throws JobNotFoundException {
List<Job> jobs = new ArrayList<>();
		
		try {
			connection = DbConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.querybycategory);
			statement.setString(1,category);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				String name=rs.getString("name");
				String region=rs.getString("region");
				String cate=rs.getString("category");
				int jobId=rs.getInt("jobId");
				double salary=rs.getDouble("salary");
				Job job=new Job(jobId , name, region , cate , salary);
				jobs.add(job);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return jobs;
		
	}

	@Override
	public List<Job> getBySalaryGreaterThan(double salary) throws JobNotFoundException {
List<Job> jobs = new ArrayList<>();
		
		try {
			connection = DbConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.querybysalary);
			statement.setDouble(1,salary);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				String name=rs.getString("name");
				String region=rs.getString("region");
				String category=rs.getString("category");
				int jobId=rs.getInt("jobId");
				double sal=rs.getDouble("salary");
				Job job=new Job(jobId , name, region , category , sal);
				jobs.add(job);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return jobs;
	}

	@Override
	public List<Job> getByRegionAndCategory(String region, String category) throws JobNotFoundException {
List<Job> jobs = new ArrayList<>();
		
		try {
			connection = DbConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.querybyroleandcategory);
			statement.setString(1,region);
			statement.setString(2,category);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				String name=rs.getString("name");
				String reg=rs.getString("region");
				String cate=rs.getString("category");
				int jobId=rs.getInt("jobId");
				double salary=rs.getDouble("salary");
				Job job=new Job(jobId , name, reg , cate , salary);
				jobs.add(job);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return jobs;
	}

	@Override
	public Job getById(int jobId) throws JobNotFoundException {
		
		Job job=null;
		try {
			connection = DbConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.querybyid);
			statement.setInt(1,jobId);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				String name=rs.getString("name");
				String region=rs.getString("region");
				String category=rs.getString("category");
				int jId=rs.getInt("jobId");
				double salary=rs.getDouble("salary");
				 job=new Job(jId , name, region , category , salary);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return job;
	}

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		Connection connection=null;
		try {
			 connection=DbConnection.openConnection();
			PreparedStatement statement=connection.prepareStatement(Queries.createquery);
			
		}catch(Exception e) {
			
		}finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		

	}

}
