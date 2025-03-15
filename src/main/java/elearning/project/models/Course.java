package elearning.project.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseID;

    private String title;
    private String description;
    private String contentURL;

    @ManyToOne
    @JoinColumn(name = "instructorID")
<<<<<<< HEAD
    @JsonBackReference(value="instructor-course")
=======
    @JsonBackReference(value="instructor-course") // Prevents infinite recursion, but allows data in User
>>>>>>> 42ca43c05f4e5c196d49f231a4e20f7e3f64fcb3
    private User instructor;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value="course-enroll")
    private List<Enrollment> enrollments;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Assessment> assessments;
}
