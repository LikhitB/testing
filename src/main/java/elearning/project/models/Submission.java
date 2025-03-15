package elearning.project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Submission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long submissionId;
	private Double score;

	@ManyToOne
	@JoinColumn(name = "assessmentId")
	@JsonIgnore // Prevent recursion issue
	private Assessment assessment;

	@ManyToOne
	@JoinColumn(name = "studentId")
	@JsonIgnore // Prevent recursion issue
	private User user;
}
