package elearning.project.models;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    private String username;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(unique = true)
    private String email;

    private String password;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true) 
    @JsonManagedReference(value="student-enroll") // Avoid infinite recursion
//    @JsonIgnore
    private List<Enrollment> enrollments;
    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL, orphanRemoval = true)
<<<<<<< HEAD
    @JsonManagedReference(value="instructor-course") // Avoid infinite recursion
//    JsonIgnore
    private List<Course> courses;
=======
    @JsonManagedReference(value="instructor-course") // Ensures courses are included in User JSON
    private Set<Course> courses;
>>>>>>> 42ca43c05f4e5c196d49f231a4e20f7e3f64fcb3

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    // @JsonManagedReference(value="user-submission")
	@JsonIgnore
    private List<Submission> submissions;
    

    public enum Role {
        STUDENT, INSTRUCTOR
    }
}
