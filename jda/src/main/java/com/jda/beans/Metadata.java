package com.jda.beans;

public class Metadata {
	
	private String level;
	private Integer rating;
	private Long users_attempted;
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Long getUsers_attempted() {
		return users_attempted;
	}
	public void setUsers_attempted(Long users_attempted) {
		this.users_attempted = users_attempted;
	}
	@Override
	public String toString() {
		return "Metadata [level=" + level + ", rating=" + rating + ", users_attempted=" + users_attempted + "]";
	}
	
	

}
