package elearning.project.servicesubmission;

import elearning.project.models.Submission;
import elearning.project.repositories.SubmissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubmissionServiceImpl implements SubmissionService {

    @Autowired
    private SubmissionRepo submissionRepository;

    @Override
    public Submission createSubmission(Submission submission) {
        return submissionRepository.save(submission);
    }

    @Override
    public List<Submission> getAllSubmissions() {
        return submissionRepository.findAll();
    }

    @Override
    public Optional<Submission> getSubmissionById(Long id) {
        return submissionRepository.findById(id);
    }

    @Override
    public Submission updateSubmission(Long id, Submission submissionDetails) {
        Submission submission = submissionRepository.findById(id).orElseThrow(() -> new RuntimeException("Submission not found"));
        submission.setScore(submissionDetails.getScore());
        submission.setAssessment(submissionDetails.getAssessment());
        submission.setUser(submissionDetails.getUser());
        return submissionRepository.save(submission);
    }

    @Override
    public void deleteSubmission(Long id) {
        submissionRepository.deleteById(id);
    }
}