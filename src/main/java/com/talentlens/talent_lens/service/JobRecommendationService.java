package com.talentlens.talent_lens.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.talentlens.talent_lens.model.Job;
import com.talentlens.talent_lens.model.JobMatch;

@Service
public class JobRecommendationService {
	private final List<Job> jobs = Arrays.asList(
	        new Job("Java Developer", "TechNova", "Backend",
	            Arrays.asList("Java", "Spring Boot", "MySQL", "REST APIs", "Hibernate")),

	        new Job("Backend Developer", "CodeSphere", "Backend",
	            Arrays.asList("Java", "Spring Boot", "Microservices", "Docker", "REST APIs")),

	        new Job("Frontend Developer", "Webify", "Frontend",
	            Arrays.asList("React", "JavaScript", "HTML5", "CSS3", "Bootstrap")),

	        new Job("Data Analyst", "DataMind", "Data",
	            Arrays.asList("SQL", "Python", "Pandas", "NumPy", "Tableau")),

	        new Job("Full Stack Developer", "DevWorks", "Full Stack",
	            Arrays.asList("Java", "Spring Boot", "React", "JavaScript", "MySQL"))
	    );

	    public List<JobMatch> recommendJobs(List<String> resumeSkills) {
	        List<String> normalizedResumeSkills = resumeSkills.stream()
	                .map(String::toLowerCase)
	                .collect(Collectors.toList());

	        List<JobMatch> matches = new ArrayList<>();

	        for (Job job : jobs) {
	            long matchedCount = job.getRequiredSkills().stream()
	                    .filter(skill -> normalizedResumeSkills.contains(skill.toLowerCase()))
	                    .count();

	            double score = ((double) matchedCount / job.getRequiredSkills().size()) * 100.0;
	            matches.add(new JobMatch(job, Math.round(score * 100.0) / 100.0));
	        }

	        return matches.stream()
	                .sorted(Comparator.comparingDouble(JobMatch::getMatchScore).reversed())
	                .limit(3)
	                .collect(Collectors.toList());
	    }
}
