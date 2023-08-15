package com.jobportal.dao;

public class Queries {
	public static final String createquery="create table Jobs(jobId int primary key, name varchar(200),region varchar(100),category varchar(100),  salary float)";
	public static final String insertQuery="insert into Jobs values(?,?,?,?,?)";
	public static final String updateQuery="update Jobs set salary=? where jobId=?";
	public static final String deleteQuery="delete from Jobs where jobId=?";
	public static final String query="select * from Jobs";
	public static final String querybyid="select * from Jobs where jobId=?";
	public static final String querybyrole="select * from Jobs where role like '%?%'";
	public static final String querybycategory="select * from Jobs where category=?";
	public static final String querybysalary="select * from Jobs where salary>?";
	public static final String querybyroleandcategory="select * from Jobs where role=? and category=? ";
	

}


// jobId , name, region , category , salary