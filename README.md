# TalentLens - Resume Skill Extractor and Job Recommender

TalentLens is a web application that analyzes uploaded PDF resumes, extracts key skills, and recommends matching jobs based on the resume content.

## Features

- Upload PDF resumes.
- Extract skills from resume content.
- Recommend relevant jobs based on extracted skills.
- Display match score for each recommended job.
- Clean and responsive UI built with Bootstrap.

## Tech Stack

- Java
- Spring Boot
- Thymeleaf
- Bootstrap 5
- JavaScript
- HTML/CSS

## How It Works

1. User uploads a PDF resume.
2. The frontend sends the file to `/api/resume/upload`.
3. The backend processes the resume and extracts skills.
4. The system returns recommended jobs with match scores.
5. Results are displayed on the page.

## Project Structure

```bash
src/
 ├── main/
 │   ├── java/
 │   ├── resources/
 │   │   ├── templates/
 │   │   ├── static/
 │   │   └── application.properties
```

## Setup Instructions

### Prerequisites
- Java 17 or higher
- Maven
- Spring Boot

### Run the Project

```bash
git clone <your-repo-url>
cd <your-project-folder>
mvn spring-boot:run
```

Then open:

```bash
http://localhost:8080
```

## API Endpoint

### Upload Resume
**POST** `/api/resume/upload`

**Request:**
- multipart/form-data
- field name: `pdfFile`

**Response Example:**
```json
{
  "skills": ["Java", "Spring Boot", "MySQL"],
  "recommendedJobs": [
    {
      "job": {
        "title": "Java Developer",
        "company": "TechCorp",
        "domain": "Software Development"
      },
      "matchScore": 92
    }
  ]
}
```

## Future Enhancements

- Add OCR support for image-based resumes.
- Improve job matching with AI/ML.
- Add user login and resume history.
- Export results as PDF.

## License

This project is for educational/demo purposes.