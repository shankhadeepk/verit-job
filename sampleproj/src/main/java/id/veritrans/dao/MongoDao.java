package id.veritrans.dao;

import java.util.List;

import id.veritrans.beans.PaymentGateway;

public interface MongoDao {
	public void create(PaymentGateway payGt);
	public PaymentGateway readByName(String name);	
	public String getCount();
	public List<String> getAllNames();
}
