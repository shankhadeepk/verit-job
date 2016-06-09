package com.jda.beans;

public class Submissions {
	
	private Integer submissionId;
	private String title;
	private Metadata metadata;
	private String source;
	private String status;
	private String language;
	public Integer getSubmissionId() {
		return submissionId;
	}
	public void setSubmissionId(Integer submissionId) {
		this.submissionId = submissionId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Metadata getMetadata() {
		return metadata;
	}
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "Submissions [submissionId=" + submissionId + ", title=" + title + ", metadata=" + metadata + ", source="
				+ source + ", status=" + status + ", language=" + language + "]";
	}
	
	
	

}
