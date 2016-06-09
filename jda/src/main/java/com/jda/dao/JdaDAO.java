package com.jda.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jda.beans.Employee;
import com.jda.beans.Submissions;


public interface JdaDAO {
	
	public List<Submissions> getAllNames();	
	public long totalCount();

}
