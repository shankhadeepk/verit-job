package com.jda.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jda.beans.Employee;
import com.jda.beans.Submissions;



@Controller
public class JdaController {
	
private final static Logger LOGGER = Logger.getLogger(JdaController.class.getName()); 	
	
	private String restClientUrl;	
	
	public JdaController(String restClientUrl){
		this.restClientUrl=restClientUrl;
	}		
	@RequestMapping(value="/getsubmissions",method=RequestMethod.GET)
	public ModelAndView getAirportDetails(){
		LOGGER.info("get called :: restclienturl ::"+restClientUrl);
		
		ModelAndView model=new ModelAndView("index");
		RestTemplate restTemplate=new RestTemplate();
		String listOfAllSubmission=restTemplate.getForObject(restClientUrl+"/list", String.class);	
		String totalCount=restTemplate.getForObject(restClientUrl+"/analysis/tot", String.class);	
		
		Gson gson=new Gson();
		TypeToken<List<Submissions>> token = new TypeToken<List<Submissions>>() {};
		List<Submissions> listOfSubmissionFrmJson = gson.fromJson(listOfAllSubmission, token.getType());
       
		model.addObject("listOfSubmission", listOfSubmissionFrmJson);
		model.addObject("totalCount",totalCount);
		return model;
	}

}
