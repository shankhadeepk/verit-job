package com.jda.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.jda.beans.Employee;
import com.jda.beans.Submissions;


public class JdaDaoImpl implements JdaDAO{
	private final static Logger LOGGER = Logger.getLogger(JdaDaoImpl.class.getName());
	
	private MongoOperations mongoTemplate;	
	
	private String collectionName;

	public JdaDaoImpl(MongoOperations mongoTemplate,String collectionName) {
		super();
		this.mongoTemplate = mongoTemplate;
		this.collectionName=collectionName;
	}
	public JdaDaoImpl() {
		super();
	}

	public List<Submissions> getAllNames() {
		LOGGER.info("getAllNames called");

		List<Submissions> listOfSubmissions=this.mongoTemplate.findAll(Submissions.class, collectionName);		
		LOGGER.debug("getAllNames called:: List of submissions ::"+listOfSubmissions);
		
		return listOfSubmissions;
	}
	
	public Employee readByName(String code){
		Query query=new Query(Criteria.where("id").is(code));
		return this.mongoTemplate.findOne(query, Employee.class,collectionName);
	}
	public long totalCount() {
		
		return this.mongoTemplate.count(new Query(), Submissions.class);
	}


}
