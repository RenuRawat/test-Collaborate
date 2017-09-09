package com.niit.collaborate.Dao;

import java.util.List;

import com.niit.collaborate.Model.Jobs;



public interface JobsDao {

	
	public boolean createJob(Jobs job);
	public Jobs getJob(int jobId);
	public List<Jobs> getJobs();
	
	public boolean editJob(int jobId);
	public boolean deleteJob(int jobId);
	
}
