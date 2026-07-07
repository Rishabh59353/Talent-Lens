package com.talentlens.talent_lens.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class ResumeService {
	
	private List<String> knownSkills = Arrays.asList(
	        // Programming Languages
	        "Java", "Python", "JavaScript", "C++", "C#", "Ruby", "Go", "Rust",
	        "TypeScript", "Kotlin", "Swift", "PHP", "SQL", "R", "Scala",
	        
	        // Backend Frameworks
	        "Spring Boot", "Spring MVC", "Django", "Flask", "Node.js", "Express",
	        "Hibernate", "JPA", "REST APIs", "Microservices",
	        
	        // Frontend
	        "React", "Angular", "Vue.js", "HTML5", "CSS3", "Bootstrap", 
	        "Tailwind CSS", "Redux", "jQuery",
	        
	        // Databases
	        "MySQL", "PostgreSQL", "MongoDB", "Oracle", "SQL Server", 
	        "Redis", "SQLite", "DynamoDB",
	        
	        // Cloud & DevOps
	        "AWS", "Azure", "Google Cloud", "Docker", "Kubernetes", 
	        "Jenkins", "Git", "Maven", "Gradle", "Nginx",
	        
	        // Data & AI
	        "Machine Learning", "Deep Learning", "TensorFlow", "PyTorch",
	        "Pandas", "NumPy", "Scikit-learn", "Big Data", "Hadoop",
	        
	        // Mobile
	        "Android", "iOS", "Flutter", "React Native"
	    );
	public List<String> extractSkills(String resumeText) {
        List<String> extractedSkills = new ArrayList<>();
        
        if (resumeText == null || resumeText.isEmpty()) {
            return extractedSkills;
        }
        
        // Convert text to lowercase for matching
        String lowerText = resumeText.toLowerCase();
        
        // Check each known skill
        for (String skill : knownSkills) {
        	
        	String escapedSkill = Pattern.quote(skill.toLowerCase());
        	
        	String regex = "\\b" + escapedSkill + "\\b";
        	
        	Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(lowerText);
        	
            if (matcher.find()) {
                extractedSkills.add(skill);
            }
        }
        
        return extractedSkills;
    }
}
