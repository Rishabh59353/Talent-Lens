package com.talentlens.talent_lens.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    public ResumeController(PDFBoxExtractor pdfExtractor,
                            ResumeService resumeService) {
        this.pdfExtractor = pdfExtractor;
        this.resumeService = resumeService;
    }
	
    // Upload PDF and extract skills
    @PostMapping("/upload")
    public List<String> uploadResume(@RequestParam MultipartFile pdfFile) {
        try {
            // Save uploaded file temporarily
            File tempFile = File.createTempFile("resume-", ".pdf");
            pdfFile.transferTo(tempFile);
            
            // Extract text from PDF
            String text = pdfExtractor.extractTextFromFile(tempFile);
            
            if (text == null) {
                return List.of(); // Return empty list if extraction failed
            }
            
            // Extract skills from text
            List<String> skills = resumeService.extractSkills(text);
            
            // Delete temp file
            tempFile.delete();
            
            return skills;
        } catch (Exception e) {
            System.err.println("Error processing resume: " + e.getMessage());
            e.printStackTrace();
            return List.of();
        }
    }
}
