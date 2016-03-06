package id.veritrans.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import id.veritrans.beans.PaymentGateway;

@Controller
public class VeritransController {
	
	private final static Logger LOGGER = Logger.getLogger(VeritransController.class.getName()); 
	
	private String restClientUrl;
	
	public VeritransController(String restClientUrl){
		this.restClientUrl=restClientUrl;
	}
	
		
	@RequestMapping(value="/getpaymentgate",method=RequestMethod.GET)
	public ModelAndView getPaymentDetails(){
		LOGGER.info("getpayment called");
		List<PaymentGateway> paymentGatewayList=new ArrayList<PaymentGateway>();
		
		ModelAndView model=new ModelAndView("index");
		RestTemplate restTemplate=new RestTemplate();
		String listOfPayment=restTemplate.getForObject(restClientUrl+"/list", String.class);
		Gson gson=new Gson();
		List<String> listOfNames=gson.fromJson(listOfPayment, List.class);
		
		LOGGER.info("List of payment gateway names::"+listOfPayment);
		model.addObject("listofnames",listOfNames);
			
		for(String gatewayName:listOfNames){
			PaymentGateway payment=restTemplate.getForObject(restClientUrl+"/search?query="+gatewayName, PaymentGateway.class);			
			paymentGatewayList.add(payment);		
		}
		LOGGER.info("List of payment gateway objects::"+paymentGatewayList);
		
		model.addObject("listofpayobjs", paymentGatewayList);
		return model;
	}
	
}
