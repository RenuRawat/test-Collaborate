package com.niit.collaborate.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.Dao.JobsDao;
import com.niit.collaborate.Model.Jobs;

@Repository("jobsDao")
public class JobsDaoImpl implements JobsDao {
	
	
	@Autowired
	SessionFactory sessionFactory;
	
	public JobsDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory=sessionFactory;
	}
	

	@Transactional
	public boolean createJob(Jobs job) {
		try {
			sessionFactory.getCurrentSession().save(job);
			System.out.println("Insert the table");
		return true;
		} catch(Exception e) {
			System.out.println("Exception Arised:" +e);
			return false;
		}
	}

	
	public Jobs getJob(int jobId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Jobs> getJobs() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean editJob(int jobId) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean deleteJob(int jobId) {
		// TODO Auto-generated method stub
		return false;
	}

}
