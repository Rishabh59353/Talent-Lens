package com.talentlens.talent_lens.model;

public class JobMatch {
	private Job job;
    private double matchScore;

    public JobMatch() {
    }

    public JobMatch(Job job, double matchScore) {
        this.job = job;
        this.matchScore = matchScore;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public double getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(double matchScore) {
        this.matchScore = matchScore;
    }
}
