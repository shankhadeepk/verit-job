package com.jda.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.jda.dao.JdaDAO;

@RestController
public class JdaRestController {

	private final static Logger LOGGER = Logger.getLogger(JdaRestController.class.getName());

	@Autowired
	private JdaDAO jdaDao;

	@RequestMapping(value="/list",method=RequestMethod.GET)
	@ResponseBody
	public String getAllNames(){

		LOGGER.info("Getting All submission details");
		Gson gson=new Gson();
		String result = gson.toJson(jdaDao.getAllNames());
		LOGGER.debug("Rest response :: "+result);

		return result;
		

	}
	@RequestMapping(value="/analysis/tot",method=RequestMethod.GET)
	@ResponseBody
	public String analysisTotal(){
		LOGGER.info("analysisTotal");
		Gson gson=new Gson();
		return gson.toJson(jdaDao.totalCount());


	}

}
