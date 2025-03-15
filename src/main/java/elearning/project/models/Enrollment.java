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
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentId;
    
    private Double progress;

    @ManyToOne
    @JoinColumn(name = "studentId")
    @JsonIgnore // Prevent recursion issue
    private User student;

    @ManyToOne
    @JoinColumn(name = "courseId")
    @JsonIgnore // Prevent recursion issue
    private Course course;
}
