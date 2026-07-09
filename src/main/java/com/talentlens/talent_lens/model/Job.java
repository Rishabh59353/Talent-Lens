package com.talentlens.talent_lens.model;

import java.util.List;

public class Job {
	 private String title;
	    private String company;
	    private String domain;
	    private List<String> requiredSkills;

	    public Job() {
	    }

	    public Job(String title, String company, String domain, List<String> requiredSkills) {
	        this.title = title;
	        this.company = company;
	        this.domain = domain;
	        this.requiredSkills = requiredSkills;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getCompany() {
	        return company;
	    }

	    public void setCompany(String company) {
	        this.company = company;
	    }

	    public String getDomain() {
	        return domain;
	    }

	    public void setDomain(String domain) {
	        this.domain = domain;
	    }

	    public List<String> getRequiredSkills() {
	        return requiredSkills;
	    }

	    public void setRequiredSkills(List<String> requiredSkills) {
	        this.requiredSkills = requiredSkills;
	    }
}
