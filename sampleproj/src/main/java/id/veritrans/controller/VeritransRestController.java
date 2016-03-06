package id.veritrans.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import id.veritrans.dao.MongoDao;

@RestController
public class VeritransRestController {
	
	private final static Logger LOGGER = Logger.getLogger(VeritransRestController.class.getName()); 
	
	@Autowired
	private MongoDao mongoDao;
	
	@RequestMapping(value="/count",method=RequestMethod.GET)
	@ResponseBody
	public String getCount(){
		LOGGER.info("Getting the count from the db");
		return mongoDao.getCount();
	}
	@RequestMapping(value="/search",method=RequestMethod.GET)
	@ResponseBody
	public String getInfoFromName(@RequestParam(value="query",required=false) String query){
		LOGGER.info("Getting the information for query "+query+" from the db");
		if(query!=null){
			Gson gson=new Gson();
			return gson.toJson(mongoDao.readByName(query));
		}
		else
			return "Data not found! please provide query param";
		
	}
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@ResponseBody
	public String getAllNames(){
		LOGGER.info("Getting All names from DB");
		Gson gson=new Gson();
		return gson.toJson(mongoDao.getAllNames());		
	}
}
