package id.veritrans.beans;

import org.springframework.data.annotation.Id;

public class PaymentGateway {
	@Id
	private String id;
	
	private String name;
	private String image;
	private String description;
	private String branding;
	private double rating;
	private double setup_fee;
	private String transaction_fees;
	private String how_to_url;
	private String currencies;
	
	
	
	public String getId() {
		return id;
	}	
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBranding() {
		return branding;
	}
	public void setBranding(String branding) {
		this.branding = branding;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public double getSetup_fee() {
		return setup_fee;
	}
	public void setSetup_fee(double setup_fee) {
		this.setup_fee = setup_fee;
	}
	public String getTransaction_fees() {
		return transaction_fees;
	}
	public void setTransaction_fees(String transaction_fees) {
		this.transaction_fees = transaction_fees;
	}
	public String getHow_to_url() {
		return how_to_url;
	}
	public void setHow_to_url(String how_to_url) {
		this.how_to_url = how_to_url;
	}
	public String getCurrencies() {
		return currencies;
	}
	public void setCurrencies(String currencies) {
		this.currencies = currencies;
	}
	

	@Override
	public String toString() {
		return "PaymentGateway [id=" + id + ", name=" + name + ", image=" + image + ", description=" + description
				+ ", branding=" + branding + ", rating=" + rating + ", setup_fee=" + setup_fee + ", transaction_fees="
				+ transaction_fees + ", how_to_url=" + how_to_url + ", currencies=" + currencies + "]";
	}
}
