package elearning.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import elearning.project.models.User;

public interface UserRepo extends JpaRepository<User, Long>{
//	@Query(value="select * from user where username=:username",nativeQuery=true)
	public User findUserByUsername(String username);
	 
}
