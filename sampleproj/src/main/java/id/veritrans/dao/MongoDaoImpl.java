package id.veritrans.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import id.veritrans.beans.PaymentGateway;

public class MongoDaoImpl implements MongoDao{
	private MongoOperations mongoOps;
	private static final String PAYMENT_GATEWAY_COLL="paymentgateway";

	public MongoDaoImpl(MongoOperations mongoOps) {
		super();
		this.mongoOps = mongoOps;
	}
	public void create(PaymentGateway payGt){
		this.mongoOps.insert(payGt,PAYMENT_GATEWAY_COLL);
	}
	public PaymentGateway readByName(String name){
		Query query=new Query(Criteria.where("name").is(name));
		return this.mongoOps.findOne(query, PaymentGateway.class,PAYMENT_GATEWAY_COLL);
	}
	
	public String getCount(){
		long count = this.mongoOps.count(new Query(), PAYMENT_GATEWAY_COLL);
		
		return String.valueOf(count);
	}
	public List<String> getAllNames() {
		
		List<PaymentGateway> listOfAllNames=this.mongoOps.findAll(PaymentGateway.class, PAYMENT_GATEWAY_COLL);
		List<String> listOfNames=new ArrayList<String>();
		for(PaymentGateway paymentGatewayName:listOfAllNames){
			listOfNames.add(paymentGatewayName.getName());
		}		
		return listOfNames;
	}
}
