package com.talentlens.talent_lens.service;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;


@Service
public class PDFBoxExtractor {
	public String extractTextFromFile(File pdfFile) {
		try {
            // Load PDF document
            PDDocument document = PDDocument.load(pdfFile);
            
            // Extract text
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);
            
            // Close document
            document.close();
            
            return text;
        } catch (Exception e) {
            System.err.println("Error extracting PDF text: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
	}
}
