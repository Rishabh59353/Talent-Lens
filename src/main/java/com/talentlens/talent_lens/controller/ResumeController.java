package com.talentlens.talent_lens.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.talentlens.talent_lens.model.AnalysisResponse;
import com.talentlens.talent_lens.model.JobMatch;
import com.talentlens.talent_lens.service.JobRecommendationService;
import com.talentlens.talent_lens.service.PDFBoxExtractor;
import com.talentlens.talent_lens.service.ResumeService;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {
	
	/*
	 * @Autowired
	 *  private PDFBoxExtractor pdfExtractor;
	 * 
	 * @Autowired 
	 * private ResumeService resumeService;
	 */
	
	
	private final PDFBoxExtractor pdfExtractor;
    private final ResumeService resumeService;
    private final JobRecommendationService jobRecommendationService;

    public ResumeController(PDFBoxExtractor pdfExtractor,
                            ResumeService resumeService,
                            JobRecommendationService jobRecommendationService) {
        this.pdfExtractor = pdfExtractor;
        this.resumeService = resumeService;
        this.jobRecommendationService = jobRecommendationService;
    }
	
    // Upload PDF and extract skills
    @PostMapping("/upload")
    public AnalysisResponse uploadResume(@RequestParam MultipartFile pdfFile) {
        try {
            File tempFile = File.createTempFile("resume-", ".pdf");
            pdfFile.transferTo(tempFile);

            String text = pdfExtractor.extractTextFromFile(tempFile);

            tempFile.delete();

            if (text == null) {
                return new AnalysisResponse(List.of(), List.of());
            }

            List<String> skills = resumeService.extractSkills(text);
            List<JobMatch> recommendedJobs = jobRecommendationService.recommendJobs(skills);

            return new AnalysisResponse(skills, recommendedJobs);

        } catch (Exception e) {
            e.printStackTrace();
            return new AnalysisResponse(List.of(), List.of());
        }
    }
}
