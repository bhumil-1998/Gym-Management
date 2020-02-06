package com.GymManagement.gym.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.GymManagement.gym.Entity.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(
			value = "SELECT * FROM user_details ud WHERE ud.user_name=:username and ud.password=:password"
			, nativeQuery = true)
	User checkLogin(@Param("username") String userName ,
			@Param("password") String password);

	User findByUserName(String userName); 

}
