package com.talentlens.talent_lens.model;

import java.util.List;

public class AnalysisResponse {
	 private List<String> skills;
	    private List<JobMatch> recommendedJobs;

	    public AnalysisResponse() {
	    }

	    public AnalysisResponse(List<String> skills, List<JobMatch> recommendedJobs) {
	        this.skills = skills;
	        this.recommendedJobs = recommendedJobs;
	    }

	    public List<String> getSkills() {
	        return skills;
	    }

	    public void setSkills(List<String> skills) {
	        this.skills = skills;
	    }

	    public List<JobMatch> getRecommendedJobs() {
	        return recommendedJobs;
	    }

	    public void setRecommendedJobs(List<JobMatch> recommendedJobs) {
	        this.recommendedJobs = recommendedJobs;
	    }
}
